import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ShoppingListService } from '../../service/shopping-list.service';
import { ShoppingListDetails } from '../../model/shopping-list-details';

@Component({
  selector: 'app-shopping-list-details-view',
  templateUrl: './shopping-list-details-view.component.html',
  standalone: false
})
export class ShoppingListDetailsViewComponent implements OnInit {
  shoppingList: ShoppingListDetails | undefined;

  constructor(
    private route: ActivatedRoute,
    private service: ShoppingListService
  ) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.service.getShoppingListDetails(id).subscribe(
        list => this.shoppingList = list
      );
    }
  }
}
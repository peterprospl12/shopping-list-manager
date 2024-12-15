import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ShoppingListService } from '../../service/shopping-list.service';
import { ShoppingListDetails } from '../../model/shopping-list-details';

@Component({
  selector: 'app-shopping-list-edit',
  templateUrl: './shopping-list-edit.component.html',
  styleUrls: ['./shopping-list-edit.component.css'],
  standalone: false
})
export class ShoppingListEditComponent implements OnInit {
  shoppingList: ShoppingListDetails = {
    id: '',
    name: '',
    date: new Date().toISOString(),
    status: 'ACTIVE',
    userId: '',
    products: []
  };

  statuses = ['ACTIVE', 'INACTIVE', 'ARCHIVED'];

  constructor(
    private route: ActivatedRoute,
    private router: Router,
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

  onSubmit(): void {
    if (this.shoppingList.id && this.shoppingList.name) {
      this.service.updateShoppingList(this.shoppingList).subscribe(() => {
        this.router.navigate(['/shopping-lists']);
      });
    }
  }

  onCancel(): void {
    this.router.navigate(['/shopping-lists']);
  }
}
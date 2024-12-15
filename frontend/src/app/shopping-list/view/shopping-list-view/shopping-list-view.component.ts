import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ShoppingListService } from '../../service/shopping-list.service';
import { Product } from '../../../product/model/product';

@Component({
  selector: 'app-shopping-list-view',
  templateUrl: './shopping-list-view.component.html',
  standalone: false
})
export class ShoppingListViewComponent implements OnInit {
  products: Product[] = [];

  constructor(
    private route: ActivatedRoute,
    private service: ShoppingListService
  ) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.service.getShoppingListProducts(id).subscribe(
        response => this.products = response.products
      );
    }
  }
}
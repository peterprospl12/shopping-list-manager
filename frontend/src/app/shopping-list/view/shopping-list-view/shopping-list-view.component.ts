import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ShoppingListService } from '../../service/shopping-list.service';
import { Product } from '../../../product/model/product';
import { ProductService } from '../../../product/service/product.service';

@Component({
  selector: 'app-shopping-list-view',
  templateUrl: './shopping-list-view.component.html',
  standalone: false,
  styleUrls: ['./shopping-list-view.component.css']
})
export class ShoppingListViewComponent implements OnInit {
  products: Product[] = [];
  shoppingListId: string;

  constructor(
    private route: ActivatedRoute,
    private shoppingListService: ShoppingListService,
    private productService: ProductService
  ) { 
    this.shoppingListId = this.route.snapshot.params['id'];
  }

  ngOnInit(): void {
    this.loadProducts();
  }

  loadProducts(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.shoppingListService.getShoppingListProducts(id).subscribe(
        response => this.products = response.products
      );
    }
  }

  deleteProduct(id: string): void {
    if (confirm('Are you sure you want to delete this product list?')) {
      this.productService.deleteProduct(id).subscribe({
        next: () => {
          this.loadProducts();
        },
        error: (error) => {
          console.error('Error deleting shopping list:', error);
        }
      });
    }
  }
}
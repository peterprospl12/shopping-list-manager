import { Component, OnInit } from '@angular/core';
import { ProductService } from '../../service/product.service';
import { Products } from '../../model/products';
import { Product } from '../../model/product';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  standalone: false,
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  constructor(private service: ProductService) { }

  products: Products | undefined;

  ngOnInit(): void {
    this.loadProducts();
  }

  loadProducts(): void {
    this.service.getProducts().subscribe(products => this.products = products);
  }

  deleteProduct(id: string): void {
    if (confirm('Are you sure you want to delete this product?')) {
      this.service.deleteProduct(id).subscribe({
        next: () => {
          this.loadProducts();
        },
        error: (error) => {
          console.error('Error deleting product:', error);
        }
      });
    }
  }
}
import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../service/product.service';
import {Products} from '../../model/products';
import {Product} from '../../model/product';
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
    this.service.getProducts().subscribe(products => this.products = products);
  }

  // onDelete(product: Product): void {
  //   this.service.deleteProduct(product).subscribe
  //   });

}

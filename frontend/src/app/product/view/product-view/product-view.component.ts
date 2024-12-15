import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductService } from '../../service/product.service';
import { ProductDetails } from '../../model/product-details';

@Component({
  selector: 'app-product-view',
  templateUrl: './product-view.component.html',
  standalone: false
})
export class ProductViewComponent implements OnInit {
  product!: ProductDetails;

  constructor(
    private route: ActivatedRoute,
    private service: ProductService
  ) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.service.getProduct(id).subscribe(
        product => this.product = product
      );
    }
  }
}
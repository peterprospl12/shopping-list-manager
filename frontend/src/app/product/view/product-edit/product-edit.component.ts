import { Component } from '@angular/core';
import { ProductDetails } from '../../model/product-details';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from '../../service/product.service';

@Component({
  selector: 'app-product-edit',
  standalone: false,
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent {
  product: ProductDetails = {
    id: '',
    name: '',
    category: 'FOOD',
    price: 0,
    quantity: 0,
    isBought: false,
    shoppingListId: ''
  }

  categories = ['FOOD', 'DRINKS', 'HOUSEHOLD', 'OTHER'];

  constructor(
    private route: ActivatedRoute,
    private router: Router,
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

  onSubmit(): void {
    if (this.product.name) {
      this.service.updateProduct(this.product).subscribe(() => {
        this.router.navigate(['/shopping-lists', this.product.shoppingListId, 'products']);
      });
    }
  }

  onCancel(): void {
    this.router.navigate(['/shopping-lists', this.product.shoppingListId, 'products']);
  }

}

import { Component } from '@angular/core';
import { ProductCreate } from '../../model/product-create.model';
import { ProductService } from '../../service/product.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css'],
  standalone: false
})
export class ProductCreateComponent {
  product: ProductCreate = {
    name: '',
    category: 'FOOD',
    price: 0,
    quantity: 0,
    isBought: false,
    shoppingListId: ''
  }

  categories = ['FOOD', 'DRINKS', 'HOUSEHOLD', 'OTHER'];

  constructor(
    private service: ProductService,
    private router: Router,
    private route: ActivatedRoute
  ) {
    this.product.shoppingListId = this.route.snapshot.params['shoppingListId'];
   }

  onSubmit(): void {
    if (this.product.name && this.product.shoppingListId) {
      this.service.createProduct(this.product)
        .subscribe(() => {
          this.router.navigate(['/shopping-lists', this.product.shoppingListId, 'products']);
        });
    }
  }

  onCancel(): void {
    this.router.navigate(['/shopping-lists', this.product.shoppingListId, 'products']);
  }
}

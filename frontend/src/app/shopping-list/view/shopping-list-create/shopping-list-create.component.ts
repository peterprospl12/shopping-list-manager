import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ShoppingListService } from '../../service/shopping-list.service';
import { ShoppingListCreate } from '../../model/shopping-list-create.model';

@Component({
  selector: 'app-shopping-list-create',
  templateUrl: './shopping-list-create.component.html',
  styleUrls: ['./shopping-list-create.component.css'],
  standalone: false
})
export class ShoppingListCreateComponent {
  shoppingList: ShoppingListCreate = {
    name: '',
    date: new Date().toISOString(),
    status: 'ACTIVE',
    userId: ''
  };

  statuses = ['ACTIVE', 'INACTIVE', 'ARCHIVED'];

  constructor(
    private service: ShoppingListService,
    private router: Router
  ) { }

  onSubmit(): void {
    if (this.shoppingList.name && this.shoppingList.userId) {
      this.service.createShoppingList(this.shoppingList)
        .subscribe(() => {
          this.router.navigate(['/shopping-lists']);
        });
    }
  }

  onCancel(): void {
    this.router.navigate(['/shopping-lists']);
  }
}
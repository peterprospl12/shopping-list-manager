import { Component, OnInit } from '@angular/core';
import { ShoppingListService } from '../../service/shopping-list.service';
import { ShoppingLists } from '../../model/shopping-lists';

@Component({
  selector: 'app-shopping-list-list',
  templateUrl: './shopping-list-list.component.html',
  standalone: false,
  styleUrls: ['./shopping-list-list.component.css']
})
export class ShoppingListListComponent implements OnInit {
  shoppingLists: ShoppingLists | undefined;

  constructor(private service: ShoppingListService) { }

  ngOnInit(): void {
    this.loadShoppingLists();
  }

  loadShoppingLists(): void {
    this.service.getShoppingLists().subscribe(
      lists => this.shoppingLists = lists
    );
  }


  deleteList(id: string): void {
    if (confirm('Are you sure you want to delete this shopping list?')) {
      this.service.deleteShoppingList(id).subscribe({
        next: () => {
          this.loadShoppingLists();
        },
        error: (error) => {
          console.error('Error deleting shopping list:', error);
        }
      });
    }
  }
}
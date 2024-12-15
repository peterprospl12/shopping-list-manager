import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ShoppingListDetails } from '../model/shopping-list-details';
import { ShoppingLists } from '../model/shopping-lists';
import { Products } from '../../product/model/products';
import { ShoppingListCreate } from '../model/shopping-list-create.model';

@Injectable({
  providedIn: 'root'
})
export class ShoppingListService {
  private apiUrl = 'api/shopping-lists';

  constructor(private http: HttpClient) { }

  getShoppingLists(): Observable<ShoppingLists> {
    return this.http.get<ShoppingLists>(this.apiUrl);
  }

  getShoppingListDetails(id: string): Observable<ShoppingListDetails> {
    return this.http.get<ShoppingListDetails>(`${this.apiUrl}/${id}`);
  }

  getShoppingListProducts(id: string): Observable<Products> {
    return this.http.get<Products>(`${this.apiUrl}/${id}/products`);
  }

  addShoppingList(shoppingList: ShoppingListDetails): Observable<void> {
    return this.http.put<void>(`${this.apiUrl}/${shoppingList.id}`, shoppingList);
  }

  createShoppingList(shoppingList: ShoppingListCreate): Observable<void> {
    const url = `${this.apiUrl}/${crypto.randomUUID()}`;
    return this.http.put<void>(url, shoppingList);
  }

  updateShoppingList(shoppingList: ShoppingListDetails): Observable<void> {
    return this.http.put<void>(`${this.apiUrl}/${shoppingList.id}`, shoppingList);
  }

  deleteShoppingList(id: string): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
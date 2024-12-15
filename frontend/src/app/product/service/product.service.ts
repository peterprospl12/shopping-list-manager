import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from 'rxjs';
import {Products} from '../model/products';
import {ProductDetails} from '../model/product-details';
import { ProductCreate } from '../model/product-create.model';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private apiUrl = 'api/products';

  constructor(private http: HttpClient) { }

  getProducts(): Observable<Products> {
    return this.http.get<Products>(this.apiUrl);
  }

  getProduct(uuid: string): Observable<ProductDetails> {
    return this.http.get<ProductDetails>(`${this.apiUrl}/${uuid}`);
  }

  createProduct(product: ProductCreate): Observable<void> {
    const url = `${this.apiUrl}/${crypto.randomUUID()}`;
    return this.http.put<void>(url, product);
  }

  deleteProduct(uuid: string): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${uuid}`);
  }
}

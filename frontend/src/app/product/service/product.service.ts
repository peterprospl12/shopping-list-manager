import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from 'rxjs';
import {Products} from '../model/products';
import {Product} from '../model/product';
import {ProductDetails} from '../model/product-details';

@Injectable()
export class ProductService {

  constructor(private http: HttpClient) { }

  getProducts(): Observable<Products> {
    return this.http.get<Products>('api/products');
  }

  getProduct(uuid: string): Observable<ProductDetails> {
    return this.http.get<ProductDetails>('api/products/' + uuid);
  }
}

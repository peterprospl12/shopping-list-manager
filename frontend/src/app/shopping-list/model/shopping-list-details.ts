import { Product } from "../../product/model/product";
import { ProductDetails } from "../../product/model/product-details";
import { Products } from "../../product/model/products";

export interface ShoppingListDetails {
  id: string;
  name: string;
  date: string;
  status: string;
  userId: string;
  products: ProductDetails[];
}

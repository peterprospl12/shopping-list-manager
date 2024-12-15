import {ShoppingList} from '../../shopping-list/model/shopping-list';

export interface ProductDetails {
  id: string;
  name: string;
  category: string;
  price: number;
  quantity: number;
  isBought: boolean;
  shoppingList: ShoppingList;
}

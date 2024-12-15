export interface ProductCreate {
    name: string;
    category: 'FOOD' | 'DRINKS' | 'HOUSEHOLD' | 'OTHER';
    price: number;
    quantity: number;
    isBought: boolean;
    shoppingListId: string;
}
export interface ShoppingListCreate {
    name: string;
    date: string;
    status: 'ACTIVE' | 'INACTIVE' | 'ARCHIVED';
    userId: string;
  }
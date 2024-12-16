import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductListComponent } from './product/view/product-list/product-list.component';
import { ShoppingListListComponent } from './shopping-list/view/shopping-list-list/shopping-list-list.component';
import { ShoppingListDetailsViewComponent } from './shopping-list/view/shopping-list-details-view/shopping-list-details-view.component';
import { ShoppingListViewComponent } from './shopping-list/view/shopping-list-view/shopping-list-view.component';
import { ProductViewComponent } from './product/view/product-view/product-view.component';
import { ShoppingListCreateComponent } from './shopping-list/view/shopping-list-create/shopping-list-create.component';
import { ShoppingListEditComponent } from './shopping-list/view/shopping-list-edit/shopping-list-edit.component';
import { ProductCreateComponent } from './product/view/product-create/product-create.component';
import { ProductEditComponent } from './product/view/product-edit/product-edit.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'shopping-lists',
    pathMatch: 'full'
  },
  {
    path: 'shopping-lists',
    component: ShoppingListListComponent
  },
  {
    path: 'shopping-lists/:id/details',
    component: ShoppingListDetailsViewComponent
  },
  {
    path: 'shopping-lists/:id/products',
    component: ShoppingListViewComponent
  },
  {
    path: 'shopping-lists/create',
    component: ShoppingListCreateComponent
  },
  {
    path: 'shopping-lists/:id/edit',
    component: ShoppingListEditComponent
  },
  {
    path: 'products',
    component: ProductListComponent
  },
  {
    path: 'products/create/:shoppingListId',
    component: ProductCreateComponent
  },
  {
    path: 'products/:id/edit',
    component: ProductEditComponent
  },
  {
    path: 'products/:id',
    component: ProductViewComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductListComponent } from './product/view/product-list/product-list.component';
import { ShoppingListListComponent } from './shopping-list/view/shopping-list-list/shopping-list-list.component';
import { ShoppingListDetailsViewComponent } from './shopping-list/view/shopping-list-details-view/shopping-list-details-view.component';
import { ShoppingListService } from './shopping-list/service/shopping-list.service';
import { ShoppingListViewComponent } from './shopping-list/view/shopping-list-view/shopping-list-view.component';
import { ProductService } from './product/service/product.service';
import { ProductViewComponent } from './product/view/product-view/product-view.component';
import { ShoppingListCreateComponent } from './shopping-list/view/shopping-list-create/shopping-list-create.component';
import { FormsModule } from '@angular/forms';
import { ShoppingListEditComponent } from './shopping-list/view/shopping-list-edit/shopping-list-edit.component';
import { ProductCreateComponent } from './product/view/product-create/product-create.component';
import { ProductEditComponent } from './product/view/product-edit/product-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    ShoppingListListComponent,
    ShoppingListDetailsViewComponent,
    ShoppingListViewComponent,
    ShoppingListCreateComponent,
    ShoppingListEditComponent,
    ProductViewComponent,
    ProductListComponent,
    ProductCreateComponent,
    ProductEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    ShoppingListService,
    ProductService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
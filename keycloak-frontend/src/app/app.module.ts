import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';


import {OAuthModule} from 'angular-oauth2-oidc';
import { HomeComponent } from './home/home.component';
import { MenuComponent } from './menu/menu.component';
import { IdentificationComponent } from './identification/identification.component'; 
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    MenuComponent,
    IdentificationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    OAuthModule.forRoot({
      resourceServer: {
          allowedUrls: ['http://localhost:8180/foo'],
          sendAccessToken: true
      }
  })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

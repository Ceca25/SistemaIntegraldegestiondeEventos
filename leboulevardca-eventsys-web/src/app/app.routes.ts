import { Routes } from '@angular/router';
import { AUTH_ROUTES } from './features/authentication/authentication.routes';

import { ProductoListComponent } from './features/productos/components/producto-list/producto-list.component';
import { ProductoFormComponent } from './features/productos/components/producto-form/producto-form.component';

import { DashboardComponent } from './features/dashboard/components/dashboard/dashboard.component';


export const routes: Routes = [
  // 🔹 Rutas de autenticación (login y register)
  ...AUTH_ROUTES,

  // 🔹 Dashboard principal
  { path: 'dashboard', component: DashboardComponent },

  // 🔹 Rutas de productos (solo accesibles luego del login)
  { path: 'productos', component: ProductoListComponent },
  { path: 'productos/nuevo', component: ProductoFormComponent },
  { path: 'productos/editar/:id', component: ProductoFormComponent },

  // 🔹 Redirección por defecto
  { path: '', redirectTo: 'login', pathMatch: 'full' },

  // 🔹 Cualquier ruta desconocida => login
  { path: '**', redirectTo: 'login' }
];


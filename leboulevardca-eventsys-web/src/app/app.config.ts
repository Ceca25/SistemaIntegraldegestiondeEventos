import { ApplicationConfig, provideZoneChangeDetection, importProvidersFrom } from '@angular/core';
import { provideRouter } from '@angular/router';
import { provideHttpClient } from '@angular/common/http';

import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

import { routes } from './app.routes';

export const appConfig: ApplicationConfig = {
  providers: [
    // 🔹 Zone.js optimizado
    provideZoneChangeDetection({ eventCoalescing: true }),

    // 🔹 Rutas principales
    provideRouter(routes),

    // 🔹 HttpClient habilitado
    provideHttpClient(),

    // 🔹 Formularios y CommonModule
    importProvidersFrom(ReactiveFormsModule, FormsModule, CommonModule),
  ]
};

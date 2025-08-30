import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterModule } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent {

  constructor(private router: Router, private http: HttpClient) {}

  // 🔹 Ir directo al CRUD de productos
  irAProductos() {
    this.router.navigate(['/productos']);
  }

  // 🔹 Cerrar sesión con el backend
  logout() {
    this.http.get('http://localhost:8080/public/auth/logout', {
      withCredentials: true,
      responseType: 'text' // 👈 evita que intente parsear JSON
    })
      .subscribe({
        next: () => {
          localStorage.removeItem('token');
          this.router.navigate(['/login']);
        },
        error: (err) => {
          console.error('Error al cerrar sesión', err);
          localStorage.removeItem('token');
          this.router.navigate(['/login']);
        }
      });
  }
}

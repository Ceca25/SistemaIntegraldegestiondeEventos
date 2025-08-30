import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule, Router } from '@angular/router';
import { AuthApiService } from '../../services';
import { LoginRequest } from '../../models';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  username = '';
  password = '';
  errorMessage = '';

  constructor(private authApi: AuthApiService, private router: Router) {}

  onSubmit(): void {
    const request: LoginRequest = {
      username: this.username,
      password: this.password
    };

    this.authApi.login(request).subscribe({
      next: (res) => {
        localStorage.setItem('token', res.token);
        // 👇 redirige al listado de productos
       // this.router.navigate(['/productos']);
       // 👇 redirige al dashboard
        this.router.navigate(['/dashboard']);

      },
      error: () => {
        this.errorMessage = '❌ Credenciales inválidas';
      }
    });
  }
}

import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { AuthApiService } from '../../services';
import { RegisterRequest } from '../../models';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {
  form: RegisterRequest = {
    username: '',
    email: '',
    password: '',
    nombres: '',
    apellidos: '',
    numeroDocumento: '',
    id_genero: 0,
    id_estado_civil: 0
  };

  message = '';

  generos = [
    { id: 1, nombre: 'Masculino' },
    { id: 2, nombre: 'Femenino' },
    { id: 3, nombre: 'Otro' }
  ];

  estadosCiviles = [
    { id: 1, nombre: 'Soltero(a)' },
    { id: 2, nombre: 'Casado(a)' },
    { id: 3, nombre: 'Divorciado(a)' },
    { id: 4, nombre: 'Viudo(a)' },
    { id: 5, nombre: 'Conviviente' }
  ];


  constructor(private authApi: AuthApiService, private router: Router) {}

  onSubmit(): void {
    this.authApi.register(this.form).subscribe({
      next: () => {
        this.message = '✅ Registro exitoso, redirigiendo al login...';
        setTimeout(() => {
          this.router.navigate(['/login']);
        }, 1000); // espera 1s antes de redirigir
      },
      error: () => {
        this.message = '❌ Error al registrar';
      }
    });
  }
}

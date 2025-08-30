import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LoginRequest, RegisterRequest, AuthResponse } from '../models';

@Injectable({ providedIn: 'root' })
export class AuthApiService {
  // ⚠️ Ajusta la URL base según tu API (Spring Boot expone /public/auth)
  private readonly baseUrl = 'http://localhost:8080/public/auth';

  constructor(private http: HttpClient) {}

  // 🔹 Login
  login(request: LoginRequest): Observable<AuthResponse> {
    return this.http.post<AuthResponse>(`${this.baseUrl}/login`, request);
  }

  // 🔹 Registro
  register(request: RegisterRequest): Observable<{ message: string }> {
    return this.http.post<{ message: string }>(`${this.baseUrl}/register`, request);
  }
}

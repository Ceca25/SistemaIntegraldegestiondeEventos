// src/app/productos/services/productos.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Producto, Categoria } from '../models/producto.model';

@Injectable({
  providedIn: 'root'
})
export class ProductosService {


  private apiUrl = 'http://localhost:8080/api/productos';

  constructor(private http: HttpClient) {}

  // ✅ Listar todos los productos
  listarProductos(): Observable<Producto[]> {
    const token = localStorage.getItem('token');
    return this.http.get<Producto[]>(this.apiUrl, {
      headers: {
        Authorization: `Bearer ${token}`
      }
    });
  }


  // ✅ Obtener un producto por ID
  obtenerProducto(id: number): Observable<Producto> {
    const token = localStorage.getItem('token');
    return this.http.get<Producto>(`${this.apiUrl}/${id}`, {
      headers: {
        Authorization: `Bearer ${token}`
      }
    });
  }


  // ✅ Registrar producto- MOD-----
  registrarProducto(producto: Producto): Observable<Producto> {
    const token = localStorage.getItem('token');
    return this.http.post<Producto>(this.apiUrl, producto, {
      headers: {
        Authorization: `Bearer ${token}`
      }
    });
  }



  // ✅ Actualizar producto
  actualizarProducto(id: number, producto: Producto): Observable<Producto> {
    const token = localStorage.getItem('token');
    return this.http.put<Producto>(`${this.apiUrl}/${id}`, producto, {
      headers: {
        Authorization: `Bearer ${token}`
      }
    });
  }


  // ✅ Eliminar producto
  eliminarProducto(id: number): Observable<void> {
    const token = localStorage.getItem('token');
    return this.http.delete<void>(`${this.apiUrl}/${id}`, {
      headers: {
        Authorization: `Bearer ${token}`
      }
    });
  }

  listarCategorias(): Observable<Categoria[]> {
    const token = localStorage.getItem('token');
    return this.http.get<Categoria[]>('http://localhost:8080/api/categorias', {
      headers: {
        Authorization: `Bearer ${token}`
      }
    });
  }



}


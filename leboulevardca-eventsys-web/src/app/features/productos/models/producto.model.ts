// src/app/productos/models/producto.model.ts

export interface Categoria {
  id: number;
  nombre?: string; // opcional porque a veces puede venir null
}

export interface Producto {
  id?: number;
  nombre: string;
  descripcion: string;
  precioUnitario: number;
  stockActual: number;
  categoria: Categoria;
  usuarioCreacion?: string;
  usuarioActualizacion?: string;
}

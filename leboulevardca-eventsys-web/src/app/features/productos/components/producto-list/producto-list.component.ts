import { Component, OnInit } from '@angular/core';
import { ProductosService } from '../../services/productos.service';
import { Producto } from '../../models/producto.model';
import {RouterLink} from "@angular/router";
import { Router } from '@angular/router';


@Component({
  selector: 'app-producto-list',
  standalone: true,
    imports: [
        RouterLink
    ],
  templateUrl: './producto-list.component.html',
  styleUrls: ['./producto-list.component.scss']
})
export class ProductoListComponent implements OnInit {
  productos: Producto[] = [];
  cargando = true;
  error: string | null = null;

  constructor(
      private productosService: ProductosService,
      private router: Router
  ) {}

  ngOnInit(): void {
    console.log('✅ ProductoListComponent cargado');
    this.cargarProductos();
  }

  cargarProductos(): void {
    this.productosService.listarProductos().subscribe({
      next: (data) => {
        this.productos = data;
        this.cargando = false;
      },
      error: () => {
        this.error = 'No se pudo cargar la lista de productos';
        this.cargando = false;
      }
    });
  }

  eliminarProducto(id: number): void {
    if (confirm('¿Estás seguro de eliminar este producto?')) {
      this.productosService.eliminarProducto(id).subscribe({
        next: () => {
          console.log(`✅ Producto con id ${id} eliminado`);
          this.cargarProductos(); // refrescamos la lista
        },
        error: (err) => {
          console.error('❌ Error al eliminar producto', err);
          this.error = 'No se pudo eliminar el producto';
        }
      });
    }
  }

  editarProducto(id: number): void {
    this.router.navigate(['/productos', 'editar', id]);
  }


}


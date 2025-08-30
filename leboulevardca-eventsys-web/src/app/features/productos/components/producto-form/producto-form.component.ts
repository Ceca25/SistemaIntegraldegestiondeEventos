// src/app/productos/components/producto-form/producto-form.component.ts
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { ProductosService } from '../../services/productos.service';
import { Producto, Categoria } from '../../models/producto.model';

@Component({
  selector: 'app-producto-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './producto-form.component.html',
  styleUrls: ['./producto-form.component.scss']
})
export class ProductoFormComponent implements OnInit {
  productoForm: FormGroup;
  categorias: Categoria[] = [];   // 👈 ahora se llena desde backend
  productoId?: number;   // 👈 Guardamos el id si estamos en edición

  constructor(
      private fb: FormBuilder,
      private productosService: ProductosService,
      private router: Router,
      private route: ActivatedRoute
  ) {
    this.productoForm = this.fb.group({
      nombre: ['', Validators.required],
      descripcion: [''],
      precioUnitario: [0, [Validators.required, Validators.min(0)]],
      stockActual: [0, [Validators.required, Validators.min(0)]],
      categoriaId: [null, Validators.required]
    });
  }

  ngOnInit(): void {
    // ✅ Cargar categorías siempre (nuevo o editar)
    this.productosService.listarCategorias().subscribe({
      next: (cats) => {
        this.categorias = cats;
        console.log("📂 Categorías cargadas:", this.categorias);
      },
      error: (err) => {
        console.error("❌ Error al cargar categorías:", err);
        alert("No se pudieron cargar las categorías");
      }
    });

    // 👇 Revisamos si la ruta trae un id (modo edición)
    const idParam = this.route.snapshot.paramMap.get('id');
    if (idParam) {
      this.productoId = Number(idParam);
      console.log('📝 Editando producto con ID:', this.productoId);

      // ✅ Cargar datos del producto para editarlos
      this.productosService.obtenerProducto(this.productoId).subscribe({
        next: (producto) => {
          console.log('📦 Producto cargado:', producto);
          this.productoForm.patchValue({
            nombre: producto.nombre,
            descripcion: producto.descripcion,
            precioUnitario: producto.precioUnitario,
            stockActual: producto.stockActual,
            categoriaId: producto.categoria.id
          });
        },
        error: (err) => {
          console.error('❌ Error al cargar producto:', err);
          alert('No se pudo cargar el producto');
        }
      });
    }
  }


  guardar(): void {
    if (this.productoForm.valid) {
      const datos: Producto = {
        nombre: this.productoForm.value.nombre,
        descripcion: this.productoForm.value.descripcion,
        precioUnitario: this.productoForm.value.precioUnitario,
        stockActual: this.productoForm.value.stockActual,
        categoria: { id: this.productoForm.value.categoriaId },
        usuarioActualizacion: 'admin'
      };

      if (this.productoId) {
        // ✅ EDITAR
        this.productosService.actualizarProducto(this.productoId, datos).subscribe({
          next: () => {
            alert('Producto actualizado con éxito');
            this.router.navigate(['/productos']);
          },
          error: (err) => {
            console.error('❌ Error al actualizar:', err);
            alert('Error al actualizar producto');
          }
        });
      } else {
        // ✅ REGISTRAR
        datos.usuarioCreacion = 'admin';
        this.productosService.registrarProducto(datos).subscribe({
          next: () => {
            alert('Producto registrado con éxito');
            this.router.navigate(['/productos']);
          },
          error: (err) => {
            console.error('❌ Error al registrar:', err);
            alert('Error al registrar producto');
          }
        });
      }
    }
  }


  cancelar(): void {
    this.router.navigate(['/productos']);
  }
}

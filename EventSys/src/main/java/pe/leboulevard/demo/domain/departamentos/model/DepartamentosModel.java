package pe.leboulevard.demo.domain.departamentos.model;

import lombok.Data;

import java.time.LocalDate;

@Data
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder

public class DepartamentosModel {

        private Long id_departamento;
        private String nombre;
        private String descripcion;
        private Boolean activo;
        //campos de auditoria
        private LocalDate fecha_creacion;
        private String usuario_creacion;
        private LocalDate fecha_actualizacion;
        private String usuario_actualizacion;
}



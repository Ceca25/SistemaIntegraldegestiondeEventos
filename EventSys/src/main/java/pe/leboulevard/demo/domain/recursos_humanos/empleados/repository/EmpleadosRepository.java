package pe.leboulevard.demo.domain.recursos_humanos.empleados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.leboulevard.demo.infrastructure.persistence.recursos_humanos.empleados.entity.EmpleadosEntity;

import java.util.List;

public interface EmpleadosRepository extends JpaRepository<EmpleadosEntity, Long> {

    // Buscar empleados por apellido
    List<EmpleadosEntity> findByApellidosContainingIgnoreCase(String apellidos);

    // Buscar empleados por número de documento
    EmpleadosEntity findByDocumentoIdentidad(String documentoIdentidad);

    // Buscar empleados por estado (activo/inactivo)
    List<EmpleadosEntity> findByIdEstado(Long idEstado);
}
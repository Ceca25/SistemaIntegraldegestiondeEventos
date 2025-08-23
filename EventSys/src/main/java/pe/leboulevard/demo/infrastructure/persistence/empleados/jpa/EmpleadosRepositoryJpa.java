package pe.leboulevard.demo.infrastructure.persistence.empleados.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.leboulevard.demo.infrastructure.persistence.empleados.entity.EmpleadosEntity;

public interface EmpleadosRepositoryJpa extends JpaRepository<EmpleadosEntity,Long> {
}

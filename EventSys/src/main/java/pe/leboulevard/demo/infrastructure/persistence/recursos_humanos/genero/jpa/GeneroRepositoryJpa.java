package pe.leboulevard.demo.infrastructure.persistence.recursos_humanos.genero.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.leboulevard.demo.infrastructure.persistence.recursos_humanos.empleados.entity.EmpleadosEntity;

public interface GeneroRepositoryJpa extends JpaRepository<EmpleadosEntity,Long> {
}

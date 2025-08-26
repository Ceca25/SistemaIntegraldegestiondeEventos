package pe.leboulevard.demo.infrastructure.persistence.recursos_humanos.estadocivil.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.leboulevard.demo.infrastructure.persistence.recursos_humanos.empleados.entity.EmpleadosEntity;

public interface EstadoCivilRepositoryJpa extends JpaRepository<EmpleadosEntity,Long> {
}

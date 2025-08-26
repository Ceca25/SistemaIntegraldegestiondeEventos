package pe.leboulevard.demo.infrastructure.persistence.organizacion.departamentos.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.leboulevard.demo.infrastructure.persistence.organizacion.departamentos.entity.DepartamentosEntity;

public interface DepartamentosrepositoryJpa extends JpaRepository<DepartamentosEntity,Long> {
}

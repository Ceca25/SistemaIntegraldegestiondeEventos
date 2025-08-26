package pe.leboulevard.demo.infrastructure.persistence.organizacion.cargos.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.leboulevard.demo.infrastructure.persistence.organizacion.cargos.entity.CargosEntity;

public interface CargosRepositoryJpa extends JpaRepository<CargosEntity,Long> {
}

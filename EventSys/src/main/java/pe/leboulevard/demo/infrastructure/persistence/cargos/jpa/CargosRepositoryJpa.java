package pe.leboulevard.demo.infrastructure.persistence.cargos.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.leboulevard.demo.infrastructure.persistence.cargos.entity.CargosEntity;

public interface CargosRepositoryJpa extends JpaRepository<CargosEntity,Long> {
}

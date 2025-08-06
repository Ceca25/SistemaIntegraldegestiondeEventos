package pe.leboulevard.demo.infrastructure.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.leboulevard.demo.domain.entity.EmpleadosEntity;

public interface EmpleadosRepository extends JpaRepository<EmpleadosEntity, Long> {
}

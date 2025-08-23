package pe.leboulevard.demo.infrastructure.persistence.permisos.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.leboulevard.demo.infrastructure.persistence.permisos.entity.PermisosEntity;

public interface PermisosRepositoryJpa extends JpaRepository<PermisosEntity,Long> {
}

package pe.leboulevard.demo.infrastructure.persistence.seguridad.roles.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.leboulevard.demo.infrastructure.persistence.seguridad.roles.entity.RolesEntity;

public interface RolesRepositoryJpa extends JpaRepository<RolesEntity,Long> {
}

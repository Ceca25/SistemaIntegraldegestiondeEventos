package pe.leboulevard.demo.infrastructure.persistence.roles.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.leboulevard.demo.infrastructure.persistence.roles.entity.RolesEntity;

public interface RolesRepositoryJpa extends JpaRepository<RolesEntity,Long> {
}

package pe.leboulevard.demo.infrastructure.persistence.usuarios.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.leboulevard.demo.infrastructure.persistence.usuarios.entity.UsuariosEntity;

public interface UsuariosRepositoryJpa extends JpaRepository<UsuariosEntity,Long> {
}

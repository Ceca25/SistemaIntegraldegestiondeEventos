package pe.leboulevard.demo.infrastructure.usuarios.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.leboulevard.demo.infrastructure.usuarios.entity.UsuariosEntity;

public interface UsuariosRepositoryJpa extends JpaRepository<UsuariosEntity,Long> {
}

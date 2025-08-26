package pe.leboulevard.demo.infrastructure.persistence.seguridad.usuarios.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.leboulevard.demo.infrastructure.persistence.seguridad.usuarios.entity.UsuariosEntity;

import java.util.Optional;

public interface UsuariosRepositoryJpa extends JpaRepository<UsuariosEntity,Long> {

    @Query("""
            SELECT DISTINCT u FROM UsuarioEntity u
            LEFT JOIN FETCH u.roles ur
            LEFT JOIN FETCH ur.rol
            WHERE u.activo = true AND u.username = :username
            """)
    Optional<UsuariosEntity> usuarioPorUsername(@Param("username") String username);
}


package pe.leboulevard.demo.domain.seguridad.usuarios.repository;

import pe.leboulevard.demo.domain.seguridad.usuarios.model.UsuariosModel;

import java.util.Optional;

public interface UsuariosRepository {

    Optional<UsuariosModel> usuarioPorUserName(String username);

    void guardarToken(String token);

    String obtenerTokenCache(String username);
}

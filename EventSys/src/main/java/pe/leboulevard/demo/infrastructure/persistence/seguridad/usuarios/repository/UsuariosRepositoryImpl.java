package pe.leboulevard.demo.infrastructure.persistence.seguridad.usuarios.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import pe.leboulevard.demo.domain.seguridad.usuarios.model.UsuariosModel;
import pe.leboulevard.demo.domain.seguridad.usuarios.repository.UsuariosRepository;
import pe.leboulevard.demo.infrastructure.persistence.seguridad.usuarios.jpa.UsuariosRepositoryJpa;

import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Repository
@RequiredArgsConstructor
public class SeguridadRepositoryImpl implements UsuariosRepository {

    private final UsuariosRepositoryJpa usuarioRepositoryJpa;

    @Override
    public Optional<UsuariosModel> usuarioPorUserName(String username) {
        return usuarioRepositoryJpa.usuarioPorUsername(username)
                .map(u -> UsuariosModel.builder()
                        .id(u.getIdUsuario())
                        .username(u.getUsername())
                        .password(u.getPasswordHash())
                        .email(u.getEmail())
                        .apellidos(u.getApellidos())
                        .nombres(u.getNombres())
                        .idactivo(u.getIdUsuario())
                               .collect(Collectors.toSet())
                        )
                        .build();
    }

    @Override
    public void guardarToken(String token) {
        log.info(token);
    }

    @Override
    public String obtenerTokenCache(String username) {
        return "";
    }
}
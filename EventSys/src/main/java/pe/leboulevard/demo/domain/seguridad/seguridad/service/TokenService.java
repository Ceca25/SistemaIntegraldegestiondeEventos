package pe.leboulevard.demo.domain.seguridad.seguridad.service;

import pe.leboulevard.demo.domain.seguridad.usuarios.model.UsuariosModel;

public interface TokenService {
    String generarTokenAcceso(UsuariosModel usuario);

    String generarTokenRefresco(UsuariosModel usuario);

    String extraerUsuario(String token);

    boolean esTokenValido(String token);

    UserDetails crearUserDetailsDesdeToken(String token);
}
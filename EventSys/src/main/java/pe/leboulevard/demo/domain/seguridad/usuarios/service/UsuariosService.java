package pe.leboulevard.demo.domain.seguridad.usuarios.service;


import pe.leboulevard.demo.domain.seguridad.seguridad.model.SeguridadModel;

public interface UsuariosService {

    SeguridadModel autenticacion(String username, String password);

    SeguridadModel refrescar(String token);
}
package pe.leboulevard.demo.domain.seguridad.seguridad.service;

import pe.leboulevard.demo.domain.seguridad.seguridad.model.SeguridadModel;

public interface SeguridadService {
    SeguridadModel autenticacion(String username, String password);

    SeguridadModel refrescar(String token);
}


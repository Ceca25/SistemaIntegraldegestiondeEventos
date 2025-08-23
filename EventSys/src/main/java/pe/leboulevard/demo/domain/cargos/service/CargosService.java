package pe.leboulevard.demo.domain.cargos.service;

import pe.leboulevard.demo.domain.cargos.model.CargosModel;

import java.util.Optional;

public interface CargosService {
    Optional<CargosModel> buscaCargos();
}

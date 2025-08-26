package pe.leboulevard.demo.domain.recursos_humanos.estadocivil.repository;

import pe.leboulevard.demo.domain.recursos_humanos.estadocivil.model.EstadoCivilModel;

import java.util.List;

public interface EstadoCivilRepository {
    List<EstadoCivilModel> todosLosEstadoCivil();
}

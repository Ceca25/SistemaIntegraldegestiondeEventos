package pe.leboulevard.demo.domain.recursos_humanos.estado.repository;

import pe.leboulevard.demo.domain.recursos_humanos.estado.model.EstadoModel;

import java.util.List;

public interface EstadoRepository {

    List<EstadoModel> todosLosEstados();
}

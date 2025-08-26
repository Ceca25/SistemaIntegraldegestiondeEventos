package pe.leboulevard.demo.domain.organizacion.cargos.repository;

import pe.leboulevard.demo.domain.organizacion.cargos.model.CargosModel;

import java.util.List;

public interface CargosRepository  {


    List<CargosModel> todosLosCargos();
}

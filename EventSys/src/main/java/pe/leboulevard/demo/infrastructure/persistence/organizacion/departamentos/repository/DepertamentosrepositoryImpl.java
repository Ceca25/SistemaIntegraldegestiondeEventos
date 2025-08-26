package pe.leboulevard.demo.infrastructure.persistence.organizacion.departamentos.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pe.leboulevard.demo.domain.organizacion.departamentos.model.DepartamentosModel;
import pe.leboulevard.demo.domain.organizacion.departamentos.repository.Departamentosrepository;
import pe.leboulevard.demo.infrastructure.persistence.organizacion.departamentos.jpa.DepartamentosrepositoryJpa;
import pe.leboulevard.demo.infrastructure.persistence.organizacion.departamentos.mapper.DepartamentosMapper;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class DepartamentoRepositoryImpl implements Departamentosrepository {

    private final DepartamentosrepositoryJpa departamentoRepositoryJpa;
    private final DepartamentosMapper departamentoMapper;

    @Override
    public List<DepartamentosModel> findDepartamento() {
        return departamentoRepositoryJpa.findAll()
                .stream()
                .map(departamentoMapper::departamentoMap)
                .toList();
    }

    @Override
    public List<DepartamentosModel> todosLosCargos() {
        return List.of();
    }
}
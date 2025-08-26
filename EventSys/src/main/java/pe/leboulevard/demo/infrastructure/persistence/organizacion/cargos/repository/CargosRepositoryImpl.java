package pe.leboulevard.demo.infrastructure.persistence.organizacion.cargos.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pe.leboulevard.demo.domain.organizacion.cargos.model.CargosModel;
import pe.leboulevard.demo.domain.organizacion.cargos.repository.CargosRepository;
import pe.leboulevard.demo.infrastructure.persistence.organizacion.cargos.jpa.CargosRepositoryJpa;
import pe.leboulevard.demo.infrastructure.persistence.organizacion.cargos.mapper.CargosMapper;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CargosRepositoryImpl implements CargosRepository {

    private final CargosRepositoryJpa cargosRepositoryJpa;
    private final CargosMapper cargosMapper;


    public Optional<CargosModel> buscarPorId(Long idCargo) {
        return cargosRepositoryJpa.findById(idCargo)
                .map(cargosMapper::cargosMap); // Convierte Optional<CargosEntity> → Optional<CargosModel>
    }

    @Override
    public List<CargosModel> todosLosCargos() {
        return cargosRepositoryJpa.findAll()
                .stream()
                .map(cargosMapper::cargosMap)
                .toList();
    }
}

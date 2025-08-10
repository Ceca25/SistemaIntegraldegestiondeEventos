package pe.leboulevard.demo.infrastructure.cargos.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pe.leboulevard.demo.domain.cargos.model.CargosModel;
import pe.leboulevard.demo.domain.cargos.repository.CargosRepository;
import pe.leboulevard.demo.infrastructure.cargos.jpa.CargosRepositoryJpa;
import pe.leboulevard.demo.infrastructure.cargos.mapper.CargosMapper;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CargosRepositoryImpl implements CargosRepository {

    private final CargosRepositoryJpa cargosRepositoryJpa;
    private final CargosMapper cargosMapper;

    @Override
    public Optional<CargosModel> buscarPorId(Long id_cargo) {
        return cargosRepositoryJpa.findById(id_cargo)
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

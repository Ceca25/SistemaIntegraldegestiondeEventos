package pe.leboulevard.demo.application.cargos.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.leboulevard.demo.domain.cargos.model.CargosModel;
import pe.leboulevard.demo.domain.cargos.repository.CargosRepository;
import pe.leboulevard.demo.domain.cargos.service.CargosService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CargosServiceImpl implements CargosService {

    private final CargosRepository cargosRepository;

    @Override
    public Optional<CargosModel> buscaCargos(Long id_cargo) {
        return cargosRepository.buscarPorId(id_cargo);
    }
}

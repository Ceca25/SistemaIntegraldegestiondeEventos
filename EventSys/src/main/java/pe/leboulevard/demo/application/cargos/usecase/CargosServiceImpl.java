package pe.leboulevard.demo.application.cargos.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.leboulevard.demo.domain.organizacion.cargos.model.CargosModel;
import pe.leboulevard.demo.domain.organizacion.cargos.repository.CargosRepository;
import pe.leboulevard.demo.domain.organizacion.cargos.service.CargosService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CargosServiceImpl implements CargosService {

    private final CargosRepository cargosRepository;

    @Override
    public List<CargosModel> listarCargos() {
        return List.of();
    }
}

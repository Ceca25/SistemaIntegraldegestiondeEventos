package pe.leboulevard.demo.presentation.cargos.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.leboulevard.demo.domain.cargos.service.CargosService;
import pe.leboulevard.demo.presentation.cargos.dto.CargosResponseDto;
import pe.leboulevard.demo.presentation.cargos.mapper.CargosDtoMapper;

import java.util.List;

@RestController
@RequestMapping("/api/cargos")
@RequiredArgsConstructor
public class CargosController {

    private final CargosService cargosService;
    private final CargosDtoMapper cargosDtoMapper;

    @GetMapping
    public List<CargosResponseDto> cargos() {
        return cargosService. buscaCargos()
                .stream()
                .map(cargosDtoMapper::dtoMap)
                .toList();
    }
}

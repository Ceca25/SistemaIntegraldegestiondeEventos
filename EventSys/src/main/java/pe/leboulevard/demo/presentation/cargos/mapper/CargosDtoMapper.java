package pe.leboulevard.demo.presentation.cargos.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pe.leboulevard.demo.domain.cargos.model.CargosModel;
import pe.leboulevard.demo.presentation.cargos.dto.CargosResponseDto;

@Mapper(componentModel = "spring")
public interface CargosDtoMapper {

    @Mapping(target = "id_cargo", source = "id_cargo")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "descripcion", source = "descripcion")
    @Mapping(target = "id_departamento", source = "id_departamento")
    @Mapping(target = "id_activo", source = "id_activo")
    CargosResponseDto dtoMap(CargosModel model);

}

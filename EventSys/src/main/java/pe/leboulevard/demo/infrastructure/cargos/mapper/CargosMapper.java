package pe.leboulevard.demo.infrastructure.cargos.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pe.leboulevard.demo.domain.cargos.model.CargosModel;
import pe.leboulevard.demo.infrastructure.cargos.entity.CargosEntity;

@Mapper(componentModel = "spring")
public interface CargosMapper {

    @Mapping(target = "id_cargo", source = "id_cargo")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "descripcion", source = "descripcion")
    @Mapping(target = "id_departamento", source = "id_departamento")
    //@Mapping(target = "activo", expression = "java(mapBuscaActivo(entity.getActivo()))")
    CargosModel cargosMap(CargosEntity entity);

    // Método auxiliar para convertir el campo activo
    //default boolean mapBuscaActivo(Integer activo) {
     //   return activo != null && activo == 1;
   // }
}

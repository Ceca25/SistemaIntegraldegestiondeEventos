package pe.leboulevard.demo.infrastructure.persistence.organizacion.cargos.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pe.leboulevard.demo.domain.organizacion.cargos.model.CargosModel;
import pe.leboulevard.demo.infrastructure.persistence.organizacion.cargos.entity.CargosEntity;

@Mapper(componentModel = "spring")
public interface CargosMapper {

    // Convierte de Entity → Model
    @Mapping(source = "departamentos.idDepartamento", target = "id_departamento")
    CargosModel cargosMap(CargosEntity entity);

    // Convierte de Model → Entity
    @Mapping(source = "idDepartamento", target = "departamentos.id_departamento")
    CargosEntity cargosEntity(CargosModel model);
}
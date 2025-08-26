package pe.leboulevard.demo.infrastructure.persistence.organizacion.departamentos.mapper;

import org.mapstruct.Mapper;
import pe.leboulevard.demo.domain.organizacion.departamentos.model.DepartamentosModel;
import pe.leboulevard.demo.infrastructure.persistence.organizacion.departamentos.entity.DepartamentosEntity;

@Mapper(componentModel = "spring")
public interface DepartamentosMapper {

    // Entity → Model
    DepartamentosModel toModel(DepartamentosEntity entity);

    // Model → Entity
    DepartamentosEntity toEntity(DepartamentosModel model);

    Object departamentoMap(DepartamentosEntity departamentosEntity);
}

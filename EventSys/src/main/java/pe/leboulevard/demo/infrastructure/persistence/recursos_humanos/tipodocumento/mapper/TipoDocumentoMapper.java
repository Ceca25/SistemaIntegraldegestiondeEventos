package pe.leboulevard.demo.infrastructure.persistence.recursos_humanos.tipodocumento.mapper;

import org.mapstruct.Mapper;
import pe.leboulevard.demo.domain.recursos_humanos.tipodocumento.model.TipoDocumentoModel;
import pe.leboulevard.demo.infrastructure.persistence.recursos_humanos.tipodocumento.entity.TipoDocumentoEntity;


@Mapper(componentModel = "spring")
public interface TipoDocumentoMapper {

    // Entity → Model
    TipoDocumentoModel toModel(TipoDocumentoEntity entity);

    // Model → Entity
    TipoDocumentoEntity toEntity(TipoDocumentoModel model);
}
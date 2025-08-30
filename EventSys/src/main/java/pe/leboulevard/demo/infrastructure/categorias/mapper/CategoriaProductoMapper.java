package pe.leboulevard.demo.infrastructure.categorias.mapper;

import org.mapstruct.Mapper;
import pe.leboulevard.demo.domain.categorias.model.CategoriaProducto;
import pe.leboulevard.demo.infrastructure.categorias.entity.CategoriaProductoEntity;

@Mapper(componentModel = "spring")
public interface CategoriaProductoMapper {
    CategoriaProducto toDomain(CategoriaProductoEntity entity);
    CategoriaProductoEntity toEntity(CategoriaProducto model);
}
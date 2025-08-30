package pe.leboulevard.demo.infrastructure.productos.mapper;

import org.mapstruct.Mapper;
import pe.leboulevard.demo.domain.productos.model.Producto;
import pe.leboulevard.demo.infrastructure.productos.entity.ProductoEntity;

@Mapper(componentModel = "spring")
public interface ProductoMapper {

    // Entity → Dominio
    Producto toDomain(ProductoEntity entity);

    // Dominio → Entity
    ProductoEntity toEntity(Producto model);
}
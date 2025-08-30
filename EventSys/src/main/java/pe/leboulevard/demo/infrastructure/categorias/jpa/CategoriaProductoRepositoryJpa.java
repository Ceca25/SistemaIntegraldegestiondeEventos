package pe.leboulevard.demo.infrastructure.categorias.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.leboulevard.demo.infrastructure.categorias.entity.CategoriaProductoEntity;

@Repository
public interface CategoriaProductoRepositoryJpa extends JpaRepository<CategoriaProductoEntity, Long> {
}
package pe.leboulevard.demo.infrastructure.persistence.recursos_humanos.tipodocumento.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.leboulevard.demo.infrastructure.persistence.recursos_humanos.tipodocumento.entity.TipoDocumentoEntity;

public interface TipoDocumentoRepositoryJpa extends JpaRepository<TipoDocumentoEntity,Long> {
}

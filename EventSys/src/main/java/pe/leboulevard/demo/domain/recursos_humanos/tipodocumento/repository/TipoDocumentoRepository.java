package pe.leboulevard.demo.domain.recursos_humanos.tipodocumento.repository;

import pe.leboulevard.demo.domain.recursos_humanos.tipodocumento.model.TipoDocumentoModel;

import java.util.List;

public interface TipoDocumentoRepository {

   List<TipoDocumentoModel> listarTipoDocumento();
}

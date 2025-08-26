package pe.leboulevard.demo.domain.recursos_humanos.tipodocumento.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pe.leboulevard.demo.domain.shared.model.AuditoriaModel;


@Data
@EqualsAndHashCode(callSuper = true)
public class TipoDocumentoModel extends AuditoriaModel {

    private Long idTipoDocumento;
    private String nombre;
}

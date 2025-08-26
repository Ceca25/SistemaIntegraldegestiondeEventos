package pe.leboulevard.demo.domain.recursos_humanos.estado.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pe.leboulevard.demo.domain.shared.model.AuditoriaModel;

@Data
@EqualsAndHashCode(callSuper = true)
public class EstadoModel extends AuditoriaModel {

    private Long idEstado;
    private String nombre;

}

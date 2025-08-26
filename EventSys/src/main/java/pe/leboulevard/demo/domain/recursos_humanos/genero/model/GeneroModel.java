package pe.leboulevard.demo.domain.recursos_humanos.genero.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pe.leboulevard.demo.domain.shared.model.AuditoriaModel;

@Data
@EqualsAndHashCode(callSuper = true)
public class GeneroModel extends AuditoriaModel {

    private Long idGenero;
    private String nombre;

}

package pe.leboulevard.demo.domain.recursos_humanos.estadocivil.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import pe.leboulevard.demo.domain.shared.model.AuditoriaModel;


@Data
@EqualsAndHashCode(callSuper = true)
public class EstadoCivilModel extends AuditoriaModel {

    private Long idEstadoCivil;
    private String nombre;
}

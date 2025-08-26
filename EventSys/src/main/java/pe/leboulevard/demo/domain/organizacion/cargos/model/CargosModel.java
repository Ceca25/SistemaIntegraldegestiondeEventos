package pe.leboulevard.demo.domain.organizacion.cargos.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pe.leboulevard.demo.domain.shared.model.AuditoriaModel;


@Data
@EqualsAndHashCode(callSuper = true)
public class CargosModel extends AuditoriaModel {

    private Long idCargo;
    private String nombre;
    private String descripcion;
    private Long idDepartamento;


}

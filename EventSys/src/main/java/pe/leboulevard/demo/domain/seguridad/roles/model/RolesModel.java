package pe.leboulevard.demo.domain.seguridad.roles.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import pe.leboulevard.demo.domain.shared.model.AuditoriaModel;

@Data
@EqualsAndHashCode(callSuper = true)
public class RolesModel extends AuditoriaModel {

    private Long idrol;
    private String nombre;
    private String descripcion;


}

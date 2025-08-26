package pe.leboulevard.demo.domain.seguridad.permisos.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import pe.leboulevard.demo.domain.shared.model.AuditoriaModel;

@Data
@EqualsAndHashCode(callSuper = true)
public class PermisosModel extends AuditoriaModel {

    private Long idpermiso;
    private String nombre;
    private String descripcion;


}

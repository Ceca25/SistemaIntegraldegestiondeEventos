package pe.leboulevard.demo.domain.organizacion.departamentos.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pe.leboulevard.demo.domain.shared.model.AuditoriaModel;

@Data
@EqualsAndHashCode(callSuper = true)
public class DepartamentosModel extends AuditoriaModel {

        private Long idDepartamento;
        private String nombre;
        private String descripcion;

}



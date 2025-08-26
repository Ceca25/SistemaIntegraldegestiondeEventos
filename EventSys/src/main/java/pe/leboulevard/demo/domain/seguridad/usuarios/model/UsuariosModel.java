package pe.leboulevard.demo.domain.seguridad.usuarios.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import pe.leboulevard.demo.domain.shared.model.AuditoriaModel;

@Data
@EqualsAndHashCode(callSuper = true)
public class UsuariosModel extends AuditoriaModel {

    private Long idUsuario;
    private String username;
    private String password_hash;
    private String nombre;
    private String apellidos;
    private String email;
    private Long idEstado;

}

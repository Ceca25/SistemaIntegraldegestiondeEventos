package pe.leboulevard.demo.infrastructure.persistence.seguridad.usuarios.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pe.leboulevard.demo.infrastructure.persistence.recursos_humanos.estado.entity.EstadoEntity;
import pe.leboulevard.demo.infrastructure.persistence.seguridad.roles.entity.RolesEntity;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="usuarios")
@Getter
@Setter

public class UsuariosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "username")
    private String username;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "email")
    private String email;

    // Relación con Estado
    @ManyToOne
    @JoinColumn(name = "id_estado")
    private EstadoEntity estado;


    // Relación muchos a muchos con roles
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "usuario_roles",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_rol")
    )
    private Set<RolesEntity> roles = new HashSet<>();

}

package pe.leboulevard.demo.infrastructure.persistence.seguridad.roles.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pe.leboulevard.demo.infrastructure.persistence.seguridad.usuarios.entity.UsuariosEntity;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="roles")
@Getter
@Setter

public class RolesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_rol")
    private Long idRol;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Set<UsuariosEntity> usuarios = new HashSet<>();


}

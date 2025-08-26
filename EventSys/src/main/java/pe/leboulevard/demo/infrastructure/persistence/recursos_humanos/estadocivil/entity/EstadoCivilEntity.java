package pe.leboulevard.demo.infrastructure.persistence.recursos_humanos.estadocivil.entity;

import jakarta.persistence.*;
import lombok.*;
import pe.leboulevard.demo.infrastructure.persistence.shared.Auditoria;

@Entity
@Table(name="estado_civil")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EstadoCivilEntity extends Auditoria<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_estado_civil")
    private long idEstadoCivil;

    @Column(name = "nombres")
    private String nombres;

}

package pe.leboulevard.demo.infrastructure.persistence.recursos_humanos.estado.entity;

import jakarta.persistence.*;
import lombok.*;
import pe.leboulevard.demo.infrastructure.persistence.shared.Auditoria;

@Entity
@Table(name="estado")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EstadoEntity extends Auditoria<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_estado")
    private long idEstado;

    @Column(name = "nombres")
    private String nombres;

}

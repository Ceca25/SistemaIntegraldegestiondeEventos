package pe.leboulevard.demo.infrastructure.persistence.recursos_humanos.genero.entity;

import jakarta.persistence.*;
import lombok.*;
import pe.leboulevard.demo.infrastructure.persistence.shared.Auditoria;

@Entity
@Table(name="genero")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GeneroEntity extends Auditoria<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_genero")
    private long idGenero;

    @Column(name = "nombres")
    private String nombres;


}

package pe.leboulevard.demo.infrastructure.persistence.recursos_humanos.empleados.entity;

import jakarta.persistence.*;
import lombok.*;
import pe.leboulevard.demo.infrastructure.persistence.organizacion.cargos.entity.CargosEntity;
import pe.leboulevard.demo.infrastructure.persistence.organizacion.departamentos.entity.DepartamentosEntity;
import pe.leboulevard.demo.infrastructure.persistence.recursos_humanos.estado.entity.EstadoEntity;
import pe.leboulevard.demo.infrastructure.persistence.recursos_humanos.estadocivil.entity.EstadoCivilEntity;
import pe.leboulevard.demo.infrastructure.persistence.recursos_humanos.genero.entity.GeneroEntity;
import pe.leboulevard.demo.infrastructure.persistence.shared.Auditoria;

import java.time.LocalDate;

@Entity
@Table(name="empleados")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmpleadosEntity  extends Auditoria<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_empleado")
    private long idEmpleado;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "documento_identidad")
    private String documentoIdentidad;

    @Column(name = "tipo_documento")
    private String tipoDocumento;

    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;

    // Relación con Genero
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_genero", nullable = false)
    private GeneroEntity genero;

    // Relación con EstadoCivil
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado_civil", nullable = false)
    private EstadoCivilEntity estadoCivil;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "email_personal")
    private String emailPersonal;

    @Column(name = "email_corporativo")
    private String emailCorporativo;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "fecha_ingreso")
    private LocalDate fechaIngreso;

    @Column(name = "fecha_salida")
    private LocalDate fechaSalida;

    // Relación con Estado
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado", nullable = false)
    private EstadoEntity estado;

    // Relación con Cargos
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cargo", nullable = false)
    private CargosEntity cargos;

    // Relación con Departamentos
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_departamento", nullable = false)
    private DepartamentosEntity departamentos;

}

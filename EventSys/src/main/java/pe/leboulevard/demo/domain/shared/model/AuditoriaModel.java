package pe.leboulevard.demo.domain.shared.model;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public abstract class AuditoriaModel {
    private LocalDateTime fecha_creacion;
    private String usuario_creacion;
    private LocalDateTime fecha_actualizacion;
    private String usuario_actualizacion;
}

package pe.leboulevard.demo.presentation.organizacion.cargos.dto;

public record CargosResponseDto(
        Long id_cargo,
        String nombre,
        String descripcion,
        Long id_departamento,
        Long id_activo
) {
}

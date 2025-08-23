package pe.leboulevard.demo.presentation.cargos.dto;

public record CargosResponseDto(
        Long id_cargo,
        String nombre,
        String descripcion,
        Long id_departamento,
        Long id_activo
) {
}

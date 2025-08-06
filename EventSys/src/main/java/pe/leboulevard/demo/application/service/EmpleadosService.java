package pe.leboulevard.demo.application.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.leboulevard.demo.domain.entity.EmpleadosEntity;
import pe.leboulevard.demo.infrastructure.Repository.EmpleadosRepository;
import java.time.LocalDate;
import java.util.List;


@Slf4j
@Service
public class EmpleadosService {

    private final EmpleadosRepository empleadosRepository;

    public EmpleadosService(EmpleadosRepository empleadosRepository) {
        this.empleadosRepository = empleadosRepository;
    }

    public void EmpleadosSave(){

        EmpleadosEntity empleadosEntity = new EmpleadosEntity();
        empleadosEntity.setNombres("Martin");
        empleadosEntity.setApellidos("Salinas Garcia");
        empleadosEntity.setDni("46583584");
        empleadosEntity.setCargo("Vendedor");
        empleadosEntity.setTelefono("96587457");
        empleadosEntity.setCorreo("martinsg@gmail.com");
        empleadosEntity.setFechaIngreso(LocalDate.now()); // Usa fecha actual

        empleadosRepository.save(empleadosEntity);

    }

    public void consulta(){
        List<EmpleadosEntity> empleados = empleadosRepository.findAll();
            for(EmpleadosEntity empleados1 : empleados){
                log.info(empleados1.getNombres());
            }
    }
}

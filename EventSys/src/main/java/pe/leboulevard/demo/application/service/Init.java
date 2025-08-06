package pe.leboulevard.demo.application.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Init {

    private final EmpleadosService empleadosService;

    @PostConstruct
    public void InitOn(){
       empleadosService.EmpleadosSave();
       empleadosService.consulta();
    }

}

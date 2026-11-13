package practicag2.jessusycarlos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import practicag2.jessusycarlos.services.IUsuariosService;

@Controller 
@RequestMapping ("/api") //Establezco la ruta por defecto, que va ser 'api'
public class EmpleadoController {
    
    //Inyecto la interfaz del servicio
    @Autowired 
    private IUsuariosService diUsuariosService;
    @Autowired 
    private IUsuariosService NocturnoService;

}

package practicag2.jessusycarlos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import practicag2.jessusycarlos.exceptiones.ContraseñaIncorrectaException;
import practicag2.jessusycarlos.exceptiones.LoginIncorrectoException;
import practicag2.jessusycarlos.models.Usuarios;
import practicag2.jessusycarlos.repository.IUsuariosRepository;

@Service 
public class AutenticacionService {
    //Inyecto los dos repositorios
    @Autowired 
    @Qualifier ("usuariosDiurnos")
    private IUsuariosRepository diurnos;

    @Autowired 
    @Qualifier ("usuariosNocturnos")
    private IUsuariosRepository nocturnos;

    //Creo el método autenticar
    public Usuarios autenticar(String login, String password){
        //Busco los usuarios diurnos
        for(Usuarios u : diurnos.findAll()){
            //Realizo la comprobacion del login
            if(u.getLogin().equals(login)){
                return compobarContraseña(u, password);
            }
        }
        //Ahora busco en los usuarios nocturnos
        for(Usuarios u : nocturnos.findAll()){
            if(u.getLogin().equals(login)){
                return compobarContraseña(u, password);
            }
        }

        //Lanzo la excepcion LoginIncorrecto
        throw new LoginIncorrectoException("Error. Login incorrecto");
    }

    //Realizo el método compobarContraseña
    public Usuarios compobarContraseña(Usuarios usuario, String password){
        //Realizo la comprobación de la contraseña
        if(!usuario.getPassword().equals(password)){
            //Lanzo la exception contraseñaIncorrecta
            throw new ContraseñaIncorrectaException("Error. Contraseña incorrecta");
        }
        return usuario;
    }
    
}

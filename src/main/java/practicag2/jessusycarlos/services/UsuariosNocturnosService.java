package practicag2.jessusycarlos.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import practicag2.jessusycarlos.repository.IUsuariosRepository;

@Service 
public class UsuariosNocturnosService extends UsuariosService{
    private  IUsuariosRepository usuariosRepository;
    //Creo el constructor
    public UsuariosNocturnosService(@Qualifier("usuariosNocturnos")IUsuariosRepository usuariosRepository){
        super(usuariosRepository);
    }
    
}

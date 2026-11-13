package practicag2.jessusycarlos.services;

import org.springframework.beans.factory.annotation.Qualifier;

import practicag2.jessusycarlos.repository.IUsuariosRepository;

public class UsuariosDiurnosService extends UsuariosService {
    private  IUsuariosRepository usuariosRepository;

    //Creo el constructor
    public UsuariosDiurnosService(@Qualifier("usuariosDiurnos")IUsuariosRepository usuariosRepository ){
        this.usuariosRepository = usuariosRepository;
    }
}

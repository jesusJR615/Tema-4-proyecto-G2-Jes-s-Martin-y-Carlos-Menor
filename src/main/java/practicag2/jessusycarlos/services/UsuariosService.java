package practicag2.jessusycarlos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import practicag2.jessusycarlos.models.Usuarios;
import practicag2.jessusycarlos.repository.IUsuariosRepository;

@Service 
public abstract class UsuariosService implements IUsuariosService{
    //Inyecto la clase IUsuariosRepository
    @Autowired 
    private IUsuariosRepository usuariosRepository;

    //Llamo a los metodos
    //Usuarios findById(int id)
    public Usuarios findById(int id){
        return usuariosRepository.findById(id);
    }

    //List<Usuarios> findAll();
    public List<Usuarios> findAll(){
        return usuariosRepository.findAll();
    }

    //int save(Usuarios usuarios)
    public int save(Usuarios usuarios){
        return usuariosRepository.save(usuarios);
    }
}

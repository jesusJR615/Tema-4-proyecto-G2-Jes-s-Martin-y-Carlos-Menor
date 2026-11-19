package practicag2.jessusycarlos.services;

import java.util.List;



import practicag2.jessusycarlos.models.Usuarios;
import practicag2.jessusycarlos.repository.IUsuariosRepository;


public abstract class UsuariosService implements IUsuariosService{
    //clase IUsuariosRepository
    private IUsuariosRepository usuariosRepository;

    //Creo el constructor
    protected UsuariosService(IUsuariosRepository usuariosRepository){
        this.usuariosRepository = usuariosRepository;
    }

    //Llamo a los metodos
    //Usuarios findById(int id)
    @Override 
    public Usuarios findById(int id){
        return usuariosRepository.findById(id);
    }

    //List<Usuarios> findAll();
    @Override 
    public List<Usuarios> findAll(){
        return usuariosRepository.findAll();
    }

    //int save(Usuarios usuarios)
    @Override 
    public int save(Usuarios usuarios){
        return usuariosRepository.save(usuarios);
    }
}

package practicag2.jessusycarlos.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;



import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import practicag2.jessusycarlos.models.Usuarios;




public abstract class UsuariosRepository implements IUsuariosRepository{
    //Creo la lista de usuario
    private List<Usuarios> usuarios = new ArrayList<>();
    public AtomicInteger idGenerador = new AtomicInteger();

    //Creo el constructor
    public UsuariosRepository(){
       
    }

    //llamo al metodo public Usuarios findById(int id)
    @Override 
    public Usuarios findById(int id){
        return usuarios.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
    }

    //Creo el método public List<Usuarios> findAll();
    public List<Usuarios> findAll(){
        return usuarios;
    }

    //Creo el método int save (Usuarios usuarios)
    public int save (Usuarios usuario){
        usuario.
    }
    
}

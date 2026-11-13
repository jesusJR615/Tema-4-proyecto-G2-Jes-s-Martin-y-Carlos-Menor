package practicag2.jessusycarlos.services;

import java.util.List;

import practicag2.jessusycarlos.models.Usuarios;

public interface IUsuariosService {
    public Usuarios findById(int id);

    public List<Usuarios> findAll();

    public int save(Usuarios usuarios);
}

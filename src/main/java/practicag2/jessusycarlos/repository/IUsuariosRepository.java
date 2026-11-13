package practicag2.jessusycarlos.repository;

import java.util.List;

import practicag2.jessusycarlos.models.Usuarios;

public interface IUsuariosRepository {
    public Usuarios findById(int id);
    public List<Usuarios> findAll();
    public int save (Usuarios usuarios);
}

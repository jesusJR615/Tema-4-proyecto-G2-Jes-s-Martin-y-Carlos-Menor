package practicag2.jessusycarlos.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import practicag2.jessusycarlos.models.usuarioNocturno;
import tools.jackson.databind.ObjectMapper;

import org.springframework.core.io.Resource;


public class UsuarioNocturnoRepositoryJson extends UsuariosRepository {

    // Creo el contructor para leer el json
    public UsuarioNocturnoRepositoryJson() {
        Resource resource = new ClassPathResource("json/usuariosNocturnos.json");
        readValueJson(resource);
    }

    // Creo el método readValueJson
    private void readValueJson(Resource resource) {
        // Creo el objectMaper
        ObjectMapper objectMaper = new ObjectMapper();
        try {
            usuarioNocturno[] array = objectMaper.readValue(resource.getInputStream(), usuarioNocturno[].class);
            for (usuarioNocturno u : array) {
                save(u); // Utilizo el método que hereda de UsuariosRepository
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

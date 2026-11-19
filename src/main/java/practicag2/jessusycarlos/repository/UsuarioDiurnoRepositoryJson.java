package practicag2.jessusycarlos.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import practicag2.jessusycarlos.models.usuarioDiurno;
import tools.jackson.databind.ObjectMapper;

import org.springframework.core.io.Resource;


public class UsuarioDiurnoRepositoryJson extends UsuariosRepository { // Extiende de la clase padre 'UsuariosRepository'

    // Creo el contructor, para leer el json
    public UsuarioDiurnoRepositoryJson() {
        Resource resource = new ClassPathResource("json/usuariosDirunos.json");
        readValueJson(resource);
    }

    // Creo el método readValueJson
    private void readValueJson(Resource resource) {
        // Creo el objectMaper
        ObjectMapper objectMaper = new ObjectMapper();
        try {
            usuarioDiurno[] array = objectMaper.readValue(resource.getInputStream(), usuarioDiurno[].class);
            for (usuarioDiurno u : array) {
                save(u); // Utilizo el método que hereda de UsuariosRepository
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

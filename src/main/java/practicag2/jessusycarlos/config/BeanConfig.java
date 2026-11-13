package practicag2.jessusycarlos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import practicag2.jessusycarlos.repository.IUsuariosRepository;
import practicag2.jessusycarlos.repository.UsuarioDiurnoRepositoryJson;
import practicag2.jessusycarlos.repository.UsuarioNocturnoRepositoryJson;

@Configuration 
public class BeanConfig {

    //Creo el @Bean, para utilizarlo como @Qualifier en el contructor del servicio
    @Bean("usuariosDiurnos")
    public IUsuariosRepository usuariosDiurnRepository(){
        return new UsuarioDiurnoRepositoryJson();
    }

    @Bean ("usuariosNocturnos")
    public IUsuariosRepository usuariosNosturnRepository(){
        return new UsuarioNocturnoRepositoryJson();
    }
    
}

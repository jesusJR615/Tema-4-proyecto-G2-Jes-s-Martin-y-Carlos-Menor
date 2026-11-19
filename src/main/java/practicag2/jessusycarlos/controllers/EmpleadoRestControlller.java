package practicag2.jessusycarlos.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import practicag2.jessusycarlos.exceptiones.ContraseñaIncorrectaException;
import practicag2.jessusycarlos.exceptiones.CredencialesInvalidasException;
import practicag2.jessusycarlos.exceptiones.LoginIncorrectoException;
import practicag2.jessusycarlos.exceptiones.SessionNoIniciadaException;
import practicag2.jessusycarlos.exceptiones.UsuarioNotFoundException;
import practicag2.jessusycarlos.models.Usuarios;
import practicag2.jessusycarlos.services.AutenticacionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
public class EmpleadoRestControlller {
    // Inyecto el servicio de autenticacion
    @Autowired
    private AutenticacionService autenticacionService;

    // Realizo el endpoint POST, en el que voy a validar las credenciales y crear la
    // sesion
    @PostMapping("/login")
    public Usuarios login(@RequestParam String login, @RequestParam String password, HttpSession session)
            throws LoginIncorrectoException, ContraseñaIncorrectaException, CredencialesInvalidasException {
        // Compruebo las crecenciales vacias
        if (login == null || login.isEmpty() || password == null || password.isEmpty()) {
            throw new CredencialesInvalidasException("Credenciales vacías");
        }
        Usuarios empleado = autenticacionService.autenticar(login, password);
        session.setAttribute("usuario", empleado);
        return empleado;
    }

    // Creo el endpoint GET
    @GetMapping("/empleado/home")
    public Usuarios home(HttpSession session) throws SessionNoIniciadaException, UsuarioNotFoundException {
        // Compruebo la session del usuario
        if (session.getAttribute("usuario") == null) {
            throw new SessionNoIniciadaException("El usuario no está autenticado");
        }
        Usuarios empleado = (Usuarios) session.getAttribute("usuario");
        // Compruebo que el empleado 'usuario' no sea nulo
        if (empleado == null) {
            throw new UsuarioNotFoundException("El usuario no exite");
        }
        return empleado;
    }

    // Creo el endopoint GET -> para invalidar la session activa
    @GetMapping("/empleado/logout")
    public Map<String, Object> logout(HttpSession session) {
        session.invalidate();
        return Map.of("codigo", 200, "mensaje", "Sessión cerrada");
    }

}

package practicag2.jessusycarlos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import practicag2.jessusycarlos.exceptiones.ContraseñaIncorrectaException;
import practicag2.jessusycarlos.exceptiones.CredencialesInvalidasException;
import practicag2.jessusycarlos.exceptiones.LoginIncorrectoException;
import practicag2.jessusycarlos.exceptiones.SessionNoIniciadaException;
import practicag2.jessusycarlos.exceptiones.UsuarioNotFoundException;
import practicag2.jessusycarlos.models.Usuarios;
import practicag2.jessusycarlos.models.usuarioDiurno;
import practicag2.jessusycarlos.models.usuarioNocturno;

import practicag2.jessusycarlos.services.AutenticacionService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmpleadoController {
    // Inyecto el servicio de autenticacion
    @Autowired
    private AutenticacionService autenticacionService;

    // Muestro el formulario login
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // Con POST envio información, por lo que compruebo la autenticación del usuario
    // y envío la vista a home
    @PostMapping("/login")
    public String login(@RequestParam String login, @RequestParam String password, HttpSession session)
            throws LoginIncorrectoException, ContraseñaIncorrectaException {
        // Comprubo las credenciales
        if (login == null || login.isEmpty() || password == null || password.isEmpty()) {
            throw new CredencialesInvalidasException("Credenciales vacías");
        }
        Usuarios empleado = autenticacionService.autenticar(login, password);
        session.setAttribute("usuario", empleado);
        return "redirect:/empleado/home";
    }

    // Página principal, si el usuario ha sido autenticado
    @GetMapping("/empleado/home")
    public String home(HttpSession session, Model model)
            throws SessionNoIniciadaException, UsuarioNotFoundException, NullPointerException {
        // Compruebo la session del usuario
        if (session.getAttribute("usuario") == null) {
            throw new SessionNoIniciadaException("El usuario no tiene sesión activa");
        }

        Usuarios emeplado = (Usuarios) session.getAttribute("usuario");

        // Compruebo si el emplado es nulo
        if (emeplado == null) {
            throw new UsuarioNotFoundException("El usuario no existe");
        }
        model.addAttribute("empleado", emeplado);
        try {
            // Realizo la comprobacion del turno del usuario, si es diurno o nocturno
            if (emeplado.getTurno().equals("diurno")) {
                // Si es diurno, llamo al getter retención
                model.addAttribute("etiquetaExtra", "Retención");
                model.addAttribute("datoExtra", ((usuarioDiurno) emeplado).getRetencion());
                // Comperubo si el usuario es nocturno
            } else if (emeplado.getTurno().equals("nocturno")) {
                model.addAttribute("etiquetaExtra", "Plus productividad");
                model.addAttribute("datoExtra", ((usuarioNocturno) emeplado).getPlusProductividad());
            }
        } catch (Exception e) {
            // Si el usuario tiene los datos incorrectos
            throw new NullPointerException("Error. Los datos del empleado no cargan");
        }

        return "empleadoHome";
    }

    // Cierro la sesion y voy a la vista login
    @GetMapping("/empleado/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}

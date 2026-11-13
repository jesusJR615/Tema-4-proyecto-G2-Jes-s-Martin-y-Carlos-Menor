package practicag2.jessusycarlos.controllers;

import practicag2.jessusycarlos.models.Usuario;
import practicag2.jessusycarlos.services.AutenticacionService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

// Controlador MVC tradicional: gestiona vistas Thymeleaf.
// Endpoints: /login (GET/POST), /empleado/home, /empleado/logout.
@Controller
public class EmpleadoController {

    private final AutenticacionService autenticacionService;

    public EmpleadoController(AutenticacionService autenticacionService) {
        this.autenticacionService = autenticacionService;
    }

    // Muestra el formulario de login (Thymeleaf)
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // Procesa el login del formulario web: autentica y guarda en sesion, redirige a home
    @PostMapping("/login")
    public String login(@RequestParam String login, @RequestParam String password, HttpSession session) {
        Usuario empleado = autenticacionService.autenticar(login, password);
        session.setAttribute("empleado", empleado);
        return "redirect:/empleado/home";
    }

    // Pagina principal del empleado: muestra datos y campo extra segun turno
    @GetMapping("/empleado/home")
    public String home(HttpSession session, Model model) {
        Usuario empleado = (Usuario) session.getAttribute("empleado");
        model.addAttribute("empleado", empleado);

        // Calcula el dato extra segun el turno (polimorfismo)
        if (empleado.getTurno().equals("diurno")) {
            model.addAttribute("etiquetaExtra", "Retención");
            model.addAttribute("datoExtra", ((practicag2.jessusycarlos.models.UsuarioDiurno) empleado).getRetencion());
        } else if (empleado.getTurno().equals("nocturno")) {
            model.addAttribute("etiquetaExtra", "Plus productividad");
            model.addAttribute("datoExtra", ((practicag2.jessusycarlos.models.UsuarioNocturno) empleado).getPlusProductividad());
        }
        return "empleadoHome";
    }

    // Cierra la sesion y redirige al login
    @GetMapping("/empleado/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
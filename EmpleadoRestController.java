package practicag2.jessusycarlos.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import practicag2.jessusycarlos.models.Usuario;
import practicag2.jessusycarlos.services.AutenticacionService;

// Controlador REST: gestiona endpoints JSON para la interfaz asincrona.
// Endpoints: /api/login (POST), /api/empleado/home (GET), /api/empleado/logout (GET).
@RequestMapping("/api")
@RestController
public class EmpleadoRestController {

    private final AutenticacionService autenticacionService;

    public EmpleadoRestController(AutenticacionService autenticacionService) {
        this.autenticacionService = autenticacionService;
    }

    // Login REST: autentica, crea sesion y devuelve datos del empleado en JSON
    // (200)
    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestParam String login, @RequestParam String password,
            HttpSession session) {
        Usuario empleado = autenticacionService.autenticar(login, password);
        session.setAttribute("empleado", empleado);
        return ResponseEntity.ok(empleado);
    }

    // Home REST: devuelve datos del empleado autenticado (200). El interceptor
    // garantiza sesion.
    @GetMapping("/empleado/home")
    public ResponseEntity<Usuario> home(HttpSession session) {
        Usuario empleado = (Usuario) session.getAttribute("empleado");
        return ResponseEntity.ok(empleado);
    }

    // Logout REST: invalida la sesion y devuelve confirmacion JSON (200)
    @GetMapping("/empleado/logout")
    public ResponseEntity<Map<String, Object>> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok(Map.of("codigo", 200, "mensaje", "Sesión cerrada"));
    }
}
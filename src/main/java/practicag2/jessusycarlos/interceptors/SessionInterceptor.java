package practicag2.jessusycarlos.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component 
public class SessionInterceptor implements HandlerInterceptor {
    //Creo el preHandle
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        //Obtengo la session del usuario
        HttpSession session = request.getSession(false);

        //Compruebo si existe la sesión
        if(session == null || session.getAttribute("usuario") == null){
            System.out.println("[preHandle] Acceso denegado: No se ha podido iniciar la sesións");
        }
        return  true;
    }
}

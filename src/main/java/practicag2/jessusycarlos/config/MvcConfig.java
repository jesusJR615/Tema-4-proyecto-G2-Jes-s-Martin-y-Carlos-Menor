package practicag2.jessusycarlos.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import practicag2.jessusycarlos.interceptors.SessionInterceptor;

@Configuration 
public class MvcConfig implements WebMvcConfigurer {
    private final SessionInterceptor sessionInterceptor;

    MvcConfig(SessionInterceptor sessionInterceptor) {
        this.sessionInterceptor = sessionInterceptor;
    }

    @Override 
    public void addInterceptors(InterceptorRegistry registry){

        //REST -> Aquí van las rutas json
        registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/api/**", "/empleado/**");

        //MVC -> Aquí van las rutas web
        registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new SessionInterceptor()).excludePathPatterns("/login", "/api/login");
    }
    
}

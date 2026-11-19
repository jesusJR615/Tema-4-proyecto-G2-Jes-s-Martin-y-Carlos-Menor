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
    public void addInterceptors(InterceptorRegistry registry) {
        // Se protegen y se excluyen las rutas, tanto para REST como para MVC
        registry.addInterceptor(new SessionInterceptor())
                .addPathPatterns("/empleado/**", "/api/**")
                .excludePathPatterns(
                        "/login",
                        "/api/login",
                        "/css/**",
                        "/js/**",
                        "/html/**",
                        "/error",
                        "/favicon.ico");

    }

}

package practicag2.jessusycarlos.exceptiones;

public class LoginIncorrectoException extends RuntimeException{
    public LoginIncorrectoException(String mensaje){
        super(mensaje);
    }
    
}

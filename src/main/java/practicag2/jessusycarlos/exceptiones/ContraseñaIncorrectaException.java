package practicag2.jessusycarlos.exceptiones;

public class ContraseñaIncorrectaException extends RuntimeException {
    public ContraseñaIncorrectaException(String mensaje){
        super(mensaje);
    }
}

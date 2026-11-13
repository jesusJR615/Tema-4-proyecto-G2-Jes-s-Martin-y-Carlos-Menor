package practicag2.jessusycarlos.exceptiones;

public class CredencialesInvalidasException extends RuntimeException {
    public CredencialesInvalidasException(String mensaje){
        super(mensaje);
    }
}

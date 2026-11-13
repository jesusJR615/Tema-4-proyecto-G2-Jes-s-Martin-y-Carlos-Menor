package practicag2.jessusycarlos.exceptiones;


public class SessionNoIniciadaException extends RuntimeException {
    public SessionNoIniciadaException(String mensaje){
        super(mensaje);
    }
}

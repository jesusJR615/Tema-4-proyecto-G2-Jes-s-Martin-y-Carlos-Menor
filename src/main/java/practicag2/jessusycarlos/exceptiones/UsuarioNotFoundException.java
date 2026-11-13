package practicag2.jessusycarlos.exceptiones;

public class UsuarioNotFoundException extends RuntimeException {
    public UsuarioNotFoundException(String mensaje){
        super(mensaje);
    }
}

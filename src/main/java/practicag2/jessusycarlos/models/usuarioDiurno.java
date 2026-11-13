package practicag2.jessusycarlos.models;

public class usuarioDiurno extends Usuarios {
    // Creo el atributo retencion 
    private int retencion;

    // Creo un contructor vacio
    public usuarioDiurno() {

    }

    // creo el constructor con todos los atributos
    public usuarioDiurno(int id, String nombre, String login, String password, int nivel, String turno, int retencion) {
        super(id, nombre, login, password, nivel, turno);
        this.retencion = retencion;
    }

    // Setter y Getter
        public int getRetencion() {
        return retencion;
    }

    public void setRetencion(int retencion) {
        this.retencion = retencion;
    }
    

    @Override
    public String toString() {
        return "Usuario-Diurno{" +
                ", retencion=" + retencion +
                '}';
    }

}

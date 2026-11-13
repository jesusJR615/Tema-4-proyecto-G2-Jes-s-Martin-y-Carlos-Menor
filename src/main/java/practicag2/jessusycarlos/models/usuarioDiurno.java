package practicag2.jessusycarlos.models;

public class usuarioDiurno extends Usuarios {
    // Creo el atributo retencion 
    private double retencion;

    // Creo un contructor vacio
    public usuarioDiurno() {

    }

    // creo el constructor con todos los atributos
    public usuarioDiurno(int id, String nombre, String login, String password, int nivel, String turno, double retencion) {
        super(id, nombre, login, password, nivel, turno);
        this.retencion = retencion;
    }

    // Setter y Getter
        public double getRetencion() {
        return retencion;
    }

    public void setRetencion(double retencion) {
        this.retencion = retencion;
    }
    

    @Override
    public String toString() {
        return "Usuario-Diurno{" +
                ", retencion=" + retencion +
                '}';
    }

}

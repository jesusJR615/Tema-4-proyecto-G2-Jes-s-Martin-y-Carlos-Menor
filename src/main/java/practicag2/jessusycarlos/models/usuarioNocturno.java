package practicag2.jessusycarlos.models;

public class usuarioNocturno extends Usuarios {
    // Atributos del json
    private double plusProductividad;

    // Constructor vacio
    public usuarioNocturno() {

    }

    // constructor con los atributos
    public usuarioNocturno(int id, String nombre, String login, String password, int nivel, String turno,
            double plusProductividad) {
                super(id, nombre, login, password, nivel, turno);
        this.plusProductividad = plusProductividad;
    }

    // Setter y Getter
    public double getPlusProductividad() {
        return plusProductividad;
    }

    public void setPlusProductividad(double plusProductividad) {
        this.plusProductividad = plusProductividad;
    }

    @Override
    public String toString() {
        return "Usuario-Diurno{" +
                ", plusProductividad=" + plusProductividad +
                '}';
    }
}

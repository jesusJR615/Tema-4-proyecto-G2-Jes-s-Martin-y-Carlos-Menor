package practicag2.jessusycarlos.models;

public class usuarioNocturno extends Usuarios {
    // Atributos del json
    private int plusProductividad;

    // Constructor vacio
    public usuarioNocturno() {

    }

    // constructor con los atributos
    public usuarioNocturno(int id, String nombre, String login, String password, int nivel, String turno,
            int plusProductividad) {
                super(id, nombre, login, password, nivel, turno);
        this.plusProductividad = plusProductividad;
    }

    // Setter y Getter
    public int getplusProductividad() {
        return plusProductividad;
    }

    public void setplusProductividad(int plusProductividad) {
        this.plusProductividad = plusProductividad;
    }

    @Override
    public String toString() {
        return "Usuario-Diurno{" +
                ", plusProductividad=" + plusProductividad +
                '}';
    }
}

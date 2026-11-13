package practicag2.jessusycarlos.models;

public abstract class Usuarios {
    // Creo los atributos, basandome en el json
    private int id;
    private String nombre;
    private String login;
    private String password;
    private int nivel;
    private String turno;

    // creo el constructor vacio
    public Usuarios() {

    }

    // creo el constructor con todos los Atributos
    public Usuarios(int id, String nombre, String login, String password, int nivel, String turno) {
        this.id = id;
        this.nombre = nombre;
        this.login = login;
        this.password = password;
        this.nivel = nivel;
        this.turno = turno;
    }

    // Setter y Getter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", nivel=" + nivel +
                ", turno='" + turno + '\'' +
                '}';
    }
}

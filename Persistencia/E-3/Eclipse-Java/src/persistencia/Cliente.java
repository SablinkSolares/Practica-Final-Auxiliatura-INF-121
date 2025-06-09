package persistencia;
import java.io.Serializable;

public class Cliente implements Serializable {
    private int id;
    private String nombre;
    private int telefono;

    public Cliente(int id, String nombre, int telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String toFileString() {
        return id + "," + nombre + "," + telefono;
    }

    public static Cliente fromFileString(String data) {
        String[] parts = data.split(",");
        return new Cliente(
            Integer.parseInt(parts[0]),
            parts[1],
            Integer.parseInt(parts[2])
        );
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Teléfono: " + telefono;
    }
}
package persistencia;

public class Medicamento {
    private String nombre;
    private int codMedicamento;
    private String tipo;
    private double precio;

    // Constructor
    public Medicamento(String nombre, int codMedicamento, String tipo, double precio) {
        this.nombre = nombre;
        this.codMedicamento = codMedicamento;
        this.tipo = tipo;
        this.precio = precio;
    }

    // Métodos getters y setters
    public String getNombre() {
        return nombre;
    }

    public int getCodMedicamento() {
        return codMedicamento;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }

    // Método para mostrar información
    public void mostrar() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Código: " + codMedicamento);
        System.out.println("Tipo: " + tipo);
        System.out.println("Precio: " + precio);
    }
}

package persistencia;
import java.util.ArrayList;

public class Farmacia {
    private String nombreFarmacia;
    private int sucursal;
    private String direccion;
    private ArrayList<Medicamento> medicamentos;

    // Constructor
    public Farmacia(String nombreFarmacia, int sucursal, String direccion) {
        this.nombreFarmacia = nombreFarmacia;
        this.sucursal = sucursal;
        this.direccion = direccion;
        this.medicamentos = new ArrayList<>();
    }

    // Métodos getters y setters
    public String getNombreFarmacia() {
        return nombreFarmacia;
    }

    public int getSucursal() {
        return sucursal;
    }

    public String getDireccion() {
        return direccion;
    }

    public ArrayList<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    // Método para agregar medicamento
    public void agregarMedicamento(Medicamento medicamento) {
        medicamentos.add(medicamento);
    }

    // Método para mostrar información de la farmacia
    public void mostrar() {
        System.out.println("Farmacia: " + nombreFarmacia);
        System.out.println("Sucursal: " + sucursal);
        System.out.println("Dirección: " + direccion);
        System.out.println("Medicamentos:");
        for (Medicamento m : medicamentos) {
            m.mostrar();
            System.out.println("--------------------");
        }
    }

    // Método para buscar medicamentos por tipo
    public ArrayList<Medicamento> buscarMedicamentosPorTipo(String tipo) {
        ArrayList<Medicamento> resultado = new ArrayList<>();
        for (Medicamento m : medicamentos) {
            if (m.getTipo().equalsIgnoreCase(tipo)) {
                resultado.add(m);
            }
        }
        return resultado;
    }
}
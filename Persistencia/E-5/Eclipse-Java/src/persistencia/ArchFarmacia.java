package persistencia;
import java.io.*;
import java.util.ArrayList;

public class ArchFarmacia {
    private String archivoNombre;

    // Constructor
    public ArchFarmacia(String archivoNombre) {
        this.archivoNombre = archivoNombre;
    }

    // Método para crear el archivo
    public void crearArchivo() throws IOException {
        File archivo = new File(archivoNombre);
        if (!archivo.exists()) {
            archivo.createNewFile();
        }
    }

    // Método para agregar una farmacia al archivo
    public void adicionar(Farmacia farmacia) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoNombre, true))) {
            writer.write(farmacia.getNombreFarmacia() + "," +
                        farmacia.getSucursal() + "," +
                        farmacia.getDireccion() + "\n");

            for (Medicamento m : farmacia.getMedicamentos()) {
                writer.write(m.getNombre() + "," +
                            m.getCodMedicamento() + "," +
                            m.getTipo() + "," +
                            m.getPrecio() + "\n");
            }
            writer.write("FIN_FARMACIA\n");
        }
    }

    // Método para listar todas las farmacias
    public ArrayList<Farmacia> listar() throws IOException {
        ArrayList<Farmacia> farmacias = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoNombre))) {
            String linea;
            Farmacia farmaciaActual = null;
            ArrayList<Medicamento> medicamentosActual = null;

            while ((linea = reader.readLine()) != null) {
                if (linea.contains("FIN_FARMACIA")) {
                    if (farmaciaActual != null) {
                        farmacias.add(farmaciaActual);
                    }
                    continue;
                }

                if (farmaciaActual == null) {
                    String[] datosFarmacia = linea.split(",");
                    farmaciaActual = new Farmacia(datosFarmacia[0], Integer.parseInt(datosFarmacia[1]), datosFarmacia[2]);
                    medicamentosActual = new ArrayList<>();
                } else {
                    String[] datosMedicamento = linea.split(",");
                    Medicamento med = new Medicamento(
                            datosMedicamento[0],
                            Integer.parseInt(datosMedicamento[1]),
                            datosMedicamento[2],
                            Double.parseDouble(datosMedicamento[3])
                    );
                    medicamentosActual.add(med);
                }
            }
        }
        return farmacias;
    }

    // Método para mostrar medicamentos para la tos de una sucursal específica
    public ArrayList<Medicamento> mostrarMedicamentosTos(int sucursal) throws IOException {
        ArrayList<Medicamento> resultado = new ArrayList<>();
        ArrayList<Farmacia> farmacias = listar();

        for (Farmacia f : farmacias) {
            if (f.getSucursal() == sucursal) {
                resultado.addAll(f.buscarMedicamentosPorTipo("tos"));
            }
        }
        return resultado;
    }

    public void mostrarSucursalesConMedicamento(String nombreMedicamento) throws IOException {
        ArrayList<Farmacia> farmacias = listar();

        for (Farmacia f : farmacias) {
            for (Medicamento m : f.getMedicamentos()) {
                if (m.getNombre().equalsIgnoreCase(nombreMedicamento)) {
                    System.out.println("Sucursal: " + f.getSucursal());
                    System.out.println("Dirección: " + f.getDireccion());
                    System.out.println("--------------------");
                }
            }
        }
    }
}

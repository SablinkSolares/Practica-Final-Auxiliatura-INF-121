package persistencia;
import java.io.IOException;
import java.util.ArrayList;

public class Apy {
    public static void main(String[] args) {
        try {
            
            ArchFarmacia arch = new ArchFarmacia("farmacias.txt");
            arch.crearArchivo();

            
            Farmacia farmacia1 = new Farmacia("Farmacorp", 1, "Calle Buenos Aires 123");
            farmacia1.agregarMedicamento(new Medicamento("Mentisan Plus", 101, "Resfriado", 5.0));
            farmacia1.agregarMedicamento(new Medicamento("Golpex", 102, "Herida", 7.5));

            Farmacia farmacia2 = new Farmacia("Farmacia Chavez", 2, "Avenida 6 de Agisto 456");
            farmacia2.agregarMedicamento(new Medicamento("Amoxicilina", 201, "Neumonia", 3.0));
            farmacia2.agregarMedicamento(new Medicamento("Golpex", 202, "Herida", 8.0));

            
            arch.adicionar(farmacia1);
            arch.adicionar(farmacia2);

          
            System.out.println("Listado de Farmacias:");
            ArrayList<Farmacia> farmacias = arch.listar();
            for (Farmacia f : farmacias) {
                f.mostrar();
            }

       
            System.out.println("\nMedicamentos para la tos de la sucursal 1:");
            ArrayList<Medicamento> medicamentosTos = arch.mostrarMedicamentosTos(1);
            for (Medicamento m : medicamentosTos) {
                m.mostrar();
            }

          
            System.out.println("\nSucursales con el medicamento 'Golpex':");
            arch.mostrarSucursalesConMedicamento("Golpex");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
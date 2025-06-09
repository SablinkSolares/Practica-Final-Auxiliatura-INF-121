package persistencia;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArchivoCliente {
    private String nomA;

    public ArchivoCliente(String nomA) {
        this.nomA = nomA;
        crearArchivoSiNoExiste();
    }

    private void crearArchivoSiNoExiste() {
        try {
            File file = new File(nomA);
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + e.getMessage());
        }
    }

    public void guardaCliente(Cliente cliente) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomA, true))) {
            writer.write(cliente.toFileString());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error al guardar cliente: " + e.getMessage());
        }
    }

    public Cliente buscarCliente(int id) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomA))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Cliente cliente = Cliente.fromFileString(line);
                if (cliente.getId() == id) {
                    return cliente;
                }
            }
        } catch (IOException e) {
            System.err.println("Error al buscar cliente: " + e.getMessage());
        }
        return null;
    }

    public Cliente buscarCelularCliente(int telefono) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomA))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Cliente cliente = Cliente.fromFileString(line);
                if (cliente.getTelefono() == telefono) {
                    return cliente;
                }
            }
        } catch (IOException e) {
            System.err.println("Error al buscar cliente por teléfono: " + e.getMessage());
        }
        return null;
    }
}
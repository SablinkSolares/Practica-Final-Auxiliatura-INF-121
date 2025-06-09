package persistencia;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArchivoEmpleado {
    private String nomA; 
    private List<Empleado> empleados; 

    public ArchivoEmpleado(String nomA) {
        this.nomA = nomA;
        this.empleados = new ArrayList<>();
        cargarEmpleados();
    }

    public void crearArchivo() {
        try {
            File file = new File(nomA);
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("Archivo creado: " + nomA);
            } else {
                System.out.println("El archivo ya existe.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void guardarEmpleado(Empleado e) {
        empleados.add(e);
        guarda();
    }

    public Empleado buscaEmpleado(String nombre) {
        for (Empleado emp : empleados) {
            if (emp.getNombre().equals(nombre)) {
                return emp;
            }
        }
        return null;
    }

    public Empleado mayorSalario(float sueldo) {
        for (Empleado emp : empleados) {
            if (emp.getSalario() > sueldo) {
                return emp;
            }
        }
        return null;
    }

    private void cargarEmpleados() {
        try {
            File file = new File(nomA);
            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 3) {
                        String nombre = parts[0];
                        int edad = Integer.parseInt(parts[1]);
                        float salario = Float.parseFloat(parts[2]);
                        empleados.add(new Empleado(nombre, edad, salario));
                    }
                }
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void guarda() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(nomA));
            for (Empleado emp : empleados) {
                writer.write(emp.getNombre() + "," + emp.getEdad() + "," + emp.getSalario());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarEmpleados() {
        for (Empleado emp : empleados) {
            System.out.println(emp);
        }
    }
}

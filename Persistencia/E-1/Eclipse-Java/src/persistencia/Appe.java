package persistencia;

public class Appe {
    public static void main(String[] args) {
        ArchivoEmpleado archivo = new ArchivoEmpleado("empleados.txt");

        
        archivo.crearArchivo();

       
        archivo.guardarEmpleado(new Empleado("Norman", 30, 5000));
        archivo.guardarEmpleado(new Empleado("Katty", 25, 6000));
        archivo.guardarEmpleado(new Empleado("Eliseo", 35, 7000));

        
        archivo.mostrarEmpleados();

       
        Empleado encontrado = archivo.buscaEmpleado("Maria");
        if (encontrado != null) {
            System.out.println("Empleado encontrado: " + encontrado);
        } else {
            System.out.println("Empleado no encontrado.");
        }
        Empleado mayorSalario = archivo.mayorSalario(5500);
        if (mayorSalario != null) {
            System.out.println("Empleado con salario mayor a 5500: " + mayorSalario);
        } else {
            System.out.println("No hay empleados con salario mayor a 5500.");
        }
    }
}

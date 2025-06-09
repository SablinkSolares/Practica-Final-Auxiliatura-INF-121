package persistencia;

public class Appl {
    public static void main(String[] args) {
        ArchivoCliente archivo = new ArchivoCliente("clientes.txt");
        
        // Guardar nuevos clientes
        archivo.guardaCliente(new Cliente(1, "Manuel Torrez", 76543210));
        archivo.guardaCliente(new Cliente(2, "Gabriela Mamani", 71234567));

        // Buscar cliente por ID
        Cliente cli = archivo.buscarCliente(1);
        if (cli != null) {
            System.out.println("Cliente encontrado: " + cli);
        } else {
            System.out.println("Cliente no encontrado");
        }

        // Buscar cliente por teléfono
        Cliente cliTel = archivo.buscarCelularCliente(71234567);
        if (cliTel != null) {
            System.out.println("Cliente encontrado por teléfono: " + cliTel);
        } else {
            System.out.println("Cliente no encontrado por teléfono");
        }
    }
}

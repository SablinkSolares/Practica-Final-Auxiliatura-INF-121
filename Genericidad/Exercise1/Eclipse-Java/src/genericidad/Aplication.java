package genericidad;

class Caja <T> {
	protected T content;
	
	public void guardar(T b) {
		this.content=b;
	}
	
	public T obtener() {
		return this.content;
	}
}
public class Aplication {
	public static void main(String[] args) {
		System.out.println("Genericidad");
		System.out.println("------------------------");
		System.out.println("Ejercicio-1: ");
		System.out.println("Caja para Guardar algun tipo de objeto: ");
		System.out.println("------------------------");
		Caja<Integer> cn1 = new Caja<>();
		cn1.guardar(1500);
		Caja<String> cs2 = new Caja<>();
		cs2.guardar("Si puedes Imaginarlo , puedes Programarlo.");
		System.out.println("Caja de Tipo Integer: "+cn1.obtener());
		System.out.println("Caja de Tipo String: "+cs2.obtener());
		System.out.println("------------------------");
		
	}
}

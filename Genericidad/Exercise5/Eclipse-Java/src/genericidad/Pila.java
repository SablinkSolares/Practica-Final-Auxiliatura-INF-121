package genericidad;
import java.util.ArrayList;
import java.util.List;

public class Pila<T> {
    private List<T> Z; 

    public Pila() {
        this.Z = new ArrayList<>();
    }

    public void push(T x) {
        Z.add(x);
    }

    public T pop() {
        if (Z.isEmpty()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return Z.remove(Z.size() - 1);
    }

    public void mostrar() {
    	System.out.println("Pila Prueba: ");
        System.out.println("Elementos de la pila: " + Z);
    }

    public boolean isEmpty() {
        return Z.isEmpty();
    }

    public int size() {
        return Z.size();
    }

    public T peek() {
        if (Z.isEmpty()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return Z.get(Z.size() - 1);
    }

    public static void main(String[] args) {
        Pila<Integer> pila1 = new Pila<>();
        pila1.push(15);
        pila1.push(30);
        pila1.push(45);
        pila1.mostrar();

        System.out.println("Desapilando: " + pila1.pop());
        pila1.mostrar();

        Pila<String> pila2 = new Pila<>();
        pila2.push("Tralalero");
        pila2.push("Tralala");
        pila2.mostrar();

        System.out.println("Desapilando: " + pila2.pop());
        pila2.mostrar();

        class Persona {
            String nombre;
            int edad;

            public Persona(String nombre, int edad) {
                this.nombre = nombre;
                this.edad = edad;
            }

            @Override
            public String toString() {
                return "Persona{" + "Nombre : '" + nombre + "', Edad :" + edad + '}';
            }
        }

        Pila<Persona> pila3 = new Pila<>();
        pila3.push(new Persona("Daniela",30));
        pila3.push(new Persona("Hugo", 50));
        pila3.mostrar();

        System.out.println("Desapilando: " + pila3.pop());
        pila3.mostrar();
    }
}

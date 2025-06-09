package genericidad;
import java.util.ArrayList;
import java.util.function.Predicate;

class Catalogo<T> {
    private ArrayList<T> W;
    
    public Catalogo() {
        W = new ArrayList<T>();
    }
    
    public void agregando(T r) {
        W.add(r);
    }
    
    public T encuentra(Predicate<T> p) {
        for(T j : W) {
            if(p.test(j)) {
                return j;
            }
        }
        return null;
    }
    
    public ArrayList<T> getElementos() {
        return W;
    }
}

class Libro {
    private String genero;
    private String autor;
    private String titulo;
    
    public Libro(String titulo, String autor, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public String getAutor() {
        return autor;
    }
    
    public String getGenero() {
        return genero;
    }
    
    public String toString() {
        return String.format("[ Titulo: %s, Autor: %s, Genero: %s ]", this.titulo, this.autor, this.genero);
    }
}

class Producto {
    private String nombre;
    private double precio;
    private String marca;
    
    public Producto(String nombre, double precio, String marca) {
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public String getMarca() {
        return marca;
    }
    
    public String toString() {
        return String.format("[ Nombre del Producto: %s, Precio: %.2f Bs, Marca: %s ]",this.nombre, this.precio, this.marca);
    }
}

public class Appy {
    public static void main(String[] args) {
        System.out.println("-Genericidad 2-");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Ejercicio-3: ");
        System.out.println("Catalogo que Almacena Productos o Libros");
        System.out.println("----------------------------------------------------------------------------------");
        Catalogo<Libro> cl1 = new Catalogo<>();
        cl1.agregando(new Libro("Borracho estaba pero me acuerdo", "Victor Hugo Viscarra", "Ciencia Ficcion"));
        cl1.agregando(new Libro("20 Poemas de Amor y una Cancion Desesperada", "Pablo Neruda", "Poesia"));
        cl1.agregando(new Libro("Game of Thrones", "George Raymond Richard Martin", "Fantasia"));
        System.out.println("Catalogo de los Libros: ");
        cl1.getElementos().forEach(System.out::println);
        System.out.println("----------------------------------------------------------------------------------");
        Libro busca1 = cl1.encuentra(l -> l.getTitulo().equals("Game of Thrones"));
        System.out.println("Libro encontrado: " + busca1);
        System.out.println("----------------------------------------------------------------------------------");
        Catalogo<Producto> cp1 = new Catalogo<>();
        cp1.agregando(new Producto("Yogurt",25, "Pil"));
        cp1.agregando(new Producto("Whisky",1600, "Jhonnie Walker"));
        cp1.agregando(new Producto("Galletas",10, "Ferrari"));
        System.out.println("Catálogo de Productos: ");
        System.out.println("----------------------------------------------------------------------------------");
        Producto busca2 = cp1.encuentra(p -> p.getMarca().equals("Jhonnie Walker"));
        System.out.println("Producto Encontrado: " + busca2);
        System.out.println("----------------------------------------------------------------------------------");
    }
}

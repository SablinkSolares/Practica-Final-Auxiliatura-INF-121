from typing import List, TypeVar, Callable, Optional

T = TypeVar('T')

class Catalogo:
    def __init__(self):
        self.__A: List[T] = []
    
    def agregar(self, i: T) -> None:
        self.__A.append(i)
    
    def buscar(self, d: Callable[[T], bool]) -> Optional[T]:
        for k in self.__A:
            if d(k):
                return k
        return None
    
    def get_elementos(self) -> List[T]:
        return self.__A.copy()

class Libro:
    def __init__(self, titulo: str, autor: str, genero: str):
        self.__titulo = titulo
        self.__autor = autor
        self.__genero = genero
    
    @property
    def titulo(self) -> str:
        return self.__titulo
    
    @property
    def autor(self) -> str:
        return self.__autor
    
    @property
    def genero(self) -> str:
        return self.__genero
    
    def __str__(self):
        return f"Libro(Titulo='{self.__titulo}', Autor='{self.__autor}', Genero='{self.__genero}')"

class Producto:
    def __init__(self, nombre: str, precio: float, marca: str):
        self.__nombre = nombre
        self.__precio = precio
        self.__marca = marca
    
    @property
    def nombre(self) -> str:
        return self.__nombre
    
    @property
    def precio(self) -> float:
        return self.__precio
    
    @property
    def marca(self) -> str:
        return self.__marca
    
    def __str__(self):
        return f"Producto(Nombre='{self.__nombre}', Precio={self.__precio}, Marca='{self.__marca}')"


catalib1 = Catalogo()
catalib1.agregar(Libro("Borracho estaba pero me acuerdo", "Victor Hugo Viscarra", "Ciencia Ficcion"))
catalib1.agregar(Libro("20 Poemas de Amor y una Cancion Desesperada", "Pablo Neruda", "Poesia"))
catalib1.agregar(Libro("Game of Thrones", "George Raymond Richard Martin", "Fantasia"))

print("Catálogo de libros:")
for h in catalib1.get_elementos():
    print(h)

libro_buscado = catalib1.buscar(lambda l: l.titulo == "Game of Thrones")
print("\nLibro encontrado:", libro_buscado)
catalib2 = Catalogo()
catalib2.agregar(Producto("Yogurt", 25, "Pil"))
catalib2.agregar(Producto("Whisky", 1600, "Jhonnie Walker"))
catalib2.agregar(Producto("Galletas", 10, "Ferrari"))

print("\nCatálogo de productos:")
for k in catalib2.get_elementos():
    print(k)

d = catalib2.buscar(lambda p: p.marca == "Jhonnie Walker")
print("\nProducto encontrado:",d)
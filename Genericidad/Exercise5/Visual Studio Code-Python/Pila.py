from typing import Generic, TypeVar, List
T = TypeVar('T')

class Pila(Generic[T]):
    def __init__(self):
        self.L: List[T] = []  
    def push(self, g: T) -> None:
        self.L.append(g)
    def pop(self) -> T:
        if not self.L:
            raise IndexError("La pila está vacía")
        return self.L.pop()
    def mostrar(self) -> None:
        print("Pila Prueba: ")
        print("Elementos de la pila:", self.L)
    def is_empty(self) -> bool:
        return len(self.L) == 0
    def size(self) -> int:
        return len(self.L)
    def peek(self) -> T:
        if not self.L:
            raise IndexError("La pila está vacía")
        return self.L[-1]

pilant = Pila[int]()
pilant.push(10)
pilant.push(20)
pilant.push(30)
pilant.mostrar() 
print("Desapilando:", pilant.pop()) 
pilant.mostrar() 
pilacad = Pila[str]()
pilacad.push("Gallina")
pilacad.push("Turuleca")
pilacad.mostrar()
print("Desapilando:", pilacad.pop()) 
pilacad.mostrar()

class Persona:
        def __init__(self, nombre: str, edad: int):
            self.nombre = nombre
            self.edad = edad

        def __repr__(self):
            return f"Persona(nombre='{self.nombre}', edad={self.edad})"

pilaper = Pila[Persona]()
pilaper.push(Persona("Evelyn", 35))
pilaper.push(Persona("Roberto",30))
pilaper.mostrar() 
print("Desapilando:", pilaper.pop()) 
pilaper.mostrar()
from typing import TypeVar,Generic
T=TypeVar("T")
class Caja(Generic[T]):
    def __init__(self):
        self._content: T | None = None
    def guardar(self,q:T)->None:
        self._content=q
    def obtener(self)->T:
        return self._content
boxnum1:Caja[float]=Caja()
boxnum1.guardar(100)
boxstr2:Caja[str]=Caja()
boxstr2.guardar("Mi Teleférico-Uniendo Nuestras Vidas.")
print("-----------------------------Genericidad-----------------------------")
print("Ejercicio 1: ")
print("---------------------------------------------------------------------")
print("Caja para Guardar algún tipo de objeto: ")
print("---------------------------------------------------------------------")
print("Caja de Ñumeros: ", boxnum1.obtener())
print("Caja de Texto-Cadena-String: ", boxstr2.obtener())
print("---------------------------------------------------------------------")


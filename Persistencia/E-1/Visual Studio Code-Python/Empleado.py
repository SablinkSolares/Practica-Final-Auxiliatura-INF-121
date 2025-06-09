import json

class Empleado:
    def __init__(self, nombre, edad, salario):
        self.nombre = nombre
        self.edad = edad
        self.salario = salario

    def __str__(self):
        return f"Empleado{{nombre='{self.nombre}', edad={self.edad}, salario={self.salario}}}"

class ArchivoEmpleado:
    def __init__(self, nom_archivo):
        self.nom_archivo = nom_archivo
        self.empleados = []
        self.cargar_empleados()

    def crear_archivo(self):
        try:
            with open(self.nom_archivo, 'w') as file:
                json.dump([], file)
        except:
            pass

    def guardar_empleado(self, empleado):
        self.empleados.append({
            "nombre": empleado.nombre,
            "edad": empleado.edad,
            "salario": empleado.salario
        })
        self.guardar_en_archivo()

    def busca_empleado(self, nombre):
        for emp in self.empleados:
            if emp["nombre"] == nombre:
                return Empleado(emp["nombre"], emp["edad"], emp["salario"])
        return None

    def mayor_salario(self, sueldo):
        for emp in self.empleados:
            if emp["salario"] > sueldo:
                return Empleado(emp["nombre"], emp["edad"], emp["salario"])
        return None

    def mostrar_empleados(self):
        for emp in self.empleados:
            print(Empleado(emp["nombre"], emp["edad"], emp["salario"]))

    def cargar_empleados(self):
        try:
            with open(self.nom_archivo, 'r') as file:
                self.empleados = json.load(file)
        except FileNotFoundError:
            self.crear_archivo()
        except:
            pass

    def guardar_en_archivo(self):
        with open(self.nom_archivo, 'w') as file:
            json.dump(self.empleados, file, indent=4)
archivo = ArchivoEmpleado("empleados.json")
archivo.guardar_empleado(Empleado("Lucia", 30, 4500))
archivo.mostrar_empleados()            
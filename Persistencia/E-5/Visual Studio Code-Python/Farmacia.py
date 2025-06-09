import json

# Clase Medicamento
class Medicamento:
    def __init__(self, nombre, cod_med, tipo, precio):
        self.nombre = nombre
        self.cod_med = cod_med
        self.tipo = tipo
        self.precio = precio

    def mostrar(self):
        print(f"Nombre: {self.nombre}")
        print(f"Código: {self.cod_med}")
        print(f"Tipo: {self.tipo}")
        print(f"Precio: {self.precio}")


# Clase Farmacia
class Farmacia:
    def __init__(self, nombre_farmacia, sucursal, direccion):
        self.nombre_farmacia = nombre_farmacia
        self.sucursal = sucursal
        self.direccion = direccion
        self.medicamentos = []

    def agregar_medicamento(self, medicamento):
        self.medicamentos.append(medicamento)

    def mostrar(self):
        print(f"Farmacia: {self.nombre_farmacia}")
        print(f"Sucursal: {self.sucursal}")
        print(f"Dirección: {self.direccion}")
        print("Medicamentos:")
        for med in self.medicamentos:
            med.mostrar()
            print("--------------------")

    def buscar_medicamentos_por_tipo(self, tipo):
        return [med for med in self.medicamentos if med.tipo.lower() == tipo.lower()]


# Clase ArchFarmacia para Persistencia con JSON
class ArchFarmacia:
    def __init__(self, archivo_nombre):
        self.archivo_nombre = archivo_nombre

    def crear_archivo(self):
        with open(self.archivo_nombre, 'w') as file:
            json.dump([], file)

    def adicionar(self, farmacia):
        # Leer el archivo existente
        with open(self.archivo_nombre, 'r') as file:
            data = json.load(file)

        # Convertir la farmacia a diccionario
        farmacia_dict = {
            'nombre_farmacia': farmacia.nombre_farmacia,
            'sucursal': farmacia.sucursal,
            'direccion': farmacia.direccion,
            'medicamentos': [
                {
                    'nombre': med.nombre,
                    'cod_med': med.cod_med,
                    'tipo': med.tipo,
                    'precio': med.precio
                } for med in farmacia.medicamentos
            ]
        }

        # Agregar la farmacia al archivo
        data.append(farmacia_dict)

        # Guardar el archivo actualizado
        with open(self.archivo_nombre, 'w') as file:
            json.dump(data, file, indent=4)

    def listar(self):
        with open(self.archivo_nombre, 'r') as file:
            data = json.load(file)
        return data

    def mostrar_medicamentos_tos(self, sucursal):
        farmacias = self.listar()
        resultado = []
        for farmacia in farmacias:
            if farmacia['sucursal'] == sucursal:
                for med in farmacia['medicamentos']:
                    if med['tipo'].lower() == 'tos':
                        resultado.append(Medicamento(med['nombre'], med['cod_med'], med['tipo'], med['precio']))
        return resultado

    def mostrar_sucursales_con_medicamento(self, nombre_medicamento):
        farmacias = self.listar()
        for farmacia in farmacias:
            for med in farmacia['medicamentos']:
                if med['nombre'].lower() == nombre_medicamento.lower():
                    print(f"Sucursal: {farmacia['sucursal']}")
                    print(f"Dirección: {farmacia['direccion']}")
                    print("--------------------")


# Ejecución del programa
# Crear archivo
arch = ArchFarmacia("farmacias.json")
arch.crear_archivo()

# Crear farmacias y medicamentos
farmacia1 = Farmacia("Farmacorp", 1, "Calle Nistaus 123")
farmacia1.agregar_medicamento(Medicamento("Ibuprofeno", 101, "Dolor", 5.0))
farmacia1.agregar_medicamento(Medicamento("Golpex", 102, "Herida", 7.5))

farmacia2 = Farmacia("Farmacia Chavez", 2, "Avenida Panoramica 456")
farmacia2.agregar_medicamento(Medicamento("Paracetamol", 201, "Fiebre", 3.0))
farmacia2.agregar_medicamento(Medicamento("Golpex", 202, "Herida", 8.0))

# Agregar farmacias al archivo
arch.adicionar(farmacia1)
arch.adicionar(farmacia2)

# Listar todas las farmacias
print("Listado de Farmacias:")
farmacias = arch.listar()
for farmacia in farmacias:
    print(f"Farmacia: {farmacia['nombre_farmacia']}")
    print(f"Sucursal: {farmacia['sucursal']}")
    print(f"Dirección: {farmacia['direccion']}")
    print("Medicamentos:")
    for med in farmacia['medicamentos']:
        print(f"  Nombre: {med['nombre']}, Tipo: {med['tipo']}, Precio: {med['precio']}")
    print("--------------------")

# Mostrar medicamentos para la tos de la sucursal 1
print("\nMedicamentos para la tos de la sucursal 1:")
medicamentos_tos = arch.mostrar_medicamentos_tos(1)
for med in medicamentos_tos:
    med.mostrar()

# Mostrar sucursales que tienen el medicamento "Golpex"
print("\nSucursales con el medicamento 'Golpex':")
arch.mostrar_sucursales_con_medicamento("Golpex")
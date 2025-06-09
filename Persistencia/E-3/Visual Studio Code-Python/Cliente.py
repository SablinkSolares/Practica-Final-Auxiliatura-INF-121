import json

class Cliente:
    def __init__(self, id, nombre, telefono):
        self.__id = id
        self.__nombre = nombre
        self.__telefono = telefono

    def to_dict(self):
        return {
            "id": self.__id,
            "nombre": self.__nombre,
            "telefono": self.__telefono
        }

    @staticmethod
    def from_dict(data):
        return Cliente(data["id"], data["nombre"], data["telefono"])

    def get_id(self):
        return self.__id

    def get_nombre(self):
        return self.__nombre

    def get_telefono(self):
        return self.__telefono

    def __str__(self):
        return f"ID: {self.__id}, Nombre: {self.__nombre}, Teléfono: {self.__telefono}"

class ArchivoCliente:
    def __init__(self, nomA):
        self.__nomA = nomA
        self.__crear_archivo_si_no_existe()

    def __crear_archivo_si_no_existe(self):
        try:
            with open(self.__nomA, 'r') as f:
                json.load(f)
        except (FileNotFoundError, json.JSONDecodeError):
            with open(self.__nomA, 'w') as f:
                json.dump([], f)

    def guarda_cliente(self, cliente):
        with open(self.__nomA, 'r') as f:
            datos = json.load(f)
        datos.append(cliente.to_dict())
        with open(self.__nomA, 'w') as f:
            json.dump(datos, f, indent=2)

    def buscar_cliente(self, c):
        with open(self.__nomA, 'r') as f:
            datos = json.load(f)
        for item in datos:
            if item['id'] == c:
                return Cliente.from_dict(item)
        return None

    def buscar_celular_cliente(self, c):
        return self.buscar_cliente(c)


archivo = ArchivoCliente("clientes.json")
archivo.guarda_cliente(Cliente(1, "Manuel Torrez", 76543210))
archivo.guarda_cliente(Cliente(2, "Gabriela Mamani", 71234567))

cli = archivo.buscar_cliente(1)
if cli:
    print("Cliente encontrado:", cli)

cli_tel = archivo.buscar_celular_cliente(2)
if cli_tel:
    print("Cliente y celular:", cli_tel)
else:
    print("Cliente no encontrado por celular.")


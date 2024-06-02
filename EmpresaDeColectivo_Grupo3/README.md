## Enunciado para la creación de una aplicación Java de escritorio para la administración de la venta de pasajes de colectivos para la empresa SOL BUS Línea La Punta. (31-05-2024)

### Objetivo

Desarrollar una aplicación Java de escritorio que permita administrar la venta de pasajes de una empresa de colectivos. La aplicación debe gestionar la información de rutas, horarios, pasajeros y ventas de pasajes. La aplicación debe interactuar con una base de datos para almacenar y recuperar la información de manera eficiente.
<br><br>

## Requisitos del Sistema:

### Gestión de Rutas:

- Los usuarios deben poder añadir nuevas rutas a la base de datos, especificando el
  origen y destino de cada ruta.

- Los usuarios deben poder visualizar la lista de rutas disponibles.

- Los usuarios deben poder buscar rutas por origen o destino.
  <br><br>

### Gestión de Horarios:

- Los usuarios deben poder añadir horarios a las rutas, especificando la hora de salida y llegada.

- Los usuarios deben poder visualizar los horarios disponibles para una ruta específica.

- Los usuarios deben poder buscar horarios por ruta u horario de salida.

### Gestión de Pasajeros:

- Los usuarios deben poder registrar nuevos pasajeros en la base de datos.

- Los usuarios deben poder visualizar la lista de pasajeros.

- Los usuarios deben poder buscar pasajeros por nombre y/o apellido o documento de identidad.

### Gestión de Ventas de Pasajes:

- Los usuarios deben poder registrar la venta de un pasaje, especificando la ruta, el horario y el pasajero.

- Los usuarios deben poder visualizar el historial de ventas de pasajes, con posibilidad de filtrado por ruta, horario o pasajero.

- Los usuarios deben poder emitir un recibo de la venta de un pasaje o anular dicha venta.

## Requisitos Técnicos:

### Interfaz de Usuario:

La aplicación debe tener una interfaz gráfica de usuario (GUI) sencilla y fácil de usar, creada con Swing.

### Persistencia de Datos:

<div style="margin-left: 40px;">
La aplicación debe utilizar JDBC para interactuar con una base de datos MySQL.

Las tablas de la base de datos deben ser creadas según el siguiente esquema:

</div>
<br>

1\. **Tabla: Pasajeros (Pasajero)**

Esta tabla almacena la información personal de los pasajeros.

|                       |                                                             |
| --------------------- | ----------------------------------------------------------- |
| ID_Pasajero (INT, PK) | Identificador único del pasajero.                           |
| Nombre (VARCHAR)      | Nombre del pasajero.                                        |
| Apellido (VARCHAR)    | Apellido del pasajero.                                      |
| DNI (VARCHAR)         | Documento Nacional de Identidad del pasajero que sea único. |
| Correo (VARCHAR)      | Correo electrónico del pasajero que sea único.              |
| Teléfono (VARCHAR)    | Número de teléfono del pasajero.                            |
| Estado(BOOLEAN)       | Indica si la entidad está activa o dada de baja.            |

---

<br><br>

2\. **Tabla: Pasajes (Pasaje)**

Esta tabla registra la información de los pasajes vendidos.

|                        |                                                  |
| ---------------------- | ------------------------------------------------ |
| ID_Pasaje (INT, PK)    | Identificador único del pasaje.                  |
| ID_Pasajero (INT, FK)  | Identificador del pasajero que compró el pasaje. |
| ID_Colectivo (INT, FK) | Identificador del colectivo asignado.            |
| ID_Ruta (INT, FK)      | Identificador de la ruta correspondiente.        |
| Fecha_Viaje (DATE)     | Fecha del viaje.                                 |
| Hora_Viaje (TIME)      | Hora del viaje.                                  |
| Asiento (INT)          | Número de asiento asignado.                      |
| Precio (DECIMAL)       | Precio del pasaje.                               |

---

<br><br>

3\. **Tabla: Colectivos (Colectivo)**

Esta tabla contiene información sobre los colectivos utilizados por la empresa.
| | |
| ------------------------- | ------------------------------------------------ |
| ID_Colectivo (INT, PK) | Identificador único del colectivo. |
| Matrícula (VARCHAR) | Matrícula del colectivo. |
| Marca (VARCHAR) | Marca del colectivo. |
| Modelo (VARCHAR) | Modelo del colectivo. |
| Capacidad (INT) | Capacidad total de pasajeros del colectivo. |
| Estado(BOOLEAN) | Indica si la entidad está activa o dada de baja. |

---

<br><br>

4\. **Tabla: Rutas (Ruta)**

Esta tabla almacena información sobre las rutas de los viajes.
| | |
| ---------------------------- | ------------------------------------------------ |
| ID_Ruta (INT, PK) | Identificador único de la ruta. |
| Origen (VARCHAR) | Ciudad o lugar de origen. |
| Destino (VARCHAR) | Ciudad o lugar de destino. |
| Duración_Estimada (TIME) | Duración estimada del viaje. |
| Estado(BOOLEAN) | Indica si la entidad está activa o dada de baja.|

---

<br><br>

5\. **Tabla: Horarios (Horario)**
Esta tabla define los horarios disponibles para las rutas.
| | |
| ---------------------------- | ------------------------------------------------ |
| ID_Horario (INT, PK) | Identificador único del horario. |
| ID_Ruta (INT, FK) | Identificador de la ruta correspondiente. |
| Hora_Salida (TIME) | Hora de salida del colectivo. |
| Hora_Llegada (TIME) | Hora estimada de llegada. |
| Estado(BOOLEAN) | Indica si la entidad está activa o dada de baja. |

---

### Relaciones entre tablas

- Pasajeros y Pasajes: Un pasajero puede tener múltiples pasajes, pero un pasaje está asociado a un solo pasajero.

- Pasajes y Colectivos: Un pasaje está asociado a un colectivo específico.

- Pasajes y Rutas: Un pasaje corresponde a una ruta específica.

- Rutas y Horarios: Una ruta puede tener múltiples horarios.

### Operaciones CRUD:

La aplicación debe implementar las operaciones CRUD (Crear, Leer, Actualizar, Eliminar) para todas las entidades (Rutas, Horarios, Pasajeros, Ventas).

### Validación de Datos:

La aplicación debe incluir validaciones adecuadas para todos los campos de entrada (por ejemplo, formatos de texto, longitud, datos requeridos). **Asegurarse de que no se vendan más pasajes para una ruta específica, en un colectivo determinado y en un horario dado, que la capacidad máxima permitida del mismo.**

### Manejo de Errores:

La aplicación debe manejar errores de manera adecuada, mostrando mensajes de error informativos al usuario en caso de problemas (como intentos de ingresar datos duplicados, campos vacíos obligatorios, etc.).

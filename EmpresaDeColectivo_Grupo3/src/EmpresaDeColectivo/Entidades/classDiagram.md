```mermaid
classDiagram
    class Colectivo {
        -int idColectivo
        -String matricula
        -String marca
        -String modelo
        -int capacidad
        -boolean estado
        +Colectivo()
        +Colectivo(String matricula, String marca, String modelo, int capacidad, boolean estado)
    }

    class Horario {
        -int idHorario
        -int idRuta
        -LocalTime horaSalida
        -LocalTime horaLlegada
        -boolean estado
        +Horario()
        +Horario(int idRuta, LocalTime horaSalida, LocalTime horaLlegada, boolean estado)
        +Horario(int idRuta, LocalTime horaSalida, LocalTime horaLlegada)
    }

    class Pasaje {
        -int idPasaje
        -int idPasajero
        -int idColectivo
        -int idRuta
        -LocalDate fechaViaje
        -LocalTime horaViaje
        -int asiento
        -double precio
        +Pasaje()
        +Pasaje(int idPasajero, int idColectivo, int idRuta, LocalDate fechaViaje, LocalTime horaViaje, int asiento, double precio)
    }

    class Pasajero {
        -int idPasajero
        -String nombre
        -String apellido
        -String dni
        -String correo
        -String telefono
        -boolean estado
        +Pasajero()
        +Pasajero(String nombre, String apellido, String dni, String correo, String telefono)
    }

    class Ruta {
        -int idRuta
        -String origen
        -String destino
        -Duration duracionEstimada
        -boolean estado
        +Ruta()
        +Ruta(String origen, String destino, Duration duracionEstimada, boolean estado)
        +Ruta(String origen, String destino, Duration duracionEstimada)
    }
```

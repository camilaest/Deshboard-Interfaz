package co.edu.uniquindio.fx10.modelo;
import co.edu.uniquindio.fx10.modelo.Apartamento;

public class PropiedadFactory {

    public static Propiedad crearPropiedad(String tipo){
        switch (tipo.toLowerCase()) {
            case "apartamento":
                return new co.edu.uniquindio.fx10.modelo.Apartamento.Builder()
                        .ciudad("Armenia")
                        .nHabitaciones(2)
                        .nPisos(8)
                        .piscina(true)
                        .direccion("Carrera 12 Calle 18-42 ")
                        .build();

            case "local":
                return new co.edu.uniquindio.fx10.modelo.Local.Builder()
                        .ciudad("Cartagena")
                        .nHabitaciones(4)
                        .nPisos(7)
                        .direccion("Carrera 17 Calle 31-11")
                        .build();

            case "finca":
                return new Finca.Builder()
                        .ciudad("Medellin")
                        .nHabitaciones(4)
                        .nPisos(7)
                        .direccion("Carrera 19 Calle 15-34")
                        .build();
            case "casa":
                return new Casa.Builder()
                            .ciudad("Carrera ")
                            .nHabitaciones(3)
                            .nPisos(2)
                            .direccion("3f")  //lo encontré, Builder dirección era privado
                            .build();

            default:
                throw new IllegalArgumentException("Tipo de propiedad no válido: " + tipo);
        }
    }

}

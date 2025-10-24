package co.edu.uniquindio.fx10.ViewController;

import java.util.ArrayList;
import co.edu.uniquindio.fx10.modelo.*;

public class PropiedadRepository {

    private static PropiedadRepository instance;
    private final ArrayList<Propiedad> listaPropiedades;
    private final DataBase db = DataBase.getInstance();

    private PropiedadRepository() {
        listaPropiedades = new ArrayList<>();
        cargarDatosEjemplo();
    }


    public static PropiedadRepository getInstance() {
        if (instance == null) {
            instance = new PropiedadRepository();
        }
        return instance;
    }


    private void cargarDatosEjemplo() {
        listaPropiedades.add(new Propiedad("Bogota", 5, 6, 5000, "2e"));
        listaPropiedades.add(new Propiedad("Vienna", 2, 1, 40000, "3r"));
        listaPropiedades.add(new Propiedad("Cartagena", 3, 4, 20000, "4t"));
    }


    public ArrayList<Propiedad> getPropiedades() {
        return listaPropiedades;
    }

    public void agregarPropiedad(Propiedad propiedad) {
        listaPropiedades.add(propiedad);
    }

    public boolean eliminarPropiedad(Propiedad propiedad) {
        return listaPropiedades.remove(propiedad);
    }

    public Propiedad buscarPorDireccion(String codigo) {
        return listaPropiedades.stream()
                .filter(p -> p.getDireccion().equalsIgnoreCase(codigo))
                .findFirst()
                .orElse(null);
    }

    public int getCantidadPropiedades() {
        return listaPropiedades.size();
    }

    public void mostrarFormularioProducto(){

    }
}
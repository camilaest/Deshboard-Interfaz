package co.edu.uniquindio.fx10.ViewController;


import co.edu.uniquindio.fx10.modelo.Producto;
import co.edu.uniquindio.fx10.modelo.Propiedad;

import java.util.ArrayList;


public class ViewController {

    org.uniquindio.edu.co.poo.model.DataBase db = org.uniquindio.edu.co.poo.model.DataBase.getInstance();
    private static ViewController instancia;
    private ArrayList<listaPropiedades> productos;

    private ViewController() {
        productos = new ArrayList<>();
        cargarDatosEjemplo();
    }




    private void cargarDatosEjemplo() {
        productos.add(new Producto("P001", "Laptop Dell", "Laptop Dell Inspiron 15", 1200.00, 10));
        productos.add(new Producto("P002", "Mouse Logitech", "Mouse inalámbrico Logitech MX Master", 89.99, 25));
        productos.add(new Producto("P003", "Teclado Mecánico", "Teclado mecánico RGB", 150.00, 15));
    }


    public ArrayList<Propiedad> getProductos() {
        return listaPropiedades;
    }


    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }


    public boolean eliminarProducto(Producto producto) {
        return productos.remove(producto);
    }


    public Producto buscarPorCodigo(String codigo) {
        return productos.stream()
                .filter(p -> p.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);
    }


    public int getCantidadProductos() {
        return productos.size();
    }
}


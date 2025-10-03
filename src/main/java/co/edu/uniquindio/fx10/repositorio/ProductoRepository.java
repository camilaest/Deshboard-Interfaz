package co.edu.uniquindio.fx10.repositorio;

import co.edu.uniquindio.fx10.modelo.Producto;
import java.util.ArrayList;
import java.util.List;


public class ProductoRepository {
    private static ProductoRepository instancia;
    private ArrayList<Producto> productos;

    private ProductoRepository() {
        productos = new ArrayList<>();
        cargarDatosEjemplo();
    }


    public static ProductoRepository getInstancia() {
        if (instancia == null) {
            instancia = new ProductoRepository();
        }
        return instancia;
    }


    private void cargarDatosEjemplo() {
        productos.add(new Producto("P001", "Laptop Dell", "Laptop Dell Inspiron 15", 1200.00, 10));
        productos.add(new Producto("P002", "Mouse Logitech", "Mouse inalámbrico Logitech MX Master", 89.99, 25));
        productos.add(new Producto("P003", "Teclado Mecánico", "Teclado mecánico RGB", 150.00, 15));
    }


    public ArrayList<Producto> getProductos() {
        return productos;
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


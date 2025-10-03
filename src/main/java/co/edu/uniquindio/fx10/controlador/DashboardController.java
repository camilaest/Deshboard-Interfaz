package co.edu.uniquindio.fx10.controlador;

import co.edu.uniquindio.fx10.App;
import co.edu.uniquindio.fx10.modelo.Producto;
import co.edu.uniquindio.fx10.repositorio.ProductoRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.io.IOException;

/**
 * Controlador para el Dashboard principal
 */
public class DashboardController {

    @FXML
    private VBox contenedorDinamico;

    @FXML
    private void mostrarFormularioProducto() {
        cargarVista("/co/edu/uniquindio/fx10/vista/FormularioProducto.fxml");
    }

    @FXML
    private void mostrarListaProductos() {
        cargarVista("/co/edu/uniquindio/fx10/vista/ListaProductos.fxml");
    }

    public void volverAlDashboard() {
        try {

            contenedorDinamico.getChildren().clear();

            Button btnFormulario = new Button("Formulario Producto");
            btnFormulario.setStyle("-fx-background-color: #3498db; -fx-text-fill: white; -fx-font-size: 16px; -fx-padding: 12 30; -fx-background-radius: 8;");
            btnFormulario.setOnAction(e -> mostrarFormularioProducto());

            Button btnLista = new Button("Lista de Productos");
            btnLista.setStyle("-fx-background-color: #2ecc71; -fx-text-fill: white; -fx-font-size: 16px; -fx-padding: 12 30; -fx-background-radius: 8;");
            btnLista.setOnAction(e -> mostrarListaProductos());

            contenedorDinamico.getChildren().addAll(btnFormulario, btnLista);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cargarVista(String ruta) {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource(ruta));
            Parent vista = loader.load();


            Object controller = loader.getController();
            if (controller instanceof FormularioProductoController formCtrl) {
                formCtrl.setDashboardController(this);
            } else if (controller instanceof ListaProductosController listaCtrl) {
                listaCtrl.setDashboardController(this);
            }

            contenedorDinamico.getChildren().setAll(vista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package co.edu.uniquindio.fx10.controlador;

import co.edu.uniquindio.fx10.modelo.Propiedad;
import co.edu.uniquindio.fx10.ViewController.PropiedadRepository;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 * Controlador para la vista de lista de propiedades
 */
public class ListaPropiedadesController {

    @FXML
    private TableView<Propiedad> tablaPropiedades;

    @FXML
    private TableColumn<Propiedad, String> colciudad;

    @FXML
    private TableColumn<Propiedad, String> coldireccion;


    @FXML
    private TableColumn<Propiedad, Integer> colnhabitaciones;

    @FXML
    private TableColumn<Propiedad, Integer> colnpisos;


    @FXML
    private TableColumn<Propiedad, Double> colprecio;

    private DashboardController dashboardController;

    @FXML
    public void initialize() {

        // Configuración de columnas comentario
        colciudad.setCellValueFactory(new PropertyValueFactory<>("ciudad"));
        colnhabitaciones.setCellValueFactory(new PropertyValueFactory<>("nhabitaciones"));
        colnpisos.setCellValueFactory(new PropertyValueFactory<>("npisos"));
        colprecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        coldireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));

        // Cargar datos desde el repositorio
        tablaPropiedades.setItems(FXCollections.observableArrayList(
                PropiedadRepository.getInstance().getPropiedades()
        ));
    }


    /**
     * Enlaza el DashboardController para permitir navegación
     */

    public void setDashboardController(DashboardController dashboardController) {
        this.dashboardController = dashboardController;
    }

    /**
     * Acción para volver al Dashboard
     */

//holaa
    //heeey
    @FXML
    private void onVolver() {
        if (dashboardController != null) {
            dashboardController.volverAlDashboard();
        }

    }

    @FXML
    private void onEliminarPropiedad() {
        Propiedad seleccionada = tablaPropiedades.getSelectionModel().getSelectedItem();

        if (seleccionada != null) {
            // Confirmación opcional
            Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacion.setTitle("Confirmar eliminación");
            confirmacion.setHeaderText("¿Deseas eliminar esta propiedad?");
            confirmacion.setContentText("Ciudad: " + seleccionada.getCiudad());

            confirmacion.showAndWait().ifPresent(respuesta -> {
                if (respuesta == ButtonType.OK) {
                    // Eliminar de la tabla
                    tablaPropiedades.getItems().remove(seleccionada);

                    // Eliminar del repositorio
                    PropiedadRepository.getInstance().eliminarPropiedad(seleccionada);
                }
            });
        } else {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Sin selección");
            alerta.setHeaderText("No se ha seleccionado ninguna propiedad");
            alerta.setContentText("Selecciona una propiedad para eliminar.");
            alerta.showAndWait();
        }
    }


}
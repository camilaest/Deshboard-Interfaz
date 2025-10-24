package co.edu.uniquindio.fx10.controlador;

import co.edu.uniquindio.fx10.modelo.Propiedad;
import co.edu.uniquindio.fx10.ViewController.PropiedadRepository;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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


    @FXML
    private void onVolver() {
        if (dashboardController != null) {
            dashboardController.volverAlDashboard();
        }

    }


}
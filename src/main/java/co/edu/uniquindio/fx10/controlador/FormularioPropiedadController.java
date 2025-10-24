package co.edu.uniquindio.fx10.controlador;

import co.edu.uniquindio.fx10.modelo.Propiedad;
import co.edu.uniquindio.fx10.ViewController.PropiedadRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * Controlador para el formulario de creación de propiedades
 */
public class FormularioPropiedadController {


    @FXML
    private TextField txtciudad;

    @FXML
    private TextField txtnhabitaciones;

    @FXML
    private TextField txtnpisos;

    @FXML
    private TextField txtprecio;

    @FXML
    private TextField txtdireccion;

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnCancelar;

    private PropiedadRepository propiedadRepository;
    private DashboardController dashboardController;
    private VBox contenedorPrincipal;

    @FXML
    public void initialize() {
        propiedadRepository = PropiedadRepository.getInstance();
    }

    public void setDashboardController(DashboardController dashboardController) {
        this.dashboardController = dashboardController;
    }

    /**
     * Guarda una nueva propiedad validando los campos
     */
    @FXML
    private void onGuardarPropiedad() {
        if (!validarCampos()) return;

        try {
            String ciudad = txtciudad.getText().trim();
            int nHabitaciones = Integer.parseInt(txtnhabitaciones.getText());
            int nPisos = Integer.parseInt(txtnpisos.getText().trim());
            double precio = Double.parseDouble(txtprecio.getText().trim());
            String direccion = txtdireccion.getText().trim();



            // Crear y guardar la nueva propiedad
            Propiedad nuevaPropiedad = new Propiedad(ciudad,nHabitaciones,nPisos,precio,direccion);
            propiedadRepository.agregarPropiedad(nuevaPropiedad);

            mostrarAlerta("Éxito", "Propiedad registrada correctamente", Alert.AlertType.INFORMATION);
            volverAlDashboard();

        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "El precio debe ser un valor numérico válido", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void onCancelar() {
        volverAlDashboard();
    }

    private void volverAlDashboard() {
        if (dashboardController != null) {
            dashboardController.volverAlDashboard();
        }
    }

    /**
     * Valida que todos los campos tengan datos
     */
    private boolean validarCampos() {
        if (txtciudad.getText().trim().isEmpty()) {
            mostrarAlerta("Error de validación", "La ciudad es obligatorio", Alert.AlertType.WARNING);
            return false;
        }
        if (txtnpisos.getText().trim().isEmpty()) {
            mostrarAlerta("Error de validación", "Cantidad de pisos obligatoria", Alert.AlertType.WARNING);
            return false;
        }
        if (txtnhabitaciones.getText().trim().isEmpty()) {
            mostrarAlerta("Error de validación", "La cantidad de habitaciones es obligatoria", Alert.AlertType.WARNING);
            return false;
        }
        if (txtprecio.getText().trim().isEmpty()) {
            mostrarAlerta("Error de validación", "El precio es obligatorio", Alert.AlertType.WARNING);
            return false;
        }
        return true;
    }

    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }


}
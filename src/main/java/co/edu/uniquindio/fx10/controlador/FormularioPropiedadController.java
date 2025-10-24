package co.edu.uniquindio.fx10.controlador;

import co.edu.uniquindio.fx10.modelo.Propiedad;
import co.edu.uniquindio.fx10.modelo.PropiedadRepository;
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
    private TextField txtCodigo;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtDescripcion;

    @FXML
    private TextField txtPrecio;

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnCancelar;

    private PropiedadRepository propiedadRepository;
    private DashboardController dashboardController;
    private VBox contenedorPrincipal;

    @FXML
    public void initialize() {
        propiedadRepository = PropiedadRepository.getInstance(); // ✅ método Singleton
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
            String codigo = txtCodigo.getText().trim();
            String nombre = txtNombre.getText().trim();
            String descripcion = txtDescripcion.getText().trim();
            double precio = Double.parseDouble(txtPrecio.getText().trim());

            // Verificar si el código ya existe
            if (propiedadRepository.buscarPorCodigo(codigo) != null) {
                mostrarAlerta("Error", "Ya existe una propiedad con ese código", Alert.AlertType.ERROR);
                return;
            }

            // Crear y guardar la nueva propiedad
            Propiedad nuevaPropiedad = new Propiedad(codigo, nombre, descripcion, precio);
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
        if (txtCodigo.getText().trim().isEmpty()) {
            mostrarAlerta("Error de validación", "El código es obligatorio", Alert.AlertType.WARNING);
            return false;
        }
        if (txtNombre.getText().trim().isEmpty()) {
            mostrarAlerta("Error de validación", "El nombre es obligatorio", Alert.AlertType.WARNING);
            return false;
        }
        if (txtDescripcion.getText().trim().isEmpty()) {
            mostrarAlerta("Error de validación", "La descripción es obligatoria", Alert.AlertType.WARNING);
            return false;
        }
        if (txtPrecio.getText().trim().isEmpty()) {
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
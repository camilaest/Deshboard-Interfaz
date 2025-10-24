package co.edu.uniquindio.fx10.controlador;

import co.edu.uniquindio.fx10.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import java.io.IOException;

/**
 * Controlador para el Dashboard principal de propiedades
 */
public class DashboardController {

    @FXML
    private VBox contenedorDinamico;



    /**
     * Restaura el dashboard principal con los botones iniciales
     */
    public void volverAlDashboard() {
        try {
            contenedorDinamico.getChildren().clear();

            Button btnFormulario = new Button("Formulario Propiedad");
            btnFormulario.setStyle(
                    "-fx-background-color: #3498db; -fx-text-fill: white; " +
                            "-fx-font-size: 16px; -fx-padding: 12 30; -fx-background-radius: 8;"
            );
            btnFormulario.setOnAction(e -> mostrarFormularioProducto());

            Button btnLista = new Button("Lista de Propiedades");
            btnLista.setStyle(
                    "-fx-background-color: #2ecc71; -fx-text-fill: white; " +
                            "-fx-font-size: 16px; -fx-padding: 12 30; -fx-background-radius: 8;"
            );
            btnLista.setOnAction(e -> mostrarListaProductos());

            contenedorDinamico.getChildren().addAll(btnFormulario, btnLista);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Carga una vista FXML y asocia su controlador al dashboard
     */



    @FXML
    public void mostrarListaProductos() {
        cargarVista("/co/edu/uniquindio/fx10/vista/ListaProductos.fxml");
    }
    @FXML
    public void mostrarFormularioProducto() {
        cargarVista("/co/edu/uniquindio/fx10/vista/FormularioProducto.fxml");
    //camila are you there? siisisisi no te deja correr?
    } //exacto, no me deja correr el codigo, asi que no puedo mirar si hay algun error de lógica o algo, por lo que parece ya no hay
      //errores de syntaxis, ahora nos enfrentamos a los errores "invisibles"....Hp no he comido y son casi las 8, me tengo que ir corriendo
    // nos vemos en 40 minutos si a caso, perdon ahi el fallo temporal


    private void cargarVista(String ruta) {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource(ruta));
            Parent vista = loader.load();


            Object controller = loader.getController();
            if (controller instanceof FormularioPropiedadController formCtrl) {
                formCtrl.setDashboardController(this);
            } else if (controller instanceof ListaPropiedadesController listaCtrl) {
                listaCtrl.setDashboardController(this);
            }

            contenedorDinamico.getChildren().setAll(vista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package cl.duoc.vivero.controlador.Controlador;

import cl.duoc.vivero.model.Planta;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;


public class Vivero {
    //datos para comboBox
    private static final String INTERIOR = "Interior";
    private static final String EXTERIOR = "Exterior";

    private static final String CLASE_ERROR = "campo_error";

    // Datos en común
    @FXML private CheckBox filtroPlantaExterior;
    @FXML private CheckBox filtroPlantaInterior;
    @FXML private VBox vBoxComun;
    @FXML private ComboBox <String> tipoPlanta;
    @FXML private TextField nombrePlanta;
    @FXML private TextField alturaPlanta;
    @FXML private TextField cantidad;


    //Datos Tabla
    @FXML private TableView<Planta> tablaPlantas;
    @FXML private TableColumn<Planta, String> tipoMostrado;
    @FXML private TableColumn<Planta,String> nombreMostrado;
    @FXML private TableColumn<Planta,String> AlturaMostrada;
    @FXML private TableColumn<Planta,String> cantidadMostrada;
    @FXML private TableColumn<Planta,String> precioMostrado;

    // Especiales
    @FXML private Button registroPlanta;
    @FXML private Button eliminarPlanta;
    @FXML private Label mensajeUsuario;

    //Dato planta Interior
    @FXML private VBox vBoxInterior;
    @FXML private TextField volumenPlantaInterior;

    // Dato planta Exterior
    @FXML private CheckBox heladas;
    @FXML private CheckBox despacho;
    @FXML private VBox vBoxExterior;




    public void mostrarTipo(ActionEvent event) {
    }

    public void registrodePlanta(ActionEvent event) {
    }

    public void eliminarP(ActionEvent event) {
    }

    public void heladasPlanta(ActionEvent event) {
    }

    public void despachoPlanta(ActionEvent event) {
    }

    public void filtroInterior(ActionEvent event) {
        if (filtroPlantaInterior.isSelected() && !filtroPlantaExterior.isSelected()) {
            vBoxInterior.setVisible(true);
            filtroPlantaExterior.setVisible(false);


        }

        if (!filtroPlantaInterior.isSelected()){
            vBoxInterior.setVisible(false);
            filtroPlantaExterior.setVisible(true);
        }

    }

    public void filtroExterior(ActionEvent event) {
        if (filtroPlantaExterior.isSelected() && !filtroPlantaInterior.isSelected()) {
            vBoxExterior.setVisible(true);
            filtroPlantaInterior.setVisible(false);

        }

        if   (!filtroPlantaExterior.isSelected()) {
            vBoxExterior.setVisible(false);
            filtroPlantaInterior.setVisible(true);


        }
    }
}

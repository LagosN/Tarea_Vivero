package cl.duoc.vivero.controller;

import cl.duoc.vivero.model.Planta;
import cl.duoc.vivero.repository.PlantaRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
//import javafx.scene.control.label;
import javafx.scene.layout.VBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;



public class MainController {
    //datos para comboBox
    private static final String INTERIOR = "Interior";
    private static final String EXTERIOR = "Exterior";

    private static final String CLASE_ERROR = "campo_error";

    @FXML private Label mensajeUsuario;

    @FXML private  Button limpiar;


    // Datos en común

    @FXML private ChoiceBox <String> tipoPlanta;
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
    @FXML private TableColumn heladaTabla;
    @FXML private TableColumn volumenTabla;

    // Especiales
    @FXML private Button registroPlanta;
    @FXML private Button eliminarPlanta;
    @FXML private CheckBox filtroPlantaExterior;
    @FXML private CheckBox filtroPlantaInterior;


    //Dato planta Interior
    @FXML private VBox vBoxInterior;
    @FXML private TextField volumenPlantaInterior;

    // Dato planta Exterior
    @FXML private CheckBox heladas;
    @FXML private CheckBox despacho;
    @FXML private VBox vBoxExterior;

    // Datos internos del controllador
    private final PlantaRepository repository = new PlantaRepository();
    private ObservableList<Planta> plantas = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        tipoPlanta.getItems().addAll(INTERIOR, EXTERIOR);
        this.repository.cargar();
        //TODO: Refactorizar
        plantas.setAll(this.repository.getList());
    }

    @FXML
    public void onGuardar(){}
    @FXML
    public void onLimpiar(){
        this.tipoPlanta.setValue("");
        this.nombrePlanta.setText("");
        this.alturaPlanta.setText("");
        this.cantidad.setText("");
    }
    @FXML

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
        if (tipoPlanta.getItems().contains(INTERIOR)) {
            vBoxInterior.setVisible(true);
            filtroPlantaExterior.setVisible(false);
            volumenTabla.setVisible(true);

        }

        if (!filtroPlantaInterior.isSelected()){
            vBoxInterior.setVisible(false);
            filtroPlantaExterior.setVisible(true);
            volumenTabla.setVisible(false);

        }

    }

    public void filtroExterior(ActionEvent event) {
        if (tipoPlanta.getItems().contains(EXTERIOR)) {

            vBoxExterior.setVisible(true);
            filtroPlantaInterior.setVisible(false);
            heladaTabla.setVisible(true);

        }



        if   (!filtroPlantaExterior.isSelected()) {
            vBoxExterior.setVisible(false);
            filtroPlantaInterior.setVisible(true);
            heladaTabla.setVisible(false);


        }
    }

    public void limpiar(ActionEvent event) {
    }
}

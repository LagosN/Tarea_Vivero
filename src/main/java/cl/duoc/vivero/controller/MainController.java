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
import javafx.scene.paint.Color;


public class MainController {
    //datos para comboBox
    private static final String INTERIOR = "Interior";
    private static final String EXTERIOR = "Exterior";

    // CONSTANTE PARA ALERTLABEL
    public final static String ALERTA_EXITO = "Registro exitoso";
    public final static String ALERTA_NO_VALIDO = "Dato no valido";
    public final static String ALERTA_ELIMINADO = "Registro eliminado";
    public final static String ALERTA_NO_SELECCIONADO = "Falta seleccion";
    public final static String ALERTA_LECTURA = "Error al leer archivo";
    public final static String ALERTA_ESCRITURA = "Error al escribir archivo";
    public final static String ALERTA_DEFAULT = "Sin Alerta";


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
    @FXML private Label mensajeUsuario;
    @FXML private  Button limpiar;
    @FXML private Button registroPlanta;
    @FXML private Button eliminarPlanta;



    //Dato planta Interior
    @FXML private VBox vBoxInterior;
    @FXML private TextField volumenPlantaInterior;

    // Dato planta Exterior
    @FXML private CheckBox heladas;
    @FXML private CheckBox despacho;
    @FXML private TextField especieText;
    @FXML private VBox vBoxExterior;

    // Datos internos del controllador
    private final PlantaRepository repository = new PlantaRepository();
    private ObservableList<Planta> plantas = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        this.tipoPlanta.getItems().addAll(INTERIOR, EXTERIOR);
        // Otra forma de agregar
        //this.tipoPlanta.getItems().add(INTERIOR)
        //this.tipoPlanta.getItems().add(EXTERIOR)
        this.mensajeUsuario.setVisible(false);
        // Campos interiores
        this.volumenPlantaInterior.setDisable(true);
        // Campos exteriores
        this.especieText.setDisable(true);
        this.heladas.setSelected(false);
        this.despacho.setSelected(false);
        this.repository.cargar();
        //TODO: Refactorizar
        plantas.setAll(this.repository.getList());
    }

    public void tipoPanta(ActionEvent actionEvent) {}



    @FXML public void limpiar(){
        this.tipoPlanta.setValue("");
        this.nombrePlanta.setText("");
        this.alturaPlanta.setText("");
        this.cantidad.setText("");
        this.setAlertaLabelMensaje(ALERTA_DEFAULT, "");
        // Campos interiores
        this.volumenPlantaInterior.setDisable(true);
        // Campos exteriores
        this.especieText.setDisable(false);
        this.heladas.setSelected(false);
        this.despacho.setSelected(false);



    }
    @FXML public void OnSeleccionarTipo() {
        String tipo = this.tipoPlanta.getValue();
        switch (tipo) {
            //Por que no es Interior String ( es INTERIOR)
            case INTERIOR:
                this.volumenPlantaInterior.setDisable(false);
                // Campos exteriores
                this.especieText.setDisable(true);
                this.heladas.setSelected(false);
                this.despacho.setSelected(false);
                break;
            case EXTERIOR:
                // Campos interiores
                this.volumenPlantaInterior.setDisable(true);
                // Campos exteriores
                this.especieText.setDisable(false);
                this.heladas.setSelected(false);
                this.despacho.setSelected(false);

                break;
            default:
                // Campos interiores
                this.volumenPlantaInterior.setDisable(true);
                // Campos exteriores
                this.especieText.setDisable(true);
                this.heladas.setSelected(false);
                this.despacho.setSelected(false);
                this.setAlertaLabelMensaje(ALERTA_NO_SELECCIONADO, "Campo Seleccionar Tipo:");


                //

        }
    }
    @FXML public void registrodePlanta() {
        // se crea variable para almacenamiento
        Planta planta;
        try {
            //Se asignan las variables de los controladores generales
            String nombre = this.nombrePlanta.getText();
            String altura = this.alturaPlanta.getText();
            String cantidad = this.cantidad.getText();
            String tipo = this.tipoPlanta.getValue();

        }catch (IllegalArgumentException e){
            this.setAlertaLabelMensaje(ALERTA_NO_VALIDO, e.getMessage());

        }



    }
    private void setAlertaLabelMensaje( String tipo,String mensaje){
        if (mensaje.trim().isBlank()){
            mensaje = tipo;
        }else{
            mensaje = tipo + " " + mensaje;
        }
        switch (tipo){
            case ALERTA_EXITO:
            case ALERTA_ELIMINADO:
                this.mensajeUsuario.setVisible(true);
                this.mensajeUsuario.setTextFill(Color.GREEN);

                break;

            case ALERTA_ESCRITURA:
            case ALERTA_NO_SELECCIONADO:
            case ALERTA_LECTURA:
            case ALERTA_NO_VALIDO:
                this.mensajeUsuario.setVisible(true);
                this.mensajeUsuario.setTextFill(Color.RED);

                break;
            default:
                this.mensajeUsuario.setVisible(false);



        }
        this.mensajeUsuario.setText(mensaje);

    }
    @FXML

    public void mostrarTipo(ActionEvent event) {
    }



    public void eliminarP(ActionEvent event) {
    }

    public void heladasPlanta(ActionEvent event) {
    }

    public void despachoPlanta(ActionEvent event) {
    }




}


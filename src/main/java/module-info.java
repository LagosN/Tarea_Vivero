module vivero {
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.controls;

    opens cl.duoc.vivero to javafx.fxml;
    exports cl.duoc.vivero;
    exports cl.duoc.vivero.model;
    //opens cl.duoc.vivero.model to javafx.fxml;
    opens cl.duoc.vivero.controlador.Controlador to javafx.fxml;

}
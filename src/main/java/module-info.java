module cl.duoc.vivero {
    requires javafx.fxml;
    requires com.google.gson;
    requires javafx.controls;
    requires javafx.graphics;

    opens cl.duoc.vivero.model to com.google.gson;
    opens cl.duoc.vivero to javafx.graphics;
    opens cl.duoc.vivero.controller to javafx.fxml;


    exports cl.duoc.vivero;

}
module cl.duoc.vivero {
    requires javafx.fxml;
    requires com.google.gson;
    requires javafx.controls;


    opens cl.duoc.vivero.model to com.google.gson;
    opens cl.duoc.vivero.controller to javafx.fxml;
    opens cl.duoc.vivero.repository to javafx.graphics;




}
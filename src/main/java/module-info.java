module innoteamMV {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;

    opens innoteamMV.model to javafx.base;
    exports innoteamMV.model;
    opens innoteamMV to javafx.fxml;
    exports innoteamMV;
    opens innoteamMV.controller to javafx.fxml;
    exports innoteamMV.controller;
}
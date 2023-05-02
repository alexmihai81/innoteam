module innoteamMV {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;

    exports innoteamMV.model;
    opens innoteamMV to javafx.fxml;
    exports innoteamMV;
    opens innoteamMV.controller to javafx.fxml;
    exports innoteamMV.controller;
    opens innoteamMV.service;
    exports innoteamMV.service;
    opens innoteamMV.model;
}
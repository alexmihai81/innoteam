module innoteamMV {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;

    exports innoteamMV.model;
    opens innoteamMV.model;
    opens innoteamMV;
    exports innoteamMV;
    opens innoteamMV.controller ;
    exports innoteamMV.controller;
    opens innoteamMV.service;
    exports innoteamMV.service;
    exports innoteamMV.repository;
    opens innoteamMV.repository;
}
module innoteamMV {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    
    exports innoteamMV;
    exports innoteamMV.model;
    exports innoteamMV.service;
    exports innoteamMV.controller;
    exports innoteamMV.repository;
    opens innoteamMV;
    opens innoteamMV.model;
    opens innoteamMV.controller ;
    opens innoteamMV.service;
    opens innoteamMV.repository;
}
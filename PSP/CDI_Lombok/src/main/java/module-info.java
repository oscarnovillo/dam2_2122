module javafx11 {
    //needed for JavaFX
    requires javafx.controls;
    requires javafx.fxml;
    requires org.yaml.snakeyaml;
    requires lombok;
    requires java.logging;

    requires javax.el;

    requires java.validation;

    requires jakarta.enterprise.cdi.api;
    requires jakarta.inject.api;

//    requires javaee.web.api;


    //requires javafx.swing;

    //needed for HTTP
   // requires unirest.java;

    //needed for JSON
//    requires gson;
//    requires java.sql;

    //needed for JavaFX
    opens gui;
    opens controllers;
    opens main;

    exports gui;
    exports config;
    exports config.modelo;
    exports controllers;
    exports dao;
    exports servicios;
}

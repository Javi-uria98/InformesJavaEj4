package com.javier.informes;

import com.javier.informes.logica.Logica;
import com.javier.informes.model.Empresa;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Principal extends Application {

    private ArrayList<Empresa> listaEmpresas;

    private void generarInfome() {

        Empresa empresa=new Empresa("Pescanova","Alimentación", 9);
        Logica.getInstance().addEmpresa(empresa);
        listaEmpresas= Logica.getInstance().getListaEmpresa();
        JRBeanCollectionDataSource jr = new JRBeanCollectionDataSource(listaEmpresas);
        Map<String, Object> parametros = new HashMap<>();

        try {
            JasperPrint print = JasperFillManager.fillReport(getClass().getResourceAsStream("/com/javier/informes/jasper/Empresas.jasper"), parametros, jr);
            JasperExportManager.exportReportToPdfFile(print, "informes/Empresas.pdf");
        } catch (JRException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        Button button = new Button();
        VBox vBox=new VBox();
        vBox.getChildren().addAll(button);
        Scene scene=new Scene(vBox);
        stage.setScene(scene);
        stage.show();
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                generarInfome();
            }
        });

    }

    public static void main(String[] args) {
        launch(args);
    }

}

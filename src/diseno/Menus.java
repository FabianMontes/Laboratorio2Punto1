/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diseno;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author fanat
 */
public class Menus extends Application {

    


    @Override
    public void start(Stage stage) throws Exception {
        DataBodega dataBodega= new DataBodega(stage);
        RoboMenu robomenu= new RoboMenu(dataBodega);
        
        Inicio inicio = new Inicio(dataBodega);
        inicio.show();
        robomenu.show();
        
    }
    
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
}

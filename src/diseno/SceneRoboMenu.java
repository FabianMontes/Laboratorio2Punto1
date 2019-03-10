/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diseno;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author fanat
 */
class SceneRoboMenu {
    private Stage stage;
    private Scene scene;
    
    private ArrayList<Button> buttonsMensa;
    private ArrayList<Button> buttonsFacturas;
    private ArrayList<Button> buttonsEstante;
    private ArrayList<Label> MensaNames;
    private ArrayList<Label> EstaNames;

    private GridPane grid;
    
    
    public SceneRoboMenu() {
        this.buttonsMensa = new ArrayList<>();
        this.buttonsFacturas = new ArrayList<>();
        this.MensaNames = new ArrayList<>();
        this.buttonsEstante = new ArrayList<>();
        this.EstaNames = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            MensaNames.add(new Label("Mensajero "+String.valueOf(i+1)));
            buttonsMensa.add(new Button("LiberarM"));
            buttonsFacturas.add(new Button("Factura"));
            buttonsEstante.add(new Button("LiberarE"));
            EstaNames.add(new Label("Estante " +String.valueOf(i+1)));
        }
        for (int i = 10; i < 20; i++) {
            buttonsEstante.add(new Button("LiberarE"));
            EstaNames.add(new Label("Estante " +String.valueOf(i+1)));
        }
        
        System.out.println(buttonsEstante.size());
        
        grid = new GridPane();
        
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        grid.setHgap(5.5);
        grid.setVgap(5.5);
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid.add(MensaNames.get(j+i*3), i, j*3+0);
                grid.add(buttonsMensa.get(j+i*3), i, j*3+1);
                grid.add(buttonsFacturas.get(j+i*3), i, j*3+2);
            }
        }
        grid.add(MensaNames.get(9), 3, 0);
        grid.add(buttonsMensa.get(9), 3, 1);
        grid.add(buttonsFacturas.get(9), 3, 2);
        for (int i = 0; i < 2; i++) {
            grid.add(EstaNames.get(i), 3, 4+i*2);
            grid.add(buttonsEstante.get(i), 3, 5+i*2);
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                grid.add(EstaNames.get(2+j+i*4), 4+i, j*2);
                grid.add(buttonsEstante.get(2+j+i*4), 4+i, j*2+1);
            }
        }
        
        stage = new Stage();
        scene= new Scene(grid, 600, 300, Color.AQUA);
        
    }

    public ArrayList<Button> getButtonsEstante() {
        return buttonsEstante;
    }

    public ArrayList<Button> getButtonsFacturas() {
        return buttonsFacturas;
    }

    public ArrayList<Button> getButtonsMensa() {
        return buttonsMensa;
    }
    
    
    
    public void show(){
        stage.setTitle("RobotsMenu");
        stage.setScene(scene);
        stage.show();
    }
    
    
    
}

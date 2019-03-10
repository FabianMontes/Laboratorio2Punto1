/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diseno;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author fanat
 */
public class SceneInicio {
    private Scene scene;
    
    private GridPane grid;
    private Text scenetitle;
    
    private Button client;
    private Button empleado;
    private VBox vbBtn;

    public SceneInicio() {
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        scenetitle = new Text("Inicio");
        grid.add(scenetitle, 0, 0, 2, 1);
        
        
        client= new Button("Cliente");
        empleado = new Button("Empleado");
        vbBtn = new VBox(10);
        vbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        vbBtn.getChildren().add(client);
        vbBtn.getChildren().add(empleado);
        grid.add(vbBtn, 1, 1,2,2);
        
        scene = new Scene(grid, 500, 500);
    }
    
    public void show(Stage stage) {
       stage.setTitle("Inicio");
       stage.setScene(scene);
       stage.show();
    }

    public Button getClient() {
        return client;
    }

    public Button getEmpleado() {
        return empleado;
    }

    
}

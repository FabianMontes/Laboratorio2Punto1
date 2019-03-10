/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diseno;

import diseno.Bodega.Factura;
import diseno.Bodega.Producto;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author fanat
 */
public class Inicio {
    private DataBodega databodega;
    
    private SceneInicio scene;
    
    public Inicio(DataBodega databodega) {
        this.databodega = databodega;
        this.scene = new SceneInicio();
        scene.getClient().setOnAction(new BtnClient());
        scene.getEmpleado().setOnAction(new BtnEmpleado());
    }
    
    public void show(){
      scene.show(databodega.getStage());
    }
    
    class BtnEmpleado implements EventHandler<ActionEvent>{
 
      @Override
      public void handle(ActionEvent e) {   
      // zur naechsten Seiten springen! 
          Empleados ausgabeVC = new Empleados(databodega);
          ausgabeVC.show(); 
      }
   }
    
    class BtnClient implements EventHandler<ActionEvent>{
 
      @Override
      public void handle(ActionEvent e) {   
      /*
          SalidaVC ausgabeVC = new SalidaVC(databodega);
          ausgabeVC.show();   */
        Cliente cliente = new Cliente(databodega);
        cliente.show();
      
      }
    }
}

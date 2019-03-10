/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diseno;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

/**
 *
 * @author fanat
 */
class RoboMenu {
    
    private DataBodega databodega;
    
    private SceneRoboMenu scene;

    public RoboMenu(DataBodega databodega) {
        this.databodega =databodega;
        scene = new SceneRoboMenu();
        for (int i = 0; i < 10; i++) {
            scene.getButtonsMensa().get(i).setOnAction(new LiberarMensa(i));
            scene.getButtonsEstante().get(i).setOnAction(new LiberarEstant(i));
            scene.getButtonsFacturas().get(i).setOnAction(new RecibirFactura(i));
        }
        
        for (int i = 10; i < 20; i++) {
            scene.getButtonsEstante().get(i).setOnAction(new LiberarEstant(i));
        }
    }
    
    public void show(){
        scene.show();
    }
    
    class LiberarMensa implements EventHandler<ActionEvent>{
 
        private int robot;

        public LiberarMensa(int robot) {
            this.robot = robot;
        }
        
        @Override
        public void handle(ActionEvent e) {   
            if(databodega.getBodega().getHilomensajeros().get(robot).getEstado().equals("Waiting")||databodega.getBodega().getHilomensajeros().get(robot).getEstado().equals("Entregando")){
                databodega.getBodega().getHilomensajeros().get(robot).ChangeEstado("Moving");
            }
        }
    }
    
    class LiberarEstant implements EventHandler<ActionEvent>{
        private int robot;

        public LiberarEstant(int robot) {
            this.robot = robot;
        }
        
        @Override
        public void handle(ActionEvent e) {   
            if(databodega.getBodega().getHiloestantes().get(robot).getEstado().equals("Waiting")){
                databodega.getBodega().getHiloestantes().get(robot).ChangeEstado("Moving");
            }
        }
    }
     class RecibirFactura implements EventHandler<ActionEvent>{
         private int robot;

        public RecibirFactura(int robot) {
            this.robot = robot;
        }
        
        @Override
        public void handle(ActionEvent e) {   
            if(!databodega.getBodega().getHilomensajeros().get(robot).getFactura().isEmpty()){
                databodega.getBodega().getHilomensajeros().get(robot).getFactura().get(0).show();
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Impresion De Factura");
                alert.setHeaderText("El robot "+ databodega.getBodega().getHilomensajeros().get(robot).getId() + " no tiene una Factura");
                alert.setContentText("A la Espera De Ordenes");
                alert.showAndWait();
            }
        }
     }
}

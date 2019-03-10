/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diseno;

import diseno.Bodega.Producto;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.TablePosition;

/**
 *
 * @author fanat
 */
public class Cliente {
    DataBodega dataBodega;
    SceneCliente scene;

    public Cliente(DataBodega dataBodega) {
        this.dataBodega = dataBodega;
        this.scene = new SceneCliente(dataBodega.getBodega().getProductos());
        scene.getCarBtn().setOnAction(new AddToCar());
        scene.getRegresar().setOnAction(new BtnRegresar());
        scene.getDeleteBtn().setOnAction(new OutOfCar());
        scene.getConfirmBtn().setOnAction(new CrearPedido());
    }
    
    public void show(){
        scene.show(dataBodega.getStage());
    }

    private class CrearPedido implements EventHandler<ActionEvent> {
        
        @Override
        public void handle(ActionEvent event) {
            if(scene.getIdName().getText().trim().length()<=0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("No se a realizado el pedido.");
                alert.setContentText("No hay Nombre del pedido");	
                alert.showAndWait();
            }else if(scene.getProductosPedidos().size()<0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("No se a realizado el pedido.");
                alert.setContentText("No hay productos.");	
                alert.showAndWait();
            }else{
                System.out.println("realizado");
                ArrayList<Producto> productos = new ArrayList<>();
                for (int i=0; i<scene.getProductosPedidos().size(); i++) {
                    productos.add(scene.getProductosPedidos().get(i));
                    System.out.println(productos.get(i).getName());
                }   
                scene.getProductosPedidos().clear();
                scene.getIdName().clear();
                dataBodega.getBodega().PedirProductos(productos, scene.getIdName().getText().trim());
            }
                
        }
    }

    private class AddToCar implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if(scene.getSelectedCar().size()>0){
                TablePosition tablePosition = (TablePosition) scene.getSelectedCar().get(0);
                int a=0;
                System.out.println(scene.getProductosBodega().get(tablePosition.getRow()).getName());
                for (int i = 0; i < dataBodega.getBodega().getProductos().size(); i++) {
                    if (dataBodega.getBodega().getProductos().get(i).getName().equals(scene.getProductosBodega().get(tablePosition.getRow()).getName())) {
                        a=i;
                        break;
                    }
                }
                System.out.println(a);
                Producto producto = dataBodega.getBodega().getProductos().remove(a);
                System.out.println(producto.getName());
                scene.getProductosPedidos().add(producto);
            }
        }
    }
    
    class OutOfCar implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            if(scene.getSelectedProduct().size()>0){
                TablePosition tablePosition = (TablePosition) scene.getSelectedProduct().get(0);
                Producto producto = scene.getProductosPedidos().remove(tablePosition.getRow());
                System.out.println(producto.getName());
                dataBodega.getBodega().getProductos().add(producto);
            }
        }
    }
    
    class BtnRegresar implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            Inicio inicio = new Inicio(dataBodega);
            inicio.show();
        }  
    }
    
}

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
public class Empleados {
    private DataBodega dataBodega;
    
    private SceneEmpleados scene;
    
    public Empleados(DataBodega dataBodega) {
        this.dataBodega = dataBodega;
        this.scene = new SceneEmpleados(dataBodega.getBodega().getFacturas(), dataBodega.getBodega().getPedidosCliente());
        for (int i = 0; i < 5; i++) {
            scene.getAddProduct().get(i).setOnAction(new BtnAdd(i+1));
            scene.getDeleteButton().get(i).setOnAction(new BtnDellete(i+1));
            scene.getPedirEstan().get(i).setOnAction(new BtnAddBodega(i+1));
            scene.getPedirMensa().get(i).setOnAction(new BtnPedirMensa(i));
            scene.getPedirProduc().get(i).setOnAction(new BtnGetProduc(i));
        }
        scene.getRegresar().setOnAction(new BtnRegresar());
      /*
        scene.getClient().setOnAction(new BtnClient());
        scene.getEmpleado().setOnAction(new BtnEmpleado());*/
    }
    
    public void show(){
      scene.show(dataBodega.getStage());
    }

    private class BtnGetProduc implements EventHandler<ActionEvent> {

        int cabina;

        public BtnGetProduc(int cabina) {
            this.cabina = cabina;
        }

        @Override
        public void handle(ActionEvent event) {
            if(scene.getSelectedCells2().get(cabina).size()>0){
                TablePosition tablePosition = (TablePosition) scene.getSelectedCells2().get(cabina).get(0);
                System.out.println("dafafsdf");
                System.out.println(tablePosition.getRow());
                dataBodega.getBodega().outProductos(cabina+1, tablePosition.getRow());
            }
            
        }
    }
    
    private class BtnPedirMensa implements EventHandler<ActionEvent> {

        int cabina;

        public BtnPedirMensa(int cabina) {
            this.cabina = cabina;
        }

        @Override
        public void handle(ActionEvent event) {
            if(scene.getSelectedCells3().get(cabina).size()>0){
                System.out.println("habia una vez");
                 System.out.println("tab "+ String.valueOf(cabina+1));
                TablePosition tablePosition = (TablePosition) scene.getSelectedCells3().get(cabina).get(0);
                System.out.println(tablePosition.getRow());
                dataBodega.getBodega().EnviarFactura(cabina+1, tablePosition.getRow());
            }
            
        }
    }
   
    class BtnAdd implements EventHandler<ActionEvent>{
        private int cabina;

        public BtnAdd(int cabina) {
            this.cabina = cabina;
        }

        @Override
        public void handle(ActionEvent e) {   
            int espacioRestante=dataBodega.getBodega().espacioEnBodega();
            for (int i = 1; i < 6; i++) {
                espacioRestante-=scene.getProductosCabina().get("Agregar "+i).size();
            }
            
            if(espacioRestante<=0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("No se ah agregado el producto a la lista.");
                alert.setContentText("No hay mas espacio en bodega.");	
                alert.showAndWait();
            }else if (scene.getpName().get(cabina-1).getText().trim().length()<=0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("No se ah agregado el producto a la lista.");
                alert.setContentText("No hay Nombre Del Producto");	
                alert.showAndWait();
            }else if(scene.getpPrice().get(cabina-1).getText().trim().length()<=0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("No se ah agregado el producto a la lista.");
                alert.setContentText("No hay Precio Del Producto");	
                alert.showAndWait();
            }else{
                try {
                    scene.getProductosCabina().get("Agregar "+cabina).add(new Producto(scene.getpName().get(cabina-1).getText().trim(),Integer.parseInt(scene.getpPrice().get(cabina-1).getText().trim()), 0, 0));
                } catch (NumberFormatException y) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Dialog");
                    alert.setHeaderText("No se ah agregado el producto a la lista.");
                    alert.setContentText("El precio del producto no es numerico");	
                    alert.showAndWait();
                }
                
            }
            
            
        }
    }
    
    class BtnAddBodega implements EventHandler<ActionEvent>{
        private int cabina;

        public BtnAddBodega(int cabina) {
            this.cabina = cabina;
        }

        @Override
        public void handle(ActionEvent e) {   
            ArrayList<Producto> productos = new ArrayList<>();
            for (Producto get : scene.getProductosCabina().get("Agregar "+cabina)) {
                productos.add(get);
            }
            
            scene.getProductosCabina().get("Agregar "+cabina).clear();

            dataBodega.getBodega().AgregarProductos(productos, cabina);
        }
    }
    
    class BtnDellete implements EventHandler<ActionEvent>{
 
        int cabina;

        public BtnDellete(int cabina) {
            this.cabina = cabina;
        }
        
        @Override
        public void handle(ActionEvent e) {   
            if(scene.getSelectedCells1().get(cabina-1).size()>0){
                TablePosition tablePosition = (TablePosition) scene.getSelectedCells1().get(cabina-1).get(0);
                scene.getProductosCabina().get("Agregar "+cabina).remove(tablePosition.getRow());
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

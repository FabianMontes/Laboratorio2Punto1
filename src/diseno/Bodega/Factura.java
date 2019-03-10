/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diseno.Bodega;

import java.util.ArrayList;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

/**
 *
 * @author fanat
 */
public class Factura {
    private String id;
    private ArrayList<Producto> productos;
    private int size;
    private String robot;
    private int totalPrice;

    public Factura(String id, ArrayList<Producto> productos) {
        this.id = id;
        this.productos = productos;
        this.size= this.productos.size();
        setTotalPrice();
    }

    public String getId() {
        return id;
    }    

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setRobot(String robot) {
        this.robot = robot;
    }

    public String getRobot() {
        return robot;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
        this.size= this.productos.size();
        setTotalPrice();
    }
    
    public void show(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
	alert.setTitle("Impresion De Factura");
	alert.setHeaderText("El robot "+ robot + " tiene una Factura");
	alert.setContentText("");

	// Create expandable Exception.
	
        String factura= "factura para "+ id+"\n";
        
        for (int i = 0; i < productos.size(); i++) {
            factura+= productos.get(i).getName()+ ": "+ productos.get(i).getPrecio()+ "\n";
        }

        factura+="precio total: "+ totalPrice;
        
	Label label = new Label("Factura:");

	TextArea textArea = new TextArea(factura);
	textArea.setEditable(false);
	textArea.setWrapText(true);

	textArea.setMaxWidth(Double.MAX_VALUE);
	textArea.setMaxHeight(Double.MAX_VALUE);
	GridPane.setVgrow(textArea, Priority.ALWAYS);
	GridPane.setHgrow(textArea, Priority.ALWAYS);

	GridPane expContent = new GridPane();
	expContent.setMaxWidth(Double.MAX_VALUE);
	expContent.add(label, 0, 0);
	expContent.add(textArea, 0, 1);

	// Set expandable Exception into the dialog pane.
	alert.getDialogPane().setExpandableContent(expContent);
                
	alert.showAndWait();
    }

    public int getSize() {
        return size;
    }
    
    public int getTotalPrice(){
        return totalPrice;
    }
    
    public void setTotalPrice(){
        totalPrice=0;
        for (int i = 0; i < productos.size(); i++) {
            totalPrice+=productos.get(i).getPrecio();
        }
    }
    
    
    
}

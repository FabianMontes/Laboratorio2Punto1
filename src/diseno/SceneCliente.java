/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diseno;

import diseno.Bodega.Producto;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author fanat
 */
public class SceneCliente {
    
    private Scene scene;
    
    private TableView tablaProductos;
    private ArrayList<TableColumn> columnasProductos;
    
    private TableView tablaProductosPedidos;
    private ArrayList<TableColumn> columnasProductosPedidos;
    
    private Label id;
    private TextField idName;
    
    private ObservableList<Producto> productosBodega;
    private ObservableList<Producto> productosPedidos;
    private Button carBtn;
    private Button deleteBtn;
    private Button confirmBtn;
    private Button regresar;
    private VBox vbox1;
    private VBox vbox2;
    private VBox vbox3;
    private HBox hbox1;
    private HBox hbox2;
    private SplitPane split;
    
    private ObservableList selectedProduct;
    private ObservableList selectedCar;
    

    public SceneCliente(ObservableList<Producto> productosBodega ) {
        vbox1 = new VBox();
        vbox2 = new VBox();
        vbox3 = new VBox();
        hbox1 = new HBox();
        hbox2 = new HBox();
        
        id = new Label("ID: ");
        idName = new TextField(" ");
        
        hbox2.getChildren().addAll(id, idName);
        
        tablaProductosPedidos = new TableView();
        tablaProductos = new TableView();
        
        carBtn = new Button("Agregar Al Carro");
        deleteBtn = new Button("Quitar del Carro");
        confirmBtn = new Button("Hacer  Pedido");
        regresar = new Button("Regresar");
        
        productosPedidos = FXCollections.observableArrayList();
        this.productosBodega = productosBodega;
        
        columnasProductos= new ArrayList<>();
        columnasProductos.add(new TableColumn("Nombre"));
        columnasProductos.add(new TableColumn("Precio"));
        columnasProductos.get(0).setCellValueFactory(new PropertyValueFactory<>("name"));
        columnasProductos.get(1).setCellValueFactory(new PropertyValueFactory<>("precio"));
        columnasProductosPedidos= new ArrayList<>();
        columnasProductosPedidos.add(new TableColumn("Nombre"));
        columnasProductosPedidos.add(new TableColumn("Precio"));
        columnasProductosPedidos.get(0).setCellValueFactory(new PropertyValueFactory<>("name"));
        columnasProductosPedidos.get(1).setCellValueFactory(new PropertyValueFactory<>("precio"));
        
        
        tablaProductosPedidos.getColumns().setAll(columnasProductosPedidos);
        tablaProductos.getColumns().setAll(columnasProductos);
        tablaProductosPedidos.setItems(productosPedidos);
        tablaProductos.setItems(this.productosBodega);
        
        selectedCar =tablaProductos.getSelectionModel().getSelectedCells();
        selectedProduct=tablaProductosPedidos.getSelectionModel().getSelectedCells();
        
        vbox1.getChildren().addAll(tablaProductos, carBtn);
        
        hbox1.getChildren().addAll(deleteBtn, confirmBtn);
        vbox2.getChildren().addAll(hbox2,tablaProductosPedidos, hbox1);
        
        split = new SplitPane(vbox1,vbox2);
        
        vbox3.getChildren().addAll(split,regresar);
        scene= new Scene(vbox3, 500, 500, Color.KHAKI);
    }
    
    public void show(Stage stage){
        stage.setScene(scene);
        stage.show();
    }

    public Button getCarBtn() {
        return carBtn;
    }

    public Button getDeleteBtn() {
        return deleteBtn;
    }

    public ObservableList<Producto> getProductosBodega() {
        return productosBodega;
    }

    public ObservableList<Producto> getProductosPedidos() {
        return productosPedidos;
    }

    public Button getConfirmBtn() {
        return confirmBtn;
    }

    public Button getRegresar() {
        return regresar;
    }

    public ObservableList getSelectedProduct() {
        return selectedProduct;
    }

    public ObservableList getSelectedCar() {
        return selectedCar;
    }

    public TableView getTablaProductos() {
        return tablaProductos;
    }

    public TextField getIdName() {
        return idName;
    }
    
    
    
    
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diseno;

import diseno.Bodega.Factura;
import diseno.Bodega.Producto;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author fanat
 */
public class SceneEmpleados {
    private Scene Empleados;
    
    private BorderPane layout;
    
    private Button Regresar;
    
    private TabPane Menu;
    
    private ArrayList<Tab> taps;
    
    private ArrayList<VBox> vboxes;
    private ArrayList<VBox> vboxEsta;
    private ArrayList<HBox> hboxes;
    
    private ArrayList<GridPane> grids;
    
    private ArrayList<SplitPane> splits;
    
    private ArrayList<Label> nombres;
    private ArrayList<TextField> pName;
    
    
    private ArrayList<Label> Precios;
    private ArrayList<TextField> pPrice;
    
    private ArrayList<Button> addProduct;
    
    private ArrayList<ObservableList> selectedCells1;
    private ArrayList<ObservableList> selectedCells2;
    private ArrayList<ObservableList> selectedCells3;
    
    
    private ArrayList<TableView> tablaProductos;
    private HashMap<String, ArrayList<TableColumn>> columnasProductos;
    
    private ArrayList<TableView> tablasLClient;
    private HashMap<String, ArrayList<TableColumn>> columnasLClient;
    
    
    private ArrayList<TableView> tablaFacturas;
    private HashMap<String, ArrayList<TableColumn>> columnasFactura;
    
    
    
    private HashMap<String, ObservableList<Producto>> productosCabina;
    private HashMap<Integer, ObservableList<Factura>> facturasCabina;
    private HashMap<Integer, ObservableList<Factura>> OrdersClient;
    
    private ArrayList<Button> deleteButton;
    private ArrayList<Button> pedirEstan;
    
    private ArrayList<Button> pedirMensa;
    private ArrayList<Button> pedirProduc;
    
    
    
    
    

    public SceneEmpleados(HashMap<Integer, ObservableList<Factura>> facturasCabina, HashMap<Integer, ObservableList<Factura>> OrdersClient) {
        Regresar = new Button("Regresar");
        layout = new BorderPane();
        
        this.Menu= new TabPane();
        taps = new ArrayList<>();
        grids = new ArrayList<>();
        vboxes = new ArrayList<>();
        vboxEsta = new ArrayList<>();
        hboxes = new ArrayList<>();
        splits = new ArrayList<>();
        nombres = new ArrayList<>();
        Precios = new ArrayList<>();
        pName = new ArrayList<>();
        pPrice = new ArrayList<>();
        addProduct = new ArrayList<>();
        
        tablaProductos = new ArrayList<>();
        tablaFacturas = new ArrayList<>();
        tablasLClient = new ArrayList<>();
        productosCabina = new HashMap<>();
        this.facturasCabina = facturasCabina;
        this.OrdersClient = OrdersClient;
    
        deleteButton= new ArrayList<>();
        pedirEstan = new ArrayList<>();
        pedirMensa = new ArrayList<>();
        pedirProduc = new ArrayList<>();
        
        columnasProductos =new HashMap<>();
        columnasFactura =new HashMap<>();
        columnasLClient = new HashMap<>();
        
        selectedCells1 = new ArrayList<>();
        selectedCells2 = new ArrayList<>();
        selectedCells3 = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            String tabName;
            if(i<5){
                tabName="Agregar "+ String.valueOf(i+1);
                
                grids.add(new GridPane());
                grids.get(i).setAlignment(Pos.CENTER);
                grids.get(i).setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
                grids.get(i).setHgap(5.5);
                grids.get(i).setVgap(5.5);
                
                nombres.add(new Label("Inserte Nombre del Producto: "));
                grids.get(i).add(nombres.get(i), 0, 0);
                
                Precios.add(new Label("inserte Precio del procucto"));
                grids.get(i).add(Precios.get(i), 0, 1);
                pName.add(new TextField());
                grids.get(i).add(pName.get(i), 1, 0);
                pPrice.add(new TextField());
                grids.get(i).add(pPrice.get(i), 1, 1);
                addProduct.add(new Button("Agregar"));
                grids.get(i).add(addProduct.get(i), 0, 2);
                
                columnasProductos.put(tabName, new ArrayList<>());
                columnasProductos.get(tabName).add(new TableColumn("Nombre"));
                columnasProductos.get(tabName).add(new TableColumn("Precio"));
                columnasProductos.get(tabName).get(0).setCellValueFactory(new PropertyValueFactory<>("name"));
                columnasProductos.get(tabName).get(1).setCellValueFactory(new PropertyValueFactory<>("precio"));
                
                
                
                productosCabina.put(tabName, FXCollections.observableArrayList());
                
                tablaProductos.add(new TableView());
                tablaProductos.get(i).getColumns().addAll(columnasProductos.get(tabName));
                tablaProductos.get(i).setItems(productosCabina.get(tabName));
                
                deleteButton.add(new Button("Borrar Elemento"));
                pedirEstan.add(new Button("Guardar En Bodega"));
                
                hboxes.add(new HBox());
                hboxes.get(i).getChildren().addAll(deleteButton.get(i),pedirEstan.get(i));
                
                vboxes.add(new VBox());
                vboxes.get(i).getChildren().addAll(tablaProductos.get(i), hboxes.get(i));
                
                splits.add(new SplitPane(grids.get(i), vboxes.get(i)));
                
                
                selectedCells1.add(tablaProductos.get(i).getSelectionModel().getSelectedCells());
                
            }else{
                tabName="Empaque "+ String.valueOf(i+1);
                columnasFactura.put(tabName, new ArrayList<>());
                columnasFactura.get(tabName).add(new TableColumn("ID"));
                columnasFactura.get(tabName).add(new TableColumn("Tamaño"));
                columnasFactura.get(tabName).add(new TableColumn("Precio Total"));
                columnasFactura.get(tabName).get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
                columnasFactura.get(tabName).get(1).setCellValueFactory(new PropertyValueFactory<>("size"));
                columnasFactura.get(tabName).get(2).setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
                
                columnasLClient.put(tabName, new ArrayList<>());
                columnasLClient.get(tabName).add(new TableColumn("ID"));
                columnasLClient.get(tabName).add(new TableColumn("Tamaño"));
                columnasLClient.get(tabName).add(new TableColumn("Precio Total"));
                columnasLClient.get(tabName).get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
                columnasLClient.get(tabName).get(1).setCellValueFactory(new PropertyValueFactory<>("size"));
                columnasLClient.get(tabName).get(2).setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
                
                
                //productosCabina.put(tabName, FXCollections.observableArrayList());
                
                tablasLClient.add(new TableView());
                tablasLClient.get(i-5).getColumns().addAll(columnasLClient.get(tabName));
                tablasLClient.get(i-5).setItems(this.OrdersClient.get(i-4));
                
                tablaFacturas.add(new TableView());
                tablaFacturas.get(i-5).getColumns().addAll(columnasFactura.get(tabName));
                tablaFacturas.get(i-5).setItems(this.facturasCabina.get(i-4));
                
                pedirMensa.add(new Button("Enviar Pedido"));
                pedirProduc.add(new Button("Traer Productos"));
                
                vboxEsta.add(new VBox());
                vboxEsta.add(new VBox());
                vboxEsta.get((i-5)*2).getChildren().addAll(tablasLClient.get(i-5), pedirProduc.get(i-5));
                vboxEsta.get((i-5)*2+1).getChildren().addAll(tablaFacturas.get(i-5), pedirMensa.get(i-5));
                
                splits.add(new SplitPane(vboxEsta.get((i-5)*2), vboxEsta.get((i-5)*2+1)));
                
                
                selectedCells2.add(tablasLClient.get(i-5).getSelectionModel().getSelectedCells());                
                selectedCells3.add(tablaFacturas.get(i-5).getSelectionModel().getSelectedCells());                
            }
            taps.add(new Tab(tabName, splits.get(i)));
        }
        
        Menu.getTabs().addAll(taps);
        layout.setCenter(Menu);
        layout.setBottom(Regresar);
        
        Empleados= new Scene(layout, 500, 500, Color.GRAY);
    }
    
    public void show(Stage stage) {
        stage.setTitle("AgregarProducos");
       stage.setScene(Empleados);
       stage.show();
       
    }

    public Button getRegresar() {
        return Regresar;
    }

    public ArrayList<Button> getAddProduct() {
        return addProduct;
    }

    public ArrayList<ObservableList> getSelectedCells1() {
        return selectedCells1;
    }
    
    public ArrayList<ObservableList> getSelectedCells2() {
        return selectedCells2;
    }
    
    public ArrayList<ObservableList> getSelectedCells3() {
        return selectedCells3;
    }
    
    public ArrayList<Button> getDeleteButton() {
        return deleteButton;
    }

    public ArrayList<Button> getPedirProduc() {
        return pedirProduc;
    }

    public HashMap<String, ObservableList<Producto>> getProductosCabina() {
        return productosCabina;
    }

    public HashMap<Integer, ObservableList<Factura>> getFacturasCabina() {
        return facturasCabina;
    }

    public ArrayList<Button> getPedirEstan() {
        return pedirEstan;
    }

    public ArrayList<Button> getPedirMensa() {
        return pedirMensa;
    }

    public ArrayList<TextField> getpName() {
        return pName;
    }

    public ArrayList<TextField> getpPrice() {
        return pPrice;
    }

    public HashMap<Integer, ObservableList<Factura>> getOrdersClient() {
        return OrdersClient;
    }

    public void setFacturasCabina(HashMap<Integer, ObservableList<Factura>> facturasCabina) {
        this.facturasCabina = facturasCabina;
    }

    
    
    
    
    
    
    
    
    
}

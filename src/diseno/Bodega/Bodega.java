package diseno.Bodega;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Estudiante
 */
import becker.robots.*;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Bodega{
    private City ciudad;
    private ArrayList<HiloRobotsMensajeros> hiloMensajeros;
    private ArrayList<HiloRobotsEstantes> hiloEstantes;
    private HashMap<Integer, Integer> cabinaEntrega;
    private HashMap<Integer,ObservableList<Factura>> pedidosCliente;
    private HashMap<Integer, ObservableList<Factura>> facturas;
    private ObservableList<Producto> productos;

    public Bodega() throws FileNotFoundException {
        this.ciudad = new City(new Scanner(new File("src/Punto1/Bodega/Field.txt")));
        ArrayList<Thing> thing = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            if(i<5){
                thing.add(new Thing(ciudad, i+2, 4));
                thing.get(i).getIcon().setColor(Color.GREEN);
                thing.get(i).getIcon().setLabel("Agregar "+ (i+1));
            }else if(i<10){
                thing.add(new Thing(ciudad, i+2, 4));
                thing.get(i).getIcon().setColor(Color.CYAN);
                thing.get(i).getIcon().setSize(0.5);
                thing.get(i).getIcon().setLabel("Empaque "+ (i%5+1));
            }else{
                thing.add(new Thing(ciudad, 13, 0));
                thing.get(i).getIcon().setColor(Color.LIGHT_GRAY);
                thing.get(i).getIcon().setLabel("Envio");
            }
            
        }
        cabinaEntrega= new HashMap<>();
        productos = FXCollections.observableArrayList();
        
        facturas= new HashMap<>();
        pedidosCliente= new HashMap<>();
        
        for (int i = 1; i < 6; i++) {
            cabinaEntrega.put(i, 0);
            facturas.put(i, FXCollections.observableArrayList());
            pedidosCliente.put(i, FXCollections.observableArrayList());
        }
        
        
        
        hiloMensajeros =new ArrayList<>();
        hiloEstantes =new ArrayList<>();
        HiloRobotsMensajeros.vaciarMapa();
        for (int i = 0; i < 10; i++) {
            hiloMensajeros.add(new HiloRobotsMensajeros(new Robot(ciudad, i+2, 0, Direction.EAST), "Mensajero " +String.valueOf(i+1)));
            hiloMensajeros.get(i).getOrders().add(20);
            hiloMensajeros.get(i).start();
        }
        for (int i = 0; i < 10; i++) {
            hiloEstantes.add(new HiloRobotsEstantes(new Robot(ciudad, i+2, 16, Direction.WEST), String.valueOf(i)));
            hiloEstantes.get(i).getOrders().add(20);
            hiloEstantes.get(i).start();
        }
        for (int i = 0; i < 10; i++) {
            hiloEstantes.add(new HiloRobotsEstantes(new Robot(ciudad, i+2, 17, Direction.EAST), String.valueOf(i+10)));
            hiloEstantes.get(i+10).getOrders().add(20);
            hiloEstantes.get(i+10).start();
        }
        
        
    }
    
    public void PedirMensajero(int a, Factura factura){
        int tam=hiloMensajeros.get(0).getOrders().size();
        int b=0;
        for (int i = 0; i < hiloMensajeros.size(); i++) {
            if(hiloMensajeros.get(i).getOrders().size()<tam){
                b=i;
                break;
            }
        }
        hiloMensajeros.get(b).addOrder(a, factura);
    }
    
    public int espacioEnBodega(){
        int can=0;
        for (int i = 0; i < hiloEstantes.size(); i++) {
            can+=hiloEstantes.get(0).getEstante().Espacio();
        }
        return can;
    }
    
    public void AgregarProductos(ArrayList<Producto> productos, int cabina){
        for (int i = 0; i < productos.size(); i++) {
            this.productos.add(productos.get(i));
        }
        
        int menosBussy=0;
        
        for (int i = 0; i < hiloEstantes.size(); i++) {
            if(hiloEstantes.get(menosBussy).getOrders().size()>hiloEstantes.get(i).getOrders().size()){
                menosBussy=i;
            }
        }
        
        for (int i = menosBussy; i < hiloEstantes.size()+menosBussy; i++) {
            boolean orden = false;
            if(productos.size()<=0){
                break;
            }
            int h=i%hiloEstantes.size();
            int espacio=hiloEstantes.get(h).getEstante().Espacio();
            for (int j = 0; j < espacio; j++) {
                if(productos.size()<=0){
                    break;
                }
                if(hiloEstantes.get(h).getEstante().agregarProducto(productos.get(0))){
                    System.out.println("llegaHasta aqui");
                    if (!orden) {
                        hiloEstantes.get(h).addOrder(cabina);
                        orden=true;
                    }
                    productos.remove(0);
                }
            }
        }
    }

    public ArrayList<HiloRobotsEstantes> getHiloestantes() {
        return hiloEstantes;
    }

    public ArrayList<HiloRobotsMensajeros> getHilomensajeros() {
        return hiloMensajeros;
    }
    
    public void PedirProductos(ArrayList<Producto> nProductos, String id){
        int cabina=0, prueba;
        prueba=cabinaEntrega.get(1);
        for (int i = 0; i < cabinaEntrega.size(); i++) {
            if(prueba>cabinaEntrega.get(i+1)){
                cabina=i+1;
                break;
            }
            cabina=1;
        }
        cabinaEntrega.replace(cabina, cabinaEntrega.get(cabina)+1);
        Factura factura = new Factura(id, nProductos);
        this.pedidosCliente.get(cabina).add(factura);
    }    
        
    public void outProductos(int cabina, int orden){
        Factura factura = pedidosCliente.get(cabina).remove(orden);
        System.out.println(factura.getId());
        ArrayList<Integer> productosEncontrar = new ArrayList<>();
        for (int i = 0; i < factura.getSize(); i++) {
            productosEncontrar.add(i);
            System.out.println(productosEncontrar.get(i));
        }
        int a=0;
        for (int i = 0; i < hiloEstantes.size(); i++) {
            boolean ya= false;
            while (a<productosEncontrar.size()) {
                System.out.println("ya");
                if(hiloEstantes.get(i).getEstante().getTieneElProducto(factura.getProductos().get(productosEncontrar.get(a)).getName())){
                    System.out.println("haaa");
                    if(!ya){
                        System.out.println("habia");
                        hiloEstantes.get(i).addOrder(cabina+5);
                        ya=true;
                    }
                    System.out.println(factura.getProductos().get(productosEncontrar.get(a)).getName());
                    hiloEstantes.get(i).getEstante().sacarProducto(factura.getProductos().get(productosEncontrar.get(a)).getName());
                    System.out.println("give");
                    productosEncontrar.remove(a);
                }else{
                    a++;
                }
            }
            a=0;
        }
        this.facturas.get(cabina).add(factura);
    }
    
    public void EnviarFactura(int cabina, int order){
        Factura factura = facturas.get(cabina).remove(order);
        System.out.println(factura.getId());
        PedirMensajero(cabina, factura);
    }

    public HashMap<Integer, ObservableList<Factura>> getFacturas() {
        return facturas;
    }

    public ObservableList<Producto> getProductos() {
        return productos;
    }

    public HashMap<Integer, ObservableList<Factura>> getPedidosCliente() {
        return pedidosCliente;
    }
    
    
    
    
}

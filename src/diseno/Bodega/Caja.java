/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diseno.Bodega;

import java.util.ArrayList;

/**
 *
 * @author fanat
 */
public class Caja {
    private int number;
    private Producto[] productos = new Producto[7];
    
    public Caja(int number) {
        this.number = number;
        for (int i = 0; i < 7; i++) {
            productos[i]=null;
        }
        
    }

    public int getNumber() {
       return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
   
    public boolean guardarProducto(Producto producto){
        for (int i = 0; i < 7; i++) {
            if(productos[i]==null){
                producto.setCaja(number);
                productos[i]= producto;
                return true;
            }
        }
        return false;
    }
    
    public Producto sacarProducto(String name){
        Producto producto=null;
        for (int i = 0; i < 7; i++) {
            if(productos[i].getName().equals(name)){
                producto =productos[i];
                productos[i]=null;
                break;
            }
        }
        
        return producto;
    }
    
    public boolean getTieneEspacio(){
        for (int i = 0; i < 7; i++) {
            if(productos[i]==null){
                return true;
            }
        }
        return false;
    }
    
    public int Espacio(){
        for (int i = 0; i < 7; i++) {
            if(productos[i]==null){
                return 7-i;
            }
        }
        return 0;
    }
    
    public ArrayList<Producto> getProductos(){
        ArrayList<Producto> producto = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            if(productos[i]!=null){
                producto.add(productos[i]);
            }
        }
        return producto;
    }
    
    public boolean getTieneElProducto(String name){
        for (int i = 0; i < 7; i++) {
            if(productos[i].getName().equals(name)){
                return true;
            }
        }
        return false;
    }
   
}

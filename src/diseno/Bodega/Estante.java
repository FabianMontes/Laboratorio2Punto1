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
public class Estante {
    private int number;
    private Caja[] caja = new Caja[3];

    public Estante(int number) {
        this.number = number;
        for (int i = 0; i < 3; i++) {
            caja[i] = new Caja(i);
        }
        
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
    public boolean agregarProducto(Producto producto){
        for (int i = 0; i < 3; i++) {
            producto.setNumEstante(number);
            if(caja[i].guardarProducto(producto)){
                return true;
            }
        }
        return false;
    }
    
    public Producto sacarProducto(String name){
        Producto producto= null;
        for (int i = 0; i < 3; i++) {
            if((producto =caja[i].sacarProducto(name))!=null){
                break;
            }
        }
        return producto;
    }
    
    public boolean puedeAgregarProduto(){
        for (int i = 0; i < 3; i++) {
            if(caja[i].getTieneEspacio()){
                return true;
            }
        }
        return false;
    }
    
    public int Espacio(){
        int can=0;
        for (int i = 0; i < 3; i++) {
            can+=caja[i].Espacio();
        }
        return can;
    }
    
    public ArrayList<Producto> getProductos(){
        ArrayList<Producto> productos = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ArrayList<Producto> productosCaja = caja[i].getProductos();
            for (Producto productosCaja1 : productosCaja) {
                productos.add(productosCaja1);
            }
        }
        return productos;
    }
    
    public boolean getTieneElProducto(String name){
        for (int i = 0; i < 3; i++) {
            if(caja[i].getTieneElProducto(name)){
                return true;
            }
        }
        return false;
    }
    
}

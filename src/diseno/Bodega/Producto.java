/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diseno.Bodega;

/**
 *
 * @author fanat
 */
public class Producto {
    private String name;
    private int precio;
    private int numEstante;
    private int caja;

    public Producto(String name, int precio, int numEstante, int caja) {
        this.name = name;
        this.precio = precio;
        this.numEstante = numEstante;
        this.caja = caja;
    }

    public String getName() {
        return name;
    }

    public int getPrecio() {
        return precio;
    }

    public int getNumEstante() {
        return numEstante;
    }

    public int getCaja() {
        return caja;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setNumEstante(int numEstante) {
        this.numEstante = numEstante;
    }

    public void setCaja(int caja) {
        this.caja = caja;
    }
    
}

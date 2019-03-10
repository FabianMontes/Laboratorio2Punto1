package diseno.Bodega;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import becker.robots.*;
import java.util.ArrayList;

/**
 * 
 * @author Estudiante
 */
public abstract class HiloRobots extends Thread{
    protected Robot sonny;
    protected String id;
    protected String estado;
    protected int[] ubParqueo= new int[2];;
    protected static int[][] mapaDeEspacios= new int[16][20];   
    protected ArrayList<Integer> orders;

    public HiloRobots(Robot sonny,String id) {
        this.sonny = sonny;    
        this.id=id;
        this.ubParqueo[0]=sonny.getStreet();
        this.ubParqueo[1]=sonny.getAvenue();
        HiloRobots.mapaDeEspacios[sonny.getStreet()][sonny.getAvenue()]=1;   
        this.orders= new ArrayList<>();
        estado = "Resting";
        sonny.setLabel(this.id);
    }
    
    public static void vaciarMapa(){
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 20; j++) {
                mapaDeEspacios[i][j]=0;
            }
        }
    }
    
    public boolean canMove(){
        switch (sonny.getDirection()) {
            case NORTH:
                return mapaDeEspacios[sonny.getStreet()-1][sonny.getAvenue()]==0;
            case SOUTH:
                return mapaDeEspacios[sonny.getStreet()+1][sonny.getAvenue()]==0;
            case WEST:
                return mapaDeEspacios[sonny.getStreet()][sonny.getAvenue()-1]==0;
            default:
                return mapaDeEspacios[sonny.getStreet()][sonny.getAvenue()+1]==0;
        }
        
    }

    public String getEstado() {
        return estado;
    }
    
    public void move(){
        switch (sonny.getDirection()) {
            case NORTH:
                mapaDeEspacios[sonny.getStreet()-1][sonny.getAvenue()]=1;
                mapaDeEspacios[sonny.getStreet()][sonny.getAvenue()]=2;
                sonny.move();
                mapaDeEspacios[sonny.getStreet()+1][sonny.getAvenue()]=0;
            break;
            case SOUTH:
                mapaDeEspacios[sonny.getStreet()+1][sonny.getAvenue()]=1;
                mapaDeEspacios[sonny.getStreet()][sonny.getAvenue()]=2;
                sonny.move();
                mapaDeEspacios[sonny.getStreet()-1][sonny.getAvenue()]=0;
            break;
            case WEST:
                mapaDeEspacios[sonny.getStreet()][sonny.getAvenue()-1]=1;
                mapaDeEspacios[sonny.getStreet()][sonny.getAvenue()]=2;
                sonny.move();
                mapaDeEspacios[sonny.getStreet()][sonny.getAvenue()+1]=0;
            break;
            default:
                mapaDeEspacios[sonny.getStreet()][sonny.getAvenue()+1]=1;
                mapaDeEspacios[sonny.getStreet()][sonny.getAvenue()]=2;
                sonny.move();
                mapaDeEspacios[sonny.getStreet()][sonny.getAvenue()-1]=0;
            break;
        }
        
    }

    public void moveST(int a){
        for (int i = 0; i < a; i++) {
            while(!canMove()){
            }
            move();
        }
    }
    
    public void rotarTaD(Direction direccion){
        while(sonny.getDirection()!=direccion){
            sonny.turnLeft();
        }
    }
    
    public void ChangeEstado(String estado){
        this.estado = estado;
    }
    
    public abstract void Draw();

    public Robot getSonny() {
        return sonny;
    }

    public ArrayList<Integer> getOrders() {
        return orders;
    }

    @Override
    public void run(){
            Draw();
    }

    
}

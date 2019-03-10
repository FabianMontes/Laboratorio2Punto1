package diseno.Bodega;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import becker.robots.*;
import java.util.ArrayList;
import javafx.scene.control.Alert;

/**
 * 
 * @author Estudiante
 */
public class HiloRobotsEstantes extends HiloRobots{
    private Estante estante;
    
    public HiloRobotsEstantes(Robot sonny, String identificador) {
        super(sonny, "Estante "+String.valueOf(Integer.parseInt(identificador)+1));
        estante=new Estante(Integer.parseInt(identificador));
    }

    public Estante getEstante() {
        return estante;
    } 
    
    public void moveToAdd(int number){
        switch(ubParqueo[1]){
            case 17:
                rotarTaD(Direction.EAST);
                moveST(1);
                rotarTaD(Direction.NORTH);
                moveST(ubParqueo[0]-1);
                rotarTaD(Direction.WEST);
                moveST(5);
                rotarTaD(Direction.SOUTH);
                moveST(1);
                rotarTaD(Direction.WEST);
                moveST(1);
                rotarTaD(Direction.SOUTH);
                moveST(4);
                rotarTaD(Direction.WEST);
                moveST(1);
                rotarTaD(Direction.NORTH);
                moveST(4);
                rotarTaD(Direction.WEST);
                moveST(1);
                rotarTaD(Direction.SOUTH);
                moveST(4);
                rotarTaD(Direction.WEST);
                moveST(1);
                rotarTaD(Direction.NORTH);
                moveST(4);
                rotarTaD(Direction.WEST);
                moveST(1);
                rotarTaD(Direction.SOUTH);
                moveST(number-1);
                rotarTaD(Direction.WEST);
                while(mapaDeEspacios[1+number][4]==1){
                    System.out.println("waiting");
                }
                moveST(4);
                ChangeEstado("Waiting");
                while (estado.contains("Waiting")) {                    
                    System.out.println(" ");
                }
                //alert.showAndWait();
                rotarTaD(Direction.EAST);
                moveST(1);
                rotarTaD(Direction.SOUTH);
                moveST(12-number);
                rotarTaD(Direction.EAST);
                moveST(13);
                rotarTaD(Direction.NORTH);
                moveST(13-ubParqueo[0]);
                rotarTaD(Direction.WEST);
                moveST(1);
                rotarTaD(Direction.EAST);
                ChangeEstado("Resting");
            break;
            default:
                rotarTaD(Direction.WEST);
                moveST(2);
                rotarTaD(Direction.NORTH);
                moveST(ubParqueo[0]-2);
                rotarTaD(Direction.WEST);
                moveST(2);
                rotarTaD(Direction.SOUTH);
                moveST(4);
                rotarTaD(Direction.WEST);
                moveST(1);
                rotarTaD(Direction.NORTH);
                moveST(4);
                rotarTaD(Direction.WEST);
                moveST(1);
                rotarTaD(Direction.SOUTH);
                moveST(4);
                rotarTaD(Direction.WEST);
                moveST(1);
                rotarTaD(Direction.NORTH);
                moveST(4);
                rotarTaD(Direction.WEST);
                moveST(1);
                rotarTaD(Direction.SOUTH);
                moveST(number-1);
                rotarTaD(Direction.WEST);
                while(mapaDeEspacios[1+number][4]==1){
                    System.out.println("waiting");
                }
                moveST(4);
                ChangeEstado("Waiting");
                while (estado.contains("Waiting")) {                    
                    System.out.println(" ");
                }
                rotarTaD(Direction.EAST);
                moveST(1);
                rotarTaD(Direction.SOUTH);
                moveST(12-number);
                rotarTaD(Direction.EAST);
                moveST(10);
                rotarTaD(Direction.NORTH);
                moveST(13-ubParqueo[0]);
                rotarTaD(Direction.EAST);
                moveST(1);
                rotarTaD(Direction.WEST);
                ChangeEstado("Resting");
            break;
        }
    }
    
    public void moveToOut(int number){
        switch(ubParqueo[1]){
            case 17:
                rotarTaD(Direction.EAST);
                moveST(2);
                rotarTaD(Direction.SOUTH);
                moveST(12-ubParqueo[0]);
                rotarTaD(Direction.WEST);
                moveST(6);
                rotarTaD(Direction.NORTH);
                moveST(1);
                rotarTaD(Direction.WEST);
                moveST(1);
                rotarTaD(Direction.NORTH);
                moveST(4);
                rotarTaD(Direction.WEST);
                moveST(1);
                rotarTaD(Direction.SOUTH);
                moveST(4);
                rotarTaD(Direction.WEST);
                moveST(1);
                rotarTaD(Direction.NORTH);
                moveST(4);
                rotarTaD(Direction.WEST);
                moveST(1);
                rotarTaD(Direction.SOUTH);
                moveST(4);
                rotarTaD(Direction.WEST);
                moveST(1);
                rotarTaD(Direction.NORTH);
                moveST(5-number);
                rotarTaD(Direction.WEST);
                while(mapaDeEspacios[6+number][4]==1){
                    System.out.println("waiting");
                }
                moveST(4);
                ChangeEstado("Waiting");
                while (estado.contains("Waiting")) {                    
                    System.out.println(" ");
                }
                rotarTaD(Direction.EAST);
                moveST(1);
                rotarTaD(Direction.SOUTH);
                moveST(7-number);
                rotarTaD(Direction.EAST);
                moveST(13);
                rotarTaD(Direction.NORTH);
                moveST(13-ubParqueo[0]);
                rotarTaD(Direction.WEST);
                moveST(1);
                rotarTaD(Direction.EAST);
                ChangeEstado("Resting");
            break;
            default:
                rotarTaD(Direction.WEST);
                moveST(3);
                rotarTaD(Direction.SOUTH);
                moveST(11-ubParqueo[0]);
                rotarTaD(Direction.WEST);
                moveST(1);
                rotarTaD(Direction.NORTH);
                moveST(4);
                rotarTaD(Direction.WEST);
                moveST(1);
                rotarTaD(Direction.SOUTH);
                moveST(4);
                rotarTaD(Direction.WEST);
                moveST(1);
                rotarTaD(Direction.NORTH);
                moveST(4);
                rotarTaD(Direction.WEST);
                moveST(1);
                rotarTaD(Direction.SOUTH);
                moveST(4);
                rotarTaD(Direction.WEST);
                moveST(1);
                rotarTaD(Direction.NORTH);
                moveST(5-number);
                rotarTaD(Direction.WEST);
                while(mapaDeEspacios[6+number][4]==1){
                    System.out.println("waiting");
                }
                moveST(4);
                ChangeEstado("Waiting");
                while (estado.contains("Waiting")) {                    
                    System.out.println(" ");
                }
                rotarTaD(Direction.EAST);
                moveST(1);
                rotarTaD(Direction.SOUTH);
                moveST(7-number);
                rotarTaD(Direction.EAST);
                moveST(10);
                rotarTaD(Direction.NORTH);
                moveST(13-ubParqueo[0]);
                rotarTaD(Direction.EAST);
                moveST(1);
                rotarTaD(Direction.WEST);
                ChangeEstado("Resting");
            break;
        }
    }
    
    @Override
    public void Draw(){
        while(orders.size()>0){
            if(orders.get(0)!=20){
                System.out.println("hace esto?");
                if(orders.get(0)<6){
                    moveToAdd(orders.get(0));
                    System.out.println("est");
                }else{
                    moveToOut(orders.get(0)-5);
                    System.out.println("ese");
                }
            }
            orders.remove(0);
            if(orders.size()<=0){
                this.suspend();
            }
        }     
        
    }
    
    public void addOrder(int order) {
        if(orders.isEmpty()){
            System.out.println("sesta aqui?");
            orders.add(order);
            System.out.println(orders.size());
            this.resume();
        }else{
            orders.add(order);
        }   
    }
    
    

    public ArrayList<Integer> getOrders() {
        return orders;
    }
    

    

    
    
    

    
    
    
}

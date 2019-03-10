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
public class HiloRobotsMensajeros extends HiloRobots{
    private ArrayList<Factura> factura;
    
    
    public HiloRobotsMensajeros(Robot sonny, String id) {
        super(sonny, id);
        factura= new ArrayList<>();
    }

    public void moveEnvio(int number){
        ChangeEstado("Moving");
        moveST(2);
        rotarTaD(Direction.NORTH);
        moveST(ubParqueo[0]-1);
        rotarTaD(Direction.EAST);
        moveST(4);
        rotarTaD(Direction.SOUTH);
        moveST(5+number);
        rotarTaD(Direction.WEST);
        while(mapaDeEspacios[6+number][4]==1){
            System.out.println("waiting");
        }
        moveST(2);
        ChangeEstado("Waiting");
        System.out.println(estado);
        while(estado.equals("Waiting")){
            System.out.println(" ");
        }
        rotarTaD(Direction.EAST);
        moveST(1);
        rotarTaD(Direction.SOUTH);
        moveST(6-number);
        rotarTaD(Direction.WEST);
        moveST(1);
        rotarTaD(Direction.SOUTH);
        moveST(2);
        rotarTaD(Direction.WEST);
        moveST(1);
        rotarTaD(Direction.NORTH);
        moveST(2);
        rotarTaD(Direction.WEST);
        moveST(1);
        rotarTaD(Direction.SOUTH);
        moveST(2);
        rotarTaD(Direction.WEST);
        moveST(1);
        rotarTaD(Direction.NORTH);
        moveST(2);
        rotarTaD(Direction.WEST);
        moveST(1);
        rotarTaD(Direction.SOUTH);
        moveST(1);
        ChangeEstado("Entregando");
        while(estado.equals("Entregando")){
            System.out.println("Entregando");
        }
        factura.remove(0);
        moveST(2);
        rotarTaD(Direction.EAST);
        moveST(7);
        rotarTaD(Direction.NORTH);
        moveST(15);
        rotarTaD(Direction.WEST);
        moveST(6);
        rotarTaD(Direction.SOUTH);
        moveST(ubParqueo[0]);
        rotarTaD(Direction.WEST);
        moveST(1);
        rotarTaD(Direction.EAST);
        ChangeEstado("Resting");
    }
    
    @Override
    public void Draw(){
        while(orders.size()>0){
            if(orders.get(0)!=20){
                System.out.println("aqui");
                moveEnvio(orders.get(0));
                System.out.println("funiona");
            }else{
                
            }
            orders.remove(0);
            if(orders.isEmpty()){
                this.suspend();
            }
        }
    }

    public ArrayList<Factura> getFactura() {
        return factura;
    }
    
    public void addOrder(int order, Factura factura) {
        System.out.println("llega aqui?");
        factura.setRobot(id);
        this.factura.add(factura);
        System.out.println(this.factura.get(0).getId());
        if(orders.isEmpty()){
            orders.add(order);
            this.resume();
            System.out.println("dorrinedo");
            System.out.println(orders.get(0));
        }else{
            orders.add(order);
        }   
        
    }


    

}

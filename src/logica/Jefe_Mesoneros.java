/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;
import interfaz.Interfaz;

/**
 *
 * @author Gilberto
 */
public class Jefe_Mesoneros extends Thread{
    
    private int contador;
    private float hora;
    private boolean descansando;
    Interfaz interfaz;
    
    public Jefe_Mesoneros(Interfaz interfaz){
        this.contador = 8;
        this.hora = (float) 0.05;
        this.descansando = true;
        this.interfaz = interfaz;
    }
    
    @Override
    public void run(){
        
    }
    
}

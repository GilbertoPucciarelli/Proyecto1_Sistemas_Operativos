/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import interfaz.Interfaz;
import java.util.Random;
/**
 *
 * @author Gilberto
 */
public class Gerente extends Thread{
    
    private float hora;
    private boolean descansando;
    Interfaz interfaz;
    Random r;
    
    public Gerente(Interfaz interfaz){
        this.hora = (float) 0.1;
        this.interfaz = interfaz;
        this.descansando = true;
    }
    
    @Override
    public void run(){
        
    }
    
}
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
public class Mesoneros extends Thread{
    
    private float hora;
    private int ordenes;
    private int cantidadInicial;
    private boolean ejecutando;
    Interfaz interfaz;
    
    public Mesoneros(Interfaz interfaz){
        this.hora = (float) 0.15;
        this.ordenes = 0;
        this.cantidadInicial = 0;
        this.ejecutando = false;
        this.interfaz = interfaz;
    }
    
    @Override
    public void run(){
        
    }
    
}

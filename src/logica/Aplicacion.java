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
public class Aplicacion extends Thread{
    
    Interfaz interfaz;
    private boolean ejecutando;
    private C_Entradas[] c_entradas;
    private C_Platos_Fuertes c_platos_fuertes;
    private C_Postres c_postres;
    private Mesoneros mesoneros;
    private Jefe_Mesoneros jefe_mesoneros;
    
    public Aplicacion(Interfaz interfaz){
        this.interfaz = interfaz;
        this.ejecutando = false;
    }
    
    @Override
    public void run(){
        
    }
    
    public void simular() throws InterruptedException{
        
    }
}

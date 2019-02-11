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
public class C_Entradas extends Cocineros{
    
    public C_Entradas(Interfaz interfaz){
        super();
        hora = (float) 0.25;
        mesones = 20;
        cantidadInicial = 1;
        ejecutando = false;
        this.interfaz = interfaz;
    }
    
    @Override
    public void run(){
        
    }
    
}

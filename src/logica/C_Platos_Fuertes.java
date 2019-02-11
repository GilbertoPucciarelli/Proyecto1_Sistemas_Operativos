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
public class C_Platos_Fuertes extends Cocineros{
    
    public C_Platos_Fuertes(Interfaz interfaz){
        super();
        hora = (float) 0.33;
        mesones = 30;
        cantidadInicial = 2;
        ejecutando = false;
        this.interfaz = interfaz;        
    }
    
    @Override
    public void run(){
        
    }
    
}

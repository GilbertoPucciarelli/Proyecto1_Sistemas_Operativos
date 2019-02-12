/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import interfaz.Interfaz;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        
        synchronized (this) {
            do {

                if (ejecutando == false) {

                    try {
                        this.wait();

                    } catch (InterruptedException ex) {
                        Logger.getLogger(C_Entradas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                try {
                    Thread.sleep((long) (hora * 1000));
                } catch (InterruptedException ex) {
                    Logger.getLogger(C_Entradas.class.getName()).log(Level.SEVERE, null, ex);
                }

            } while (ejecutando);

        }
    }

    public float getHora() {
        return hora;
    }

    public void setHora(float hora) {
        this.hora = hora;
    }

    public int getMesones() {
        return mesones;
    }

    public void setMesones(int mesones) {
        this.mesones = mesones;
    }

    public int getCantidadInicial() {
        return cantidadInicial;
    }

    public void setCantidadInicial(int cantidadInicial) {
        this.cantidadInicial = cantidadInicial;
    }

    public boolean isEjecutando() {
        return ejecutando;
    }

    public void setEjecutando(boolean ejecutando) {
        this.ejecutando = ejecutando;
    }
    
    
}

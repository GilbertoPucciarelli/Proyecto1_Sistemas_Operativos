/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import interfaz.Interfaz;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gilberto
 */
public class Jefe_Mesoneros extends Thread {

    private int contador;
    private int hora;
    private volatile boolean ejecutando;
    Interfaz interfaz;
    private Semaphore semaforoJM;
    private int contadorinicial;
    private volatile boolean puedeDespachar = true;
    
    public Jefe_Mesoneros(int hora,Interfaz interfaz, int contador, Semaphore semaforoJM) {
        this.contador = contador;
        this.hora = hora;
        this.interfaz = interfaz;
        this.semaforoJM = semaforoJM;
        this.contadorinicial = contador;
    }

    @Override
    public void run() {

        synchronized (this) {

            do {

                try {

                    semaforoJM.acquire();
                } catch (InterruptedException ex) {

                    Logger.getLogger(Jefe_Mesoneros.class.getName()).log(Level.SEVERE, null, ex);
                }

                //TERMINA EL DIA DE TRABAJO
                if (contador == 0) {

                    interfaz.getjTextField9().setText("Reiniciando");

                    try {

                        Thread.sleep((long) (this.hora * 1000 * 0.05));

                    } catch (InterruptedException ex) {

                        Logger.getLogger(Jefe_Mesoneros.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    contador = contadorinicial;
                    interfaz.getjTextFieldHoras().setText(Integer.toString(contador));
                    this.puedeDespachar = true;

                } else {

                    //SI NO HA TERMINADO EL DIA, SE RESTAN LAS HORAS DE TRABAJO
                    interfaz.getjTextField9().setText("Modificando");

                    try {

                        Thread.sleep((long) (this.hora * 1000 * 0.05));

                    } catch (InterruptedException ex) {

                        Logger.getLogger(Jefe_Mesoneros.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    contador--;
                    interfaz.getjTextFieldHoras().setText(Integer.toString(contador));
                }
                
                semaforoJM.release();
                interfaz.getjTextField9().setText("Descansando");

                try {

                    Thread.sleep((long) (this.hora * 1000 * 0.95));

                } catch (InterruptedException ex) {

                    Logger.getLogger(Jefe_Mesoneros.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (ejecutando == false) {

                    try {

                        this.wait();

                    } catch (InterruptedException ex) {

                        Logger.getLogger(Jefe_Mesoneros.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            } while (ejecutando);
        }
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public float getHora() {
        return hora;
    }

    public boolean isEjecutando() {
        return ejecutando;
    }

    public void setEjecutando(boolean ejecutando) {
        this.ejecutando = ejecutando;
    }

    public Interfaz getInterfaz() {
        return interfaz;
    }

    public void setInterfaz(Interfaz interfaz) {
        this.interfaz = interfaz;
    }
    
        public boolean isPuedeDespachar() {
        return puedeDespachar;
    }

    public void setPuedeDespachar(boolean puedeDespachar) {
        this.puedeDespachar = puedeDespachar;
    }
}

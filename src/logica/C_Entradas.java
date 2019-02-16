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
public class C_Entradas extends Cocineros {

    private Mesones mesones;
    private Semaphore semaforoE;

    public C_Entradas(Interfaz interfaz, Mesones mesones, Semaphore semaforoE) {
        super();
        hora = (float) 0.25;
        this.mesones = mesones;
        cantidadInicial = 1;
        ejecutando = false;
        this.interfaz = interfaz;
        this.semaforoE = semaforoE;
    }

    @Override
    public void run() {

        synchronized (this) {
            do {

                if (ejecutando == false) {

                    try {
                        this.wait();

                    } catch (InterruptedException ex) {
                        Logger.getLogger(C_Entradas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                //COMPROBAR SI YA SE ALCANZO EL LIMITE DE PLATOS PRODUCIDOS
                if (mesones.getPlatosProducidos() != mesones.getCapacidad()) {

                    try {

                        semaforoE.acquire();
                    } catch (InterruptedException ex) {

                        Logger.getLogger(C_Entradas.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    for (int i = 0; i < mesones.getCapacidad(); i++) {

                        if (mesones.getMesones()[i] == 0) {

                            mesones.getMesones()[i] = 1;
                            mesones.setPlatosProducidos(mesones.getPlatosProducidos() + 1);
                            interfaz.getjTextField4().setText(Integer.toString(mesones.getPlatosProducidos()));
                            try {
                                Thread.sleep((long) (hora * 10000));
                                System.out.println("Cocinando entradas...");
                            } catch (InterruptedException ex) {
                                Logger.getLogger(C_Entradas.class.getName()).log(Level.SEVERE, null, ex);

                            }

                            break;
                        }
                    }
                    semaforoE.release();
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import interfaz.Interfaz;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gilberto
 */
public class Gerente extends Thread {

    private float hora;
    private volatile boolean ejecutando;
    Interfaz interfaz;
    private Jefe_Mesoneros jefeM;
    private Semaphore semaforoJM;
    private Semaphore semaforoE;
    private Semaphore semaforoPF;
    private Semaphore semaforoP;
    private Semaphore racesemaphore;

    public Gerente(int hora, Interfaz interfaz, Jefe_Mesoneros jefeM, Semaphore semaforoJM, Semaphore semaforoE, Semaphore semaforoPF, Semaphore semaforoP, Semaphore racesemaphore) {
        this.hora = hora;
        this.interfaz = interfaz;
        this.jefeM = jefeM;
        this.semaforoJM = semaforoJM;
        this.semaforoE = semaforoE;
        this.semaforoPF = semaforoPF;
        this.semaforoP = semaforoP;
        this.racesemaphore = racesemaphore;

    }

    @Override
    public void run() {
        synchronized (this) {
            do {
                interfaz.getjTextField10().setText("Esperando");

                try {
                    semaforoJM.acquire();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Gerente.class.getName()).log(Level.SEVERE, null, ex);
                }
                interfaz.getjTextField10().setText("Leyendo");
                try {
                    Thread.sleep((long) (this.hora * 0.1 * 1000));
                } catch (InterruptedException ex) {
                    Logger.getLogger(Gerente.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    racesemaphore.acquire();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Gerente.class.getName()).log(Level.SEVERE, null, ex);
                }

                if ((jefeM.getContador() == 0) && (interfaz.getjTextField6().getText() != "0") && jefeM.isPuedeDespachar() == true) {

                    try {
                        semaforoE.acquire();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Gerente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        semaforoPF.acquire();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Gerente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        semaforoP.acquire();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Gerente.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    interfaz.getjTextField6().setText("0");

                    interfaz.getjTextField10().setText("Despachando");
                    try {
                        Thread.sleep((long) (this.hora * 0.0625 * 1000));
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Gerente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    jefeM.setPuedeDespachar(false);
                    semaforoE.release();
                    semaforoPF.release();
                    semaforoP.release();

                }
                racesemaphore.release();
                semaforoJM.release();

                interfaz.getjTextField10().setText("Descansando");
                int rand = (int) (Math.random() * (200 - 45 + 1) + 45);

                try {
                    Thread.sleep(rand * 10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Gerente.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (ejecutando == false) {

                    try {
                        this.wait();

                    } catch (InterruptedException ex) {
                        Logger.getLogger(Gerente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } while (ejecutando);
        }
    }

    public boolean isEjecutando() {
        return ejecutando;
    }

    public void setEjecutando(boolean ejecutando) {
        this.ejecutando = ejecutando;
    }

}

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
public class Mesoneros extends Thread{
    
    private float hora;
    private int ordenes;
    private int cantidadInicial;
    private boolean ejecutando;
    Interfaz interfaz;
    private Semaphore semaforoE;
    private Semaphore semaforoPF;
    private Semaphore semaforoP;
    private Semaphore racesemaphore;
    private Mesones platosentrada;
    private Mesones platosfuertes;
    private Mesones platospostres;
    
    public Mesoneros(Interfaz interfaz,Semaphore semaforoE,Semaphore semaforoPF,Semaphore semaforoP,Semaphore racesemaphore,Mesones platosentrada,Mesones platosfuertes,Mesones platospostres){
        this.hora = (float) 0.15;
        this.ordenes = 0;
        this.cantidadInicial = 0;
        this.ejecutando = false;
        this.interfaz = interfaz;
        this.semaforoE = semaforoE;
        this.semaforoPF = semaforoPF;
        this.semaforoP = semaforoP;
        this.racesemaphore = racesemaphore;
        this.platosentrada = platosentrada;
        this.platosfuertes = platosfuertes;
        this.platospostres = platospostres;
    }
    
    @Override
    public void run(){
         synchronized (this) {
            do {

                if (ejecutando == false) {

                    try {
                        this.wait();

                    } catch (InterruptedException ex) {
                        Logger.getLogger(Mesoneros.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                System.out.println("Buenas noches");
                if ((platosentrada.getPlatosProducidos() > 3) && (platosfuertes.getPlatosProducidos() > 2) && (platospostres.getPlatosProducidos() > 1)) {
                    try {
                        racesemaphore.acquire();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Mesoneros.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        semaforoE.acquire();

                    } catch (InterruptedException ex) {
                        Logger.getLogger(Mesoneros.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        semaforoPF.acquire();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Mesoneros.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        semaforoP.acquire();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Mesoneros.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    for (int i = 0; i < platosentrada.getCapacidad(); i++) {
                        if (platosentrada.getMesones()[i] == 1) {
                            platosentrada.getMesones()[i] = 0;
                            platosentrada.setPlatosProducidos(platosentrada.getPlatosProducidos() - 1);
                            interfaz.getjTextField4().setText(Integer.toString(platosentrada.getPlatosProducidos()));
                            break;
                        }
                    }
                    for (int i = 0; i < platosentrada.getCapacidad(); i++) {
                        if (platosentrada.getMesones()[i] == 1) {
                            platosentrada.getMesones()[i] = 0;
                            platosentrada.setPlatosProducidos(platosentrada.getPlatosProducidos() - 1);
                            interfaz.getjTextField4().setText(Integer.toString(platosentrada.getPlatosProducidos()));
                            break;
                        }
                    }
                    for (int i = 0; i < platosentrada.getCapacidad(); i++) {
                        if (platosentrada.getMesones()[i] == 1) {
                            platosentrada.getMesones()[i] = 0;
                            platosentrada.setPlatosProducidos(platosentrada.getPlatosProducidos() - 1);
                            interfaz.getjTextField4().setText(Integer.toString(platosentrada.getPlatosProducidos()));
                            break;
                        }
                    }

                    for (int i = 0; i < platosfuertes.getCapacidad(); i++) {
                        if (platosfuertes.getMesones()[i] == 1) {
                            platosfuertes.getMesones()[i] = 0;
                            platosfuertes.setPlatosProducidos(platosfuertes.getPlatosProducidos() - 1);
                            interfaz.getjTextField7().setText(Integer.toString(platosfuertes.getPlatosProducidos()));
                            break;
                        }
                    }
                    for (int i = 0; i < platosfuertes.getCapacidad(); i++) {
                        if (platosfuertes.getMesones()[i] == 1) {
                            platosfuertes.getMesones()[i] = 0;
                            platosfuertes.setPlatosProducidos(platosfuertes.getPlatosProducidos() - 1);
                            interfaz.getjTextField7().setText(Integer.toString(platosfuertes.getPlatosProducidos()));
                            break;
                        }
                    }

                    for (int i = 0; i < platospostres.getCapacidad(); i++) {
                        if (platospostres.getMesones()[i] == 1) {
                            platospostres.getMesones()[i] = 0;
                            platospostres.setPlatosProducidos(platospostres.getPlatosProducidos() - 1);
                            interfaz.getjTextField8().setText(Integer.toString(platospostres.getPlatosProducidos()));
                            break;
                        }
                    }

                    semaforoE.release();
                    semaforoPF.release();
                    semaforoP.release();
                    racesemaphore.release();
                    String num = interfaz.getjTextField6().getText();
                    int venta = Integer.parseInt(num);
                    venta = venta + 1;
                    String ordenes = Integer.toString(venta);
                    interfaz.getjTextField6().setText(ordenes);
                }
                try {
                Thread.sleep((long) (hora * 10000));
                } catch (InterruptedException ex) {
                    Logger.getLogger(Mesoneros.class.getName()).log(Level.SEVERE, null, ex);
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

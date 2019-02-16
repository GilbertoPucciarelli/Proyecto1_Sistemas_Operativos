/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import interfaz.Interfaz;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author Gilberto
 */
public class Aplicacion extends Thread {

    private int horas;
    private int capacidadEntradas;
    private int capacidadFuertes;
    private int capacidadPostres;
    private int inicialEntradas;
    private int maximoEntradas;
    private int inicialFuertes;
    private int maximoFuertes;
    private int inicialPostres;
    private int maximoPostres;
    private int inicialMesoneros;
    private int maximoMesoneros;
    private volatile boolean ejecutando;
    int CapacidadEntradas[] = new int[capacidadEntradas];
    int CapacidadFuertes[] = new int[capacidadFuertes];
    int CapacidadPostres[] = new int[capacidadPostres];
    private Mesones mesonesEntradas;
    private Mesones mesonesPlatosFuertes;
    private Mesones mesonesPostres;
    private C_Entradas[] C_Entradas;
    private C_Platos_Fuertes[] C_Platos_Fuertes;
    private C_Postres[] C_Postres;
    private Gerente gerente;
    private Jefe_Mesoneros jefeMesoneros;
    private boolean iniciado;
    Interfaz interfaz;
    private Mesoneros[] Mesoneros;
    private Semaphore semaforoE;
    private Semaphore semaforoPF;
    private Semaphore semaforoP;
    private Semaphore semaforoJM;
    private Semaphore racesemaphore;

    //CONSTRUCTOR
    public Aplicacion(Interfaz interfaz) {
        this.interfaz = interfaz;
        this.ejecutando = false;
        this.semaforoE = new Semaphore(1);
        this.semaforoPF = new Semaphore(1);
        this.semaforoP = new Semaphore(1);
        this.semaforoJM = new Semaphore(1);
        this.racesemaphore = new Semaphore(1);
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getCapacidadEntradas() {
        return capacidadEntradas;
    }

    public void setCapacidadEntradas(int capacidadEntradas) {
        this.capacidadEntradas = capacidadEntradas;
    }

    public int getCapacidadFuertes() {
        return capacidadFuertes;
    }

    public void setCapacidadFuertes(int capacidadFuertes) {
        this.capacidadFuertes = capacidadFuertes;
    }

    public int getCapacidadPostres() {
        return capacidadPostres;
    }

    public void setCapacidadPostres(int capacidadPostres) {
        this.capacidadPostres = capacidadPostres;
    }

    public int getInicialEntradas() {
        return inicialEntradas;
    }

    public void setInicialEntradas(int inicialEntradas) {
        this.inicialEntradas = inicialEntradas;
    }

    public int getMaximoEntradas() {
        return maximoEntradas;
    }

    public void setMaximoEntradas(int maximoEntradas) {
        this.maximoEntradas = maximoEntradas;
    }

    public int getInicialFuertes() {
        return inicialFuertes;
    }

    public void setInicialFuertes(int inicialFuertes) {
        this.inicialFuertes = inicialFuertes;
    }

    public int getMaximoFuertes() {
        return maximoFuertes;
    }

    public void setMaximoFuertes(int maximoFuertes) {
        this.maximoFuertes = maximoFuertes;
    }

    public int getInicialPostres() {
        return inicialPostres;
    }

    public void setInicialPostres(int inicialPostres) {
        this.inicialPostres = inicialPostres;
    }

    public int getMaximoPostres() {
        return maximoPostres;
    }

    public void setMaximoPostres(int maximoPostres) {
        this.maximoPostres = maximoPostres;
    }

    public int getInicialMesoneros() {
        return inicialMesoneros;
    }

    public void setInicialMesoneros(int inicialMesoneros) {
        this.inicialMesoneros = inicialMesoneros;
    }

    public int getMaximoMesoneros() {
        return maximoMesoneros;
    }

    public void setMaximoMesoneros(int maximoMesoneros) {
        this.maximoMesoneros = maximoMesoneros;
    }

    public boolean isEjecutando() {
        return ejecutando;
    }

    public void setEjecutando(boolean ejecutando) {
        this.ejecutando = ejecutando;
    }

    public void setCapacidadEntradas(int[] CapacidadEntradas) {
        this.CapacidadEntradas = CapacidadEntradas;
    }

    public void setCapacidadFuertes(int[] CapacidadFuertes) {
        this.CapacidadFuertes = CapacidadFuertes;
    }

    public void setCapacidadPostres(int[] CapacidadPostres) {
        this.CapacidadPostres = CapacidadPostres;
    }

    public C_Entradas[] getC_Entradas() {
        return C_Entradas;
    }

    public void setC_Entradas(C_Entradas[] C_Entradas) {
        this.C_Entradas = C_Entradas;
    }

    public C_Platos_Fuertes[] getC_Platos_Fuertes() {
        return C_Platos_Fuertes;
    }

    public void setC_Platos_Fuertes(C_Platos_Fuertes[] C_Platos_Fuertes) {
        this.C_Platos_Fuertes = C_Platos_Fuertes;
    }

    public C_Postres[] getC_Postres() {
        return C_Postres;
    }

    public void setC_Postres(C_Postres[] C_Postres) {
        this.C_Postres = C_Postres;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public Jefe_Mesoneros getJefeMesoneros() {
        return jefeMesoneros;
    }

    public void setJefeMesoneros(Jefe_Mesoneros jefeMesoneros) {
        this.jefeMesoneros = jefeMesoneros;
    }

    public boolean isIniciado() {
        return iniciado;
    }

    public void setIniciado(boolean iniciado) {
        this.iniciado = iniciado;
    }

    public Interfaz getInterfaz() {
        return interfaz;
    }

    public void setInterfaz(Interfaz interfaz) {
        this.interfaz = interfaz;
    }

    @Override
    public void run() {
        gerente.start();
        jefeMesoneros.start();

        for (int i = 0; i < maximoEntradas; i++) {
            C_Entradas[i].start();
        }

        for (int i = 0; i < maximoFuertes; i++) {
            C_Platos_Fuertes[i].start();
        }

        for (int i = 0; i < maximoPostres; i++) {
            C_Postres[i].start();
        }

        for (int i = 0; i < maximoMesoneros; i++) {
            Mesoneros[i].start();
        }
        
        synchronized (this) {
            do {
                try {

                    Thread.sleep(horas * 10000);

                } catch (InterruptedException ex) {
                    Logger.getLogger(Aplicacion.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (ejecutando == false) {

                    try {
                        this.wait();

                    } catch (InterruptedException ex) {
                        Logger.getLogger(Aplicacion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            } while (ejecutando);
        }
    }

    //FUNCION PARA EMPEZAR LA SIMULACION
    public void simular() throws InterruptedException {

        if (iniciado) {

            this.setEjecutando(true);
            synchronized (this) {
                notify();
            }
            
            synchronized (gerente) {
                gerente.setEjecutando(true);
                gerente.notify();
            }
            
            synchronized (jefeMesoneros) {
                jefeMesoneros.setEjecutando(true);
                notify();
            }

            for (int i = 0; i < inicialMesoneros; i++) {
                Mesoneros[i].setEjecutando(true);
            }

            for (int i = 0; i < inicialEntradas; i++) {
                C_Entradas[i].setEjecutando(true);
            }

            for (int i = 0; i < inicialFuertes; i++) {
                C_Platos_Fuertes[i].setEjecutando(true);
            }

            for (int i = 0; i < inicialPostres; i++) {
                C_Postres[i].setEjecutando(true);
            }

        } else {

            start();
        }
    }

    //FUNCION PARA CARGAR DATOS DEL .TXT
    public void cargarDatos() throws FileNotFoundException, IOException {

        horas = capacidadEntradas = capacidadFuertes = capacidadPostres = inicialEntradas = maximoEntradas = inicialFuertes = maximoFuertes = inicialPostres = maximoPostres = inicialMesoneros = maximoMesoneros = 0;

        JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int val = fc.showOpenDialog(null);

        File archivo = fc.getSelectedFile();
        FileReader f = new FileReader(archivo.getAbsolutePath());
        BufferedReader b = new BufferedReader(f);
        b.readLine();
        horas = parseInt(b.readLine());
        b.readLine();
        capacidadEntradas = parseInt(b.readLine());
        b.readLine();
        capacidadFuertes = parseInt(b.readLine());
        b.readLine();
        capacidadPostres = parseInt(b.readLine());
        b.readLine();
        inicialEntradas = parseInt(b.readLine());
        b.readLine();
        maximoEntradas = parseInt(b.readLine());
        b.readLine();
        inicialFuertes = parseInt(b.readLine());
        b.readLine();
        maximoFuertes = parseInt(b.readLine());
        b.readLine();
        inicialPostres = parseInt(b.readLine());
        b.readLine();
        maximoPostres = parseInt(b.readLine());
        b.readLine();
        inicialMesoneros = parseInt(b.readLine());
        b.readLine();
        maximoMesoneros = parseInt(b.readLine());
        b.close();

        jefeMesoneros = new Jefe_Mesoneros(interfaz, horas, semaforoJM);
        jefeMesoneros.setEjecutando(true);
        gerente = new Gerente(horas, interfaz, jefeMesoneros, semaforoJM, semaforoE, semaforoPF, semaforoP, racesemaphore);
        gerente.setEjecutando(true);
        C_Entradas = new C_Entradas[maximoEntradas];
        C_Platos_Fuertes = new C_Platos_Fuertes[maximoFuertes];
        C_Postres = new C_Postres[maximoPostres];
        mesonesEntradas = new Mesones(capacidadEntradas);
        mesonesPlatosFuertes = new Mesones(capacidadFuertes);
        mesonesPostres = new Mesones(capacidadPostres);
        Mesoneros = new Mesoneros[maximoMesoneros];


        for (int i = 0; i < maximoMesoneros; i++) {
            Mesoneros[i] = new Mesoneros(interfaz, semaforoE, semaforoPF, semaforoP, racesemaphore, mesonesEntradas, mesonesPlatosFuertes, mesonesPostres);
        }

        for (int i = 0; i < maximoEntradas; i++) {
            C_Entradas[i] = new C_Entradas(interfaz, mesonesEntradas, semaforoE);
        }

        for (int i = 0; i < maximoFuertes; i++) {
            C_Platos_Fuertes[i] = new C_Platos_Fuertes(interfaz, mesonesPlatosFuertes, semaforoPF);
        }

        for (int i = 0; i < maximoPostres; i++) {
            C_Postres[i] = new C_Postres(interfaz, mesonesPostres, semaforoP);
        }

        for (int i = 0; i < inicialMesoneros; i++) {
            Mesoneros[i].setEjecutando(true);
        }

        for (int i = 0; i < inicialEntradas; i++) {
            C_Entradas[i].setEjecutando(true);
        }

        for (int i = 0; i < inicialFuertes; i++) {
            C_Platos_Fuertes[i].setEjecutando(true);
        }

        for (int i = 0; i < inicialPostres; i++) {
            C_Postres[i].setEjecutando(true);
        }
    }
}

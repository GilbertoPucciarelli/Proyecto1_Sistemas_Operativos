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
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
/**
 *
 * @author Gilberto
 */
public class Aplicacion extends Thread{
    
    Interfaz interfaz;
    private boolean ejecutando;
    private int time = 0;
    //Cantidad meson Entrada
    private int cmesonE = 0;
    //Cantidad meson Plato Fuerte
    private int cmesonPF = 0;
    //Cantidad meson Postre
    private int cmesonP = 0;
    //Cantidad inicial Cocineros Entrada
    private int cantICE = 0;
    //Cantidad inicial Cocineros Plato Fuerte
    private int cantICPF = 0;
    //Cantidad inicial Cocineros Postre
    private int cantICP = 0;
    //Cantidad max Cocineros Entrada
    private int cantMCE = 0;
    //Cantidad max Cocineros Plato Fuerte
    private int cantMCPF = 0;
    //Cantidad max Cocineros Postre
    private int cantMCP= 0;
    //Cantidad inicial Mesoneros
    private int cantIM = 0;
    //Cantidad max Mesoneros
    private int cantMM = 0;
    private C_Entradas[] c_entradas;
    private C_Platos_Fuertes c_platos_fuertes;
    private C_Postres c_postres;
    private Mesoneros mesoneros;
    private Jefe_Mesoneros jefe_mesoneros;
    
    public Aplicacion(Interfaz interfaz){
        this.interfaz = interfaz;
        this.ejecutando = false;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getCmesonE() {
        return cmesonE;
    }

    public void setCmesonE(int cmesonE) {
        this.cmesonE = cmesonE;
    }

    public int getCmesonPF() {
        return cmesonPF;
    }

    public void setCmesonPF(int cmesonPF) {
        this.cmesonPF = cmesonPF;
    }

    public int getCmesonP() {
        return cmesonP;
    }

    public void setCmesonP(int cmesonP) {
        this.cmesonP = cmesonP;
    }

    public int getCantICE() {
        return cantICE;
    }

    public void setCantICE(int cantICE) {
        this.cantICE = cantICE;
    }

    public int getCantICPF() {
        return cantICPF;
    }

    public void setCantICPF(int cantICPF) {
        this.cantICPF = cantICPF;
    }

    public int getCantICP() {
        return cantICP;
    }

    public void setCantICP(int cantICP) {
        this.cantICP = cantICP;
    }

    public int getCantMCE() {
        return cantMCE;
    }

    public void setCantMCE(int cantMCE) {
        this.cantMCE = cantMCE;
    }

    public int getCantMCPF() {
        return cantMCPF;
    }

    public void setCantMCPF(int cantMCPF) {
        this.cantMCPF = cantMCPF;
    }

    public int getCantMCP() {
        return cantMCP;
    }

    public void setCantMCP(int cantMCP) {
        this.cantMCP = cantMCP;
    }

    public int getCantIM() {
        return cantIM;
    }

    public void setCantIM(int cantIM) {
        this.cantIM = cantIM;
    }

    public int getCantMM() {
        return cantMM;
    }

    public void setCantMM(int cantMM) {
        this.cantMM = cantMM;
    }
    
    public void cargar() throws FileNotFoundException, IOException {
        
        JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int val = fc.showOpenDialog(null);

        File archivo = fc.getSelectedFile();

        FileReader f = new FileReader(archivo.getAbsolutePath());
        BufferedReader b = new BufferedReader(f);
        b.readLine();
        time = parseInt(b.readLine());
        b.readLine();
        cmesonE = parseInt(b.readLine());
        b.readLine();
        cmesonPF = parseInt(b.readLine());
        b.readLine();
        cmesonP = parseInt(b.readLine());
        b.readLine();
        cantICE = parseInt(b.readLine());
        b.readLine();
        cantICPF = parseInt(b.readLine());
        b.readLine();
        cantICP = parseInt(b.readLine());
        b.readLine();
        cantMCE = parseInt(b.readLine());
        b.readLine();
        cantMCPF = parseInt(b.readLine());
        b.readLine();
        cantMCP = parseInt(b.readLine());
        b.readLine();
        cantIM = parseInt(b.readLine());
        b.readLine();
        cantMM = parseInt(b.readLine());
    }
    
    @Override
    public void run(){
        
    }
    
    public void simular() throws InterruptedException{
        
    }
}

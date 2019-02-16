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
public abstract class Cocineros extends Thread {

    protected float hora;
    protected int mesones;
    protected int cantidadInicial;
    protected volatile boolean ejecutando;
    Interfaz interfaz;
}

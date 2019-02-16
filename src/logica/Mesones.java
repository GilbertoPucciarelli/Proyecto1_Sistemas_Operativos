/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Gilberto
 */
public class Mesones {

    private int mesones[];
    private int capacidad;
    private int platosProducidos;

    public Mesones(int capacidad) {

        this.capacidad = capacidad;
        mesones = new int[capacidad];
    }

    public int[] getMesones() {
        return mesones;
    }

    public void setMesones(int[] mesones) {
        this.mesones = mesones;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getPlatosProducidos() {

        platosProducidos = 0;

        for (int i = 0; i < capacidad; i++) {

            if (mesones[i] == 1) {

                platosProducidos++;
            }
        }

        return platosProducidos;
    }

    public void setPlatosProducidos(int platosProducidos) {
        this.platosProducidos = platosProducidos;
    }

}

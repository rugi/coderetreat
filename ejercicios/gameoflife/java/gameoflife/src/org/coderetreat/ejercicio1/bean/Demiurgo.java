/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.coderetreat.ejercicio1.bean;

import java.util.logging.Level;  
import java.util.logging.Logger;

/**
 * Clase con mètodos requeridos para unir, una realidad con un juego de la vida.
 * @author rugi,misaelpc
 */
public class Demiurgo implements IPangeable {

    public static byte GENESIS_GLIDER = 11;
    
    /**
     * * Genera un universo con el tamaño indicado, 
     * y con celulas vivas en posiciones aleatorias
     * 
     * @param size Tamaño del universo.
     * @return 
     */
    public Cell[][] generatePangea(byte size) {
        return generatePangea(size, (byte) -1);
    }

    /**
     * Genera un universo con el tamaño indicado, y con el genesis indicado
     * @param size Tamaño del universo
     * @param init Genesis, ver valores disponibles.
     * @return 
     */
    public Cell[][] generatePangea(byte size, byte init) {
        Cell[][] matriz = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Cell c = new Cell();
                c.setX((byte) i);
                c.setY((byte) j);
                c.setStatus(init == -1 ? (Math.round((Math.random()) % 2) == 0 ? true : false) : false);
                matriz[i][j] = c;
                c.setUniverso(matriz);
            }
        }
        //Iniciamos segun el genesis sugerido.
        if(init==Demiurgo.GENESIS_GLIDER){
            int xC = Math.round(size/2);
            int yC = Math.round(size/2);
            matriz[xC-1][yC].setStatus(true);
            matriz[xC][yC+1].setStatus(true);
            matriz[xC+1][yC-1].setStatus(true);
            matriz[xC+1][yC].setStatus(true);
            matriz[xC+1][yC+1].setStatus(true);
        }
        return matriz;
    }

    @Override
    public void delay(int size) {
        try {
            Thread.sleep(size);
        } catch (InterruptedException ex) {
            Logger.getLogger(Demiurgo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Cell[][] cataclysm(Cell[][] pasado) {
        Cell[][] nuevo = new Cell[pasado.length][pasado.length];
        
        //preparamos al presente
        for (int i = 0; i < pasado.length; i++) {
            for (int j = 0; j < pasado.length; j++) {
                nuevo[i][j] = new Cell();
                nuevo[i][j].setX((byte) i);
                nuevo[i][j].setY((byte) j);
            }
        }


        //Actualizamos el presente en funcion del pasado.
        for (int i = 0; i < pasado.length; i++) {
            for (int j = 0; j < pasado.length; j++) {
                nuevo[i][j].setStatus(pasado[i][j].isAlive());
                nuevo[i][j].setUniverso(nuevo);
            }

        }
        //Matamos al pasado......no debe seguirnos;
        for (int i = 0; i < pasado.length; i++) {
            for (int j = 0; j < pasado.length; j++) {
                    pasado[i][j] = null;
            }

        }        
        return nuevo;
    }//
}

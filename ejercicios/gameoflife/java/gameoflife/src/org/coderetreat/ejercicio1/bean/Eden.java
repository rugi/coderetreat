/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.coderetreat.ejercicio1.bean;

import org.coderetreat.ejercicio1.ui.Reality;

/**
 * El sàbado 25 de Agosto en la ciudad de MX se realizò el 1er CodeRetreat
 * organizado por: Knowtion, tidySlide y SinergyJ.
 * El ejercicio seleccionado para este evento, no pudo ser otro:
 * El juego de la vida de John Conway (Cambridge)
 * 
 * Aqui la implementación que quedo inconclusa ese día.
 * La propuesta es resultado del un diseño propuesto junto con @misaelpc
 * 
 * @author rugi
 */
public class Eden {

    public static final byte SIZE_UNIVERSE = 66;
    public static final int HAPPY_TIME = 100;

    public static void main(String[] args) throws InterruptedException {
        //Requerimos una realidad para poder visualizar lo que ocurra
        Reality realidad = new Reality(SIZE_UNIVERSE);
        //iniciams la realidad
        realidad.init();
        // Requerimos un $DEITY creador
        Demiurgo ourobouros = new Demiurgo();
        //El demiurgo genera la 1a realidad
        Cell[][] matrizInicial = ourobouros.generatePangea(SIZE_UNIVERSE, Demiurgo.GENESIS_GLIDER);
        do {
            //mostramos ese mundo a través de nuestra realidad
            realidad.muestra(matrizInicial);
            // Damos unos segundos de felicidad
            ourobouros.delay(HAPPY_TIME);
            // Y ocurre un cataclismo
            matrizInicial = ourobouros.cataclysm(matrizInicial);            
        } while (true);
    }
}

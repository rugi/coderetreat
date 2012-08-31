/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.coderetreat.ejercicio1.ui;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import org.coderetreat.ejercicio1.bean.Cell;

/**
 *
 * @author rugi,misaelpc
 */
public class Reality extends JFrame implements IPintable {

    private static final byte SIZE_DEFAULT = 5;
    private JLabel[][] cells;
    private GridLayout layout;
    private byte size;    
    private static final Color COLOR_BACK = Color.BLACK;
    private static final Color COLOR_FRONT = Color.GREEN;

    public Reality() {
        new Reality(SIZE_DEFAULT);
    }

    /**
     * Genera una realidad del tamaño adecuado.
     * Se requiere una realidad para poder mostrar en ella
     * el juego de la vida.
     * @param size  Tamaño de la realidad
     */
    public Reality(byte size) {
        super();
        this.size = size;
        cells = new JLabel[size][size];
        layout = new GridLayout(0, size);        
    }

    /**
     * Recibe una matriz con las celulas, evalua cada celula y
     * genera una nueva matriz con las celulas en un estado
     * derivado de la evaluaciòn de las reglas del juego.
     * @param vida 
     */
    public void muestra(Cell[][] vida) {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < vida.length; j++) {
                cells[i][j].setOpaque(vida[i][j].isStatus());
                cells[i][j].setText(vida[i][j].isStatus() ? "*" : " ");
            }
        }
    }

    @Override
    public void init() {
        //iniciar los JLabel
        this.getContentPane().setLayout(layout);
        //colocarlo
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                cells[i][j] = new JLabel("*");                
                cells[i][j].setForeground(COLOR_BACK);
                cells[i][j].setBackground(COLOR_FRONT);                
                this.add(cells[i][j]);
            }
        }
        //Pintarlos
        this.setForeground(COLOR_BACK);
        this.getContentPane().setBackground(COLOR_BACK);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // mostrar la ventana
        this.pack();
        this.setVisible(true);
        this.setSize(400,400);              
    }
}

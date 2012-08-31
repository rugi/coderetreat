/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.coderetreat.ejercicio1.bean;

/**
 *
 * @author rugi,misaelpc
 */
public interface IPangeable {
       Cell[][] generatePangea(byte size);       
       void delay(int size);
       Cell[][] cataclysm(Cell[][] pasado);
}

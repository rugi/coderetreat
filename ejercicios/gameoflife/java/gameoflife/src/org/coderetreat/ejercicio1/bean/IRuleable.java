/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.coderetreat.ejercicio1.bean;

/**
 *
 * @author rugi
 */
public interface IRuleable {
    boolean isAlive();
    Cell[] getNeighbors();
    boolean evaluateRules();
}

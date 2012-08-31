/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.coderetreat.ejercicio1.bean;

/**
 *
 * @author rugi,misaelpc
 */
public class Cell implements IRuleable {

    private byte x;
    private byte y;
    Cell[][] universo;
    private byte posicion;
    private boolean status;

    public Cell() {
        super();
    }

    public void setUniverso(Cell[][] universo) {
        this.universo = universo;
    }

    /**
     * @return the posicion
     */
    public byte getPosicion() {
        return posicion;
    }

    /**
     * @param posicion the posicion to set
     */
    public void setPosicion(byte posicion) {
        this.posicion = posicion;
    }

    public boolean evaluaEstado() {
        return false;
    }

    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isAlive() {                
        return evaluateRules();
    }

    /**
     * @return the x
     */
    public byte getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(byte x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public byte getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(byte y) {
        this.y = y;
    }

    public String toString() {
        return "x=" + x + ", y=" + y;
    }

    /**
     * TODO FALTA
     *
     * @return
     */
    @Override
    public Cell[] getNeighbors() {
        Cell[] neighborhgs = new Cell[8];
        neighborhgs[0] = this.getNorth();
        neighborhgs[1] = this.getSouth();
        neighborhgs[2] = this.getEast();
        neighborhgs[3] = this.getWest();
        neighborhgs[4] = this.getNorthEast();
        neighborhgs[5] = this.getNorthWest();
        neighborhgs[6] = this.getSouthEast();
        neighborhgs[7] = this.getSouthWest();
        return neighborhgs;
    }

    /**
     * TODO Mejorar evaluacion de reglas.
     *
     * @return
     */
    @Override
    public boolean evaluateRules() {
        Cell[] neighborhgs = getNeighbors();
        boolean res = false;
        //TODO Mejorar implementacion:
        int enviroment = countLife(neighborhgs);
        if (this.isStatus()) {
            if (enviroment <= 1) {
                res = false;
            }
            if (enviroment >= 4) {
                res = false;
            }
            if (enviroment == 2 || enviroment == 3) {
                res = true;
            }
        } else {
            if (enviroment == 3) {
                res = true;
            }
        }
        return res;
    }

    private int countLife(Cell[] neighborhgs) {
        int res = 0;
        for (int i = 0; i < neighborhgs.length; i++) {
            res += neighborhgs[i].isStatus() ? 1 : 0;
        }
        return res;
    }

    private Cell getNorth() {

        return universo[valid(this.x - 1)][valid(this.y)];
    }

    private Cell getSouth() {
        return universo[valid(this.x + 1)][valid(this.y)];
    }

    private Cell getEast() {
        return universo[valid(this.x)][valid(this.y + 1)];
    }

    private Cell getWest() {
        return universo[valid(this.x)][valid(this.y - 1)];
    }

    private Cell getNorthEast() {
        return universo[valid(this.x - 1)][valid(this.y + 1)];
    }

    private Cell getNorthWest() {
        return universo[valid(this.x - 1)][valid(this.y - 1)];
    }

    private Cell getSouthEast() {
        return universo[valid(this.x + 1)][valid(this.y + 1)];
    }

    private Cell getSouthWest() {
        return universo[valid(this.x + 1)][valid(this.y - 1)];
    }

    public int valid(int v) {
        int res = v;
        if (v == -1) {
            res = (this.universo.length-1);
        } else {
            if (v == this.universo.length) {
                res = 0;
            }
        }
        return res;
    }
    
    public int getSizeUniverso(){   
        return this.universo==null?-1:this.universo.length;        
    }
    
    public void finalize() throws Throwable{
        super.finalize();        
    } 
}

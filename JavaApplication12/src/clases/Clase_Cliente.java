/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clases;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public abstract class Clase_Cliente {

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip the ip to set
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the clintes
     */
    public String getClintes() {
        return clintes;
    }

    /**
     * @param clintes the clintes to set
     */
    public void setClintes(String clintes) {
        this.clintes = clintes;
    }

    /**
     * @return the esatdo
     */
    public int getEsatdo() {
        return esatdo;
    }

    /**
     * @param esatdo the esatdo to set
     */
    public void setEsatdo(int esatdo) {
        this.esatdo = esatdo;
    }

   
    private String nombre;
    private String ip;
    private String id;
    private String clintes;
    private int esatdo;
    private String color;
    

}

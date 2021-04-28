/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prg4;

import java.io.Serializable;

/**
 *
 * @author win
 */
public class Archivo implements Serializable{
    static final long serialVersionUID=55L;
    private String nombreArchivo;
    private double tamanoArchivo;
    
   public void mostrar(){
       System.out.println("Nombre del Archivo: "+this.nombreArchivo);
       System.out.println("Tamaño del Archivo: "+this.tamanoArchivo);
       System.out.println("=========================");
   }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public double getTamanoArchivo() {
        return tamanoArchivo;
    }

    public void setTamanoArchivo(double tamanoArchivo) {
        this.tamanoArchivo = tamanoArchivo;
    }
   
   
}

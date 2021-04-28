/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prg2;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author win
 */
public class cancion implements Serializable{
    static final long serialVersionUID=49L;
    private String nombreCancion;
    private float duracion;
    private String genero;
    
   transient Scanner leer=new Scanner(System.in);
    
    
    public void mostrar(){
        System.out.println("Nombre de Cancion: "+this.nombreCancion);
        System.out.println("Duracion: "+this.duracion);
        System.out.println("Genero: "+this.genero);
        System.out.println("===============================");
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    
    
    
}

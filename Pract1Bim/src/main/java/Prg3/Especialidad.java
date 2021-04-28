/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prg3;

import java.io.Serializable;

/**
 *
 * @author win
 */
public class Especialidad implements Serializable{
    static final long serialVersionUID=50L;
     private String nomEspecialidad;
    
    
    public void mostrarEs(){
        System.out.println("==Especialidades==");
        System.out.println("Especialidad: "+this.nomEspecialidad);
    }

    public String getNomEspecialidad() {
        return nomEspecialidad;
    }

    public void setNomEspecialidad(String nomEspecialidad) {
        this.nomEspecialidad = nomEspecialidad;
    }
    
    
}



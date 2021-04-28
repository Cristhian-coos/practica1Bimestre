/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prg1;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author win
 */
public class Materia implements Serializable {
    static final long serialVersionUID=42L;
            
    private String nombreMateria;
    private int anoMateria;
    private int horaMateria;
    
    transient Scanner leer=new Scanner(System.in);
    
    public void mostrarMateria(){
        System.out.println("Materia: "+this.nombreMateria);
        System.out.println("Año: "+this.anoMateria);
        System.out.println("Hora: "+this.horaMateria);
        //System.out.println("========================");
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public int getAnoMateria() {
        return anoMateria;
    }

    public void setAnoMateria(int anoMateria) {
        this.anoMateria = anoMateria;
    }

    public int getHoraMateria() {
        return horaMateria;
    }

    public void setHoraMateria(int horaMateria) {
        this.horaMateria = horaMateria;
    }
    
    

    
    
}

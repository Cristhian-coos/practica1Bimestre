/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prg4;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author win
 */
public class DispositivoAlmacenamiento implements Serializable{
    static final long serialVersionUID=53L;
    private String marca;
    private double capacidad;
    private double espacioDisponible;
    
  transient Scanner leer=new Scanner(System.in);
    
    public void llenar(){
        System.out.println("Ingrese la Marca. ");
        this.marca=leer.nextLine();
        System.out.println("Ingrese la capacidad");
        this.capacidad=leer.nextDouble();
        System.out.println("Ingrese el espacio disponible");
        this.espacioDisponible=leer.nextDouble();
    }
    public void mostrar(){
        System.out.println("Marca: "+this.marca);
        System.out.println("Capacidad: "+this.capacidad);
        System.out.println("Espacio Disponible: "+this.espacioDisponible);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(double capacidad) {
        this.capacidad = capacidad;
    }

    public double getEspacioDisponible() {
        return espacioDisponible;
    }

    public void setEspacioDisponible(double espacioDisponible) {
        this.espacioDisponible = espacioDisponible;
    }
    
    
}

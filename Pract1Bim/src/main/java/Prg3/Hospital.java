/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prg3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author win
 */
public class Hospital implements Serializable{
     static final long serialVersionUID=51L;
    private String nombre;
    private String direccion;
    private int nivel;
    
    private List<Especialidad> listaEsp;

    public Hospital() {
        listaEsp=new ArrayList<>();
    }
    
    public void adicionarEsp(Especialidad esp){
        listaEsp.add(esp);
        System.out.println("Asignacion Realizada");
    }
    
    
    public void mostrar(){
        System.out.println("Nombre: "+this.nombre);
        System.out.println("Direccion: "+this.direccion);
        System.out.println("Nivel: "+this.nivel);
        if(listaEsp.size()>0){
            for(Especialidad esp: listaEsp){
                esp.mostrarEs();
            }
        }
        else{
            System.out.println("No tiene ninguna espcialidad");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public List<Especialidad> getListaEsp() {
        return listaEsp;
    }

    public void setListaEsp(List<Especialidad> listaEsp) {
        this.listaEsp = listaEsp;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prg2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author win
 */
public class albun implements Serializable{
     static final long serialVersionUID=47L;
    private String nombre;
    private String artista;
    private String formato;
    
    private List <cancion> listaCancion;

    public albun() {
        listaCancion=new ArrayList<>();
    }
    
   transient Scanner leer=new Scanner(System.in);
   
   public void mosrtrar(){
       System.out.println("========Albun=========");
       System.out.println("Nombre del Albun:"+this.nombre);
       System.out.println("Artista: "+this.artista);
       System.out.println("Formato: "+this.formato);
       if(listaCancion.size()>0){
           System.out.println("====Lista de Canciones====");
        for(cancion can:listaCancion){
           can.mostrar();
        }
       }
   }
   
   public void adicionarCancion(cancion can){
       listaCancion.add(can);
       System.out.println("-----Cancion Agregada-----");
   }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public List<cancion> getListaCancion() {
        return listaCancion;
    }

    public void setListaCancion(List<cancion> listaCancion) {
        this.listaCancion = listaCancion;
    }
   
   
}

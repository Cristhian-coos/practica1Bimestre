/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prg1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author win
 */
public class Docente implements Serializable{
    
    static final long serialVersionUID=43L;
     
    private String nombre;
    private String paterno;
    private String materno;
    private String titulo;
    private int cargaHoraria;
    
    private int cargaHorActual;
    
    private List <Materia> listaMateria;

    public Docente() {
        listaMateria=new ArrayList<>();
        
    }
   transient Scanner leer=new Scanner(System.in);
    
    public void adicionMateria(Materia mat){
        listaMateria.add(mat);
        System.out.println("======Materia adicionada========");  
    }
    
    public void mostrarDoc(){
        System.out.println("========Docentes==========0");
        System.out.println("Nombre: "+this.nombre+" "+this.paterno+" "+this.materno);
        System.out.println("Titulo: "+this.titulo);
        System.out.println("Carga Horaria: "+this.cargaHoraria);
        if(listaMateria.size()>0){
            System.out.println("=====lista de Materias====");
            for(Materia mat: listaMateria){
                mat.mostrarMateria(); 
                System.out.println("====================");
            }
        }
        else{
            System.out.println("!!No tiene Materia asignada¡¡¡¡");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getCargaHorActual() {
        return cargaHorActual;
    }

    public void setCargaHorActual(int cargaHorActual) {
        this.cargaHorActual = cargaHorActual;
    }

    public List<Materia> getListaMateria() {
        return listaMateria;
    }

    public void setListaMateria(List<Materia> listaMateria) {
        this.listaMateria = listaMateria;
    }

    

    
    
    
}

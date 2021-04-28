/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prg4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author win
 */
public class DiscoDuro extends DispositivoAlmacenamiento implements Serializable{
    static final long serialVersionUID=54L;
    private String tipoInterfaz;
    
    private List <Archivo> listaArchivo;

    public DiscoDuro() {
        listaArchivo=new ArrayList<>();
    }
    
    transient Scanner leer=new Scanner(System.in);
    @Override
    public void llenar(){
        super.llenar();
        System.out.println("Ingrese el tipo de Interfaz");
        this.tipoInterfaz=leer.nextLine();
    }
    @Override
    public void mostrar(){
        super.mostrar();
        System.out.println("Tipo de Interfaz: "+this.tipoInterfaz);
        if(listaArchivo.size()>0){
            System.out.println("======Archivos========");
            for(Archivo arc:listaArchivo){
                arc.mostrar();
            }
        }else{
            System.out.println("nNo tiene Archivo");
        }
    }
    public void AdicionaArch(Archivo arch){
        listaArchivo.add(arch);
        System.out.println("Archivo registrado");
    }

    public String getTipoInterfaz() {
        return tipoInterfaz;
    }

    public void setTipoInterfaz(String tipoInterfaz) {
        this.tipoInterfaz = tipoInterfaz;
    }

    public List<Archivo> getListaArchivo() {
        return listaArchivo;
    }

    public void setListaArchivo(List<Archivo> listaArchivo) {
        this.listaArchivo = listaArchivo;
    }
    
    
}

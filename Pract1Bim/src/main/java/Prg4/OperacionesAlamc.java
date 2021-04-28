/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prg4;

import Prg1.Docente;
import Prg1.OpercaionesDocMat;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author win
 */
public class OperacionesAlamc {
    private Archivo arch;
    private DiscoDuro disc;
    
    private List<DiscoDuro> listaDisco;

    public OperacionesAlamc() {
        listaDisco=new ArrayList<>();
    }
    
    Scanner leer=new Scanner(System.in);
    
    public void crearDisc(){
     
        disc=new DiscoDuro();
        disc.llenar();
        System.out.println("Desea regitrar Un archivo s/n");
        String op=leer.nextLine();
        while(op.equalsIgnoreCase("s")){
            
            arch=new Archivo();
            System.out.println("Ingrese nombre del archivo");
            arch.setNombreArchivo(leer.nextLine());
            System.out.println("Ingrese el tamaño del archivo");
            arch.setTamanoArchivo(leer.nextDouble());
            disc.setEspacioDisponible(disc.getEspacioDisponible()-arch.getTamanoArchivo());
            if(disc.getEspacioDisponible()>=0){
                 disc.AdicionaArch(arch);
            }else{
                System.out.println("espacio insuficiente");
                disc.setEspacioDisponible(disc.getEspacioDisponible()+arch.getTamanoArchivo());
            } 
            System.out.println("Desea regitrar Otro archivo s/n");
            op=leer.nextLine();
            
        }
        listaDisco.add(disc);
    }
    
    public void mostrarDisc(){
        if(listaDisco.size()>0){
            for(DiscoDuro disco:listaDisco){
                disco.mostrar();
            }
        }
    }
    public void listArchivo(){
        int sw=0;
        if(listaDisco.size()>0){
            System.out.println("ingrese la Marca");
            String mar=leer.nextLine();
            for(DiscoDuro disc:listaDisco){
                if(disc.getMarca().equalsIgnoreCase(mar)){
                    disc.mostrar();
                    sw=1;
                }
            }
        }else{
            System.out.println("No existe ningun Disco");
        }
        if(sw==0){
            System.out.println("disco duro no encontrado");
        }
    }
    
    public void eliminarArchi(){
            int sw=0;
        if(listaDisco.size()>0){
            System.out.println("ingrese el nombre del archivo");
            String nom=leer.nextLine();
            for(DiscoDuro dis:listaDisco){
                for(Archivo arc:dis.getListaArchivo()){
                     if(arc.getNombreArchivo().equalsIgnoreCase(nom)){
                    dis.setEspacioDisponible(dis.getEspacioDisponible()+arc.getTamanoArchivo());
                    dis.getListaArchivo().remove(nom);
                    sw=1;
                }
                }
               
            }
        }else{
            System.out.println("No existe ningun Disco");
        }
        if(sw==0){
            System.out.println("disco duro no encontrado");
        }
    }
    
     
   ///CREAMOS ARCHIBO
      public void crearArchivo(){
        Path path=Paths.get("E:\\programacionIII\\Pract1B\\archivoDispositivo.txt");
        try {
            if(!Files.exists(path)){
                Files.createFile(path);
                System.out.println("El archivo se creo correctamente");
            }else{
                System.out.println("El archivo ya existe");
            }
        } catch (Exception e) {
        }
    }
    //guardando la listacliente dentro del archivo creado con anterioridad
    public void guardarObjetos(){
        String ruta="E:\\programacionIII\\Pract1B\\archivoDispositivo.txt";
        //if(listaDoc.size()>0){
            try {
                
            FileOutputStream archivos=new FileOutputStream(ruta);  
            ObjectOutputStream ooss=new ObjectOutputStream(archivos);
            ooss.writeObject(listaDisco); 
            ooss.close();
            archivos.close();
           
        } catch (FileNotFoundException exe) {
            Logger.getLogger(OperacionesAlamc.class.getName()).log(Level.SEVERE, null, exe);
        }catch(IOException exe){
            Logger.getLogger(OperacionesAlamc.class.getName()).log(Level.SEVERE, null, exe);
            
        }
            
       // }else{
         //   System.out.println("lista vacia");
       // }
        
    }
    //cargamos los datos del archivo a un list<Cliente>
    public void leerDiscoDuro(){
        String ruta="E:\\programacionIII\\Pract1B\\archivoDispositivo.txt";
        try {
            FileInputStream archivo=new FileInputStream(ruta);
            ObjectInputStream ois=new ObjectInputStream(archivo);
            if(ois!=null){
                listaDisco=(List<DiscoDuro>)ois.readObject();
            }else{
                System.out.println("El objeto es nulo");
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(OperacionesAlamc.class.getName()).log(Level.SEVERE, null, e);
        }catch(IOException ex){
             Logger.getLogger(OperacionesAlamc.class.getName()).log(Level.SEVERE, null, ex);
        }catch(ClassNotFoundException ex){
             Logger.getLogger(OperacionesAlamc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prg2;

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
public class OperacionesAlbCan {
    private albun alb;
    private cancion can;
    
    private List <albun> listaAlbun;

    public OperacionesAlbCan() {
        listaAlbun=new ArrayList<>();
    }
    Scanner leer = new Scanner(System.in);
    
    public void crearAlbun(){
        alb=new albun();
        System.out.println("Ingrese el Nombre del Albun");
        alb.setNombre(leer.nextLine());
        System.out.println("Ingrese el Nombre del Artista");
        alb.setArtista(leer.nextLine());
        System.out.println("Ingrese el formato");
        alb.setFormato(leer.nextLine());
        System.out.println("Desea Agregar Una cancion s/n");
        String opc;
        opc=leer.nextLine();
        while(opc.equalsIgnoreCase("s")){
            can=new cancion();
            System.out.println("Ingrese el Nombre de la Cancion");
            can.setNombreCancion(leer.nextLine());
            System.out.println("Ingrese la Duracion");
            can.setDuracion(leer.nextInt());
            leer.nextLine();
            System.out.println("Ingrese el Genero");
            can.setGenero(leer.nextLine());
            alb.adicionarCancion(can);
            System.out.println("Desea Agregar Una cancion s/n");
            opc=leer.nextLine();
        }
        listaAlbun.add(alb);
    }
    
    public void mostrarAlbun(){
        if(listaAlbun.size()>0){
            for(albun al:listaAlbun){
                al.mosrtrar();
            }
            
        }else{
            System.out.println("No se tiene ningun Albun");
        }
        
    }
    
    public void buscarCan(){
        int sw=0;
        
        if(listaAlbun.size()>0){
            System.out.println("Ingrese el Nombre de la Cancion ");
            String nom=leer.nextLine();
            for(albun albu:listaAlbun){
                for(cancion canci:albu.getListaCancion()){
                   if(nom.equalsIgnoreCase(canci.getNombreCancion())){
                       System.out.println("-------Cancion Encontrada------");
                       System.out.println("Nombre del Albun:"+albu.getNombre());
                       System.out.println("Artista: "+albu.getArtista());
                       sw=1;
                   }
                }
            }
        }else{
            System.out.println("!!No se tiene ningun Albun¡¡");
        }
        if(sw==0){
            System.out.println("¡¡¡Cancion no Encontrada!!");
        }
     
    }
    
    public void mostrarCanc(){
        int sw=0;
        if(listaAlbun.size()>0){
          System.out.println("Ingrese El Nombre del Albun");
          String nom=leer.nextLine();
          for(albun albn:listaAlbun){
              if(albn.getNombre().equalsIgnoreCase(nom)){
                  sw=1;
                  if(albn.getListaCancion().size()>0){
                      System.out.println("========Lista de Canciones=====0");
                      for(cancion canci:albn.getListaCancion()){
                          canci.mostrar();
                      }
                  }else{
                      System.out.println("lista de Canciones Vacia");
                  }
              }
          }
        }else{
             System.out.println("!!No se tiene ningun Albun¡¡");
        }
       if(sw==0){
            System.out.println("¡¡¡Albun no Encontrada!!");
        }
    }
    
    public void eliminarAlbun(){
        int sw=0,j=0;
        if(listaAlbun.size()>0){
            System.out.println("Ingrese El Nombre del Albun");
            String nom=leer.nextLine();
            for(albun albn:listaAlbun){
                if(albn.getNombre().equalsIgnoreCase(nom)){
                    listaAlbun.remove(albn);
                    System.out.println("========Albun Eliminado======");
                    System.out.println("");
                    sw=1;
                }
            }
        }else{
             System.out.println("!!No se tiene ningun Albun¡¡");
        }
        if(sw==0){
            System.out.println("¡¡¡Albun no Encontrada!!");
        }
    }
    
    
    ///CREAMOS ARCHIBO
      public void crearArchivo(){
        Path path=Paths.get("E:\\programacionIII\\Pract1B\\archivoAlbun.txt");
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
        String ruta="E:\\programacionIII\\Pract1B\\archivoAlbun.txt";
        //if(listaDoc.size()>0){
            try {
                
            FileOutputStream archivos=new FileOutputStream(ruta);  
            ObjectOutputStream ooss=new ObjectOutputStream(archivos);
            ooss.writeObject(listaAlbun); 
            ooss.close();
            archivos.close();
           
        } catch (FileNotFoundException exe) {
            Logger.getLogger(OperacionesAlbCan.class.getName()).log(Level.SEVERE, null, exe);
        }catch(IOException exe){
            Logger.getLogger(OperacionesAlbCan.class.getName()).log(Level.SEVERE, null, exe);
            
        }
            
       // }else{
         //   System.out.println("lista vacia");
       // }
        
    }
    //cargamos los datos del archivo a un list<Cliente>
    public void leerAlbun(){
        String ruta="E:\\programacionIII\\Pract1B\\archivoAlbun.txt";
        try {
            FileInputStream archivo=new FileInputStream(ruta);
            ObjectInputStream ois=new ObjectInputStream(archivo);
            if(ois!=null){
                listaAlbun=(List<albun>)ois.readObject();
            }else{
                System.out.println("El objeto es nulo");
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(OperacionesAlbCan.class.getName()).log(Level.SEVERE, null, e);
        }catch(IOException ex){
             Logger.getLogger(OperacionesAlbCan.class.getName()).log(Level.SEVERE, null, ex);
        }catch(ClassNotFoundException ex){
             Logger.getLogger(OperacionesAlbCan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
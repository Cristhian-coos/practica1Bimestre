/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prg3;

import Prg2.OperacionesAlbCan;
import Prg2.albun;
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
public class OperHospEsp {
    private List<Hospital> listahospital;
    private Hospital hospital;
    private Especialidad especialidad;

    public OperHospEsp() {
        listahospital=new ArrayList<>();
    }
    
    
    Scanner leer=new Scanner(System.in);
    
    public void crearHos(){
       hospital=new Hospital();
        System.out.println("Ingrese el Nombre ");
        hospital.setNombre(leer.nextLine());
        System.out.println("Ingrese la Direccion");
        hospital.setDireccion(leer.nextLine());
        System.out.println("Ingrese el Nivel");
        hospital.setNivel(leer.nextInt());
        System.out.println("==REGISTRADO===");
        leer.nextLine();
        listahospital.add(hospital);
    }
    public void crearEsp(){
        especialidad=new Especialidad();
        System.out.println("Ingrese la especialidad");
        especialidad.setNomEspecialidad(leer.nextLine());
        System.out.println("==Especialidad Creada===");
       
        
    }
    
    public void asignarEspe(){
        int sw=0;
        //especialidad=new Especialidad();
        if(listahospital.size()>0){
            if(especialidad!=null){
            System.out.println("Ingrese el Hospital a Asignrle");
            String h=leer.nextLine();
            for(Hospital hos:listahospital){
                if(hos.getNombre().equalsIgnoreCase(h)){
                    hos.adicionarEsp(especialidad);
                    sw=1;
                    System.out.println("==Asignada==");
                }
            }
            if(sw==0){
                System.out.println("!!hospital No existente¡¡");
                System.out.println("!!No se puede asignar¡¡");
            }
        }
            else{
                System.out.println("!!Especialidad no definida¡¡");
                especialidad=null;
            }
        }
        else{
            System.out.println("!!No existe ningun Hospital¡¡");
        }
     
    }
    public void  mostrarEs(){
        System.out.println("ingrese el nombre del hospital");
        String hosp=leer.nextLine();
        int sw=0;
        for(Hospital h:listahospital){
            if(h.getNombre().equalsIgnoreCase(hosp)){
                for(Especialidad e:hospital.getListaEsp()){
                    e.mostrarEs();
                    sw=1;
                }
            }
        }
        if(sw==0){
            System.out.println("No existe el Hospital");
        }
    }
    
    public void listHosp(){
        System.out.println("ingrese el nombre dela especialidad");
        String esp=leer.nextLine();
        int sw=0;
        System.out.println("===los Hospitales son:===");
        for(Hospital h:listahospital){
                for(Especialidad e:h.getListaEsp()){
                    if(e.getNomEspecialidad().equalsIgnoreCase(esp)){
                        h.mostrar();
                        System.out.println("=============");
                        sw=1;
                    }
                }
        }
        if(sw==0){
            System.out.println("No existe la Especialidad");
        }
    }
    
      
    ///CREAMOS ARCHIBO
      public void crearArchivo(){
        Path path=Paths.get("E:\\programacionIII\\Pract1B\\archivoHospital.txt");
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
        String ruta="E:\\programacionIII\\Pract1B\\archivoHospital.txt";
        //if(listaDoc.size()>0){
            try {
                
            FileOutputStream archivos=new FileOutputStream(ruta);  
            ObjectOutputStream ooss=new ObjectOutputStream(archivos);
            ooss.writeObject(listahospital); 
            ooss.close();
            archivos.close();
           
        } catch (FileNotFoundException exe) {
            Logger.getLogger(OperHospEsp.class.getName()).log(Level.SEVERE, null, exe);
        }catch(IOException exe){
            Logger.getLogger(OperHospEsp.class.getName()).log(Level.SEVERE, null, exe);
            
        }
            
       // }else{
         //   System.out.println("lista vacia");
       // }
        
    }
    //cargamos los datos del archivo a un list<Cliente>
    public void leerHospital(){
        String ruta="E:\\programacionIII\\Pract1B\\archivoAlbun.txt";
        try {
            FileInputStream archivo=new FileInputStream(ruta);
            ObjectInputStream ois=new ObjectInputStream(archivo);
            if(ois!=null){
                listahospital=(List<Hospital>)ois.readObject();
            }else{
                System.out.println("El objeto es nulo");
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(OperHospEsp.class.getName()).log(Level.SEVERE, null, e);
        }catch(IOException ex){
             Logger.getLogger(OperHospEsp.class.getName()).log(Level.SEVERE, null, ex);
        }catch(ClassNotFoundException ex){
             Logger.getLogger(OperHospEsp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

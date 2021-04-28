/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prg1;

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
public class OpercaionesDocMat  {
   private Docente docente;
   private Materia materia;
    
     private List <Docente> listaDoc;

    public OpercaionesDocMat() {
        listaDoc=new ArrayList<>();
    }  
   
    Scanner leer=new Scanner(System.in);
    
      public void crearDoc(){
        docente=new Docente();
        System.out.println("Ingrese el Nombre: ");
        docente.setNombre(leer.nextLine());
        System.out.println("Ingrese Apellido Paterno:");
        docente.setPaterno(leer.nextLine());
        System.out.println("Ingrese Apellido Materno:");
        docente.setMaterno(leer.nextLine());
        System.out.println("Ingrese Titulo:");
        docente.setTitulo(leer.nextLine());
        
        System.out.println("Ingrese Carga Horaria");
         
        docente.setCargaHoraria(leer.nextInt());
        docente.setCargaHorActual(0);
         System.out.println("====Registrado Docente======");
        listaDoc.add(docente);
        leer.nextLine();
    }
    public void mostrarDocente(){
        if(listaDoc.size()>0){
            System.out.println("Docentes");
            for(Docente doc:listaDoc){
                 doc.mostrarDoc();
            }
        }
    }
    
    public void crearMat(){
        
        materia=new Materia();
        System.out.println("Ingrese Nombre de la Materia");
        materia.setNombreMateria(leer.nextLine());
        System.out.println("Ingrese año de la Materia");
        materia.setAnoMateria(leer.nextInt());
        leer.nextLine();
        System.out.println("Ingrese Horas de la Materia");
        materia.setHoraMateria(leer.nextInt());
        leer.nextLine();
        System.out.println("====Registrado===");
    }
    
   public void AsignarDocenteMateria(){
        if( materia!=null){
            System.out.println("Ingrese el Nombre del Docente");
            String nom=leer.nextLine();
            System.out.println("Ingrese su apellido Paterno del Docente");
            String pat=leer.nextLine();
            
            for(Docente doce:listaDoc){
                if(doce.getNombre().equalsIgnoreCase(nom) && doce.getPaterno().equalsIgnoreCase(pat)){
              doce.setCargaHorActual(doce.getCargaHorActual()+materia.getHoraMateria());
                    if(doce.getCargaHorActual()<doce.getCargaHoraria()){
                    doce.adicionMateria(materia);
                     System.out.println("==Se Debe Seguir Asignadole Materias para completar su Carga Horaria==");
                     System.out.println("Horas faltantes : "+(doce.getCargaHoraria()-doce.getCargaHorActual()));
                
                     }
                     else{
                           if(doce.getCargaHorActual()==doce.getCargaHoraria()){
                           System.out.println("");
                           doce.adicionMateria(materia);
                           System.out.println("Carga horaria completada");
                    
                           }
                             else{
                           System.out.println("!!! No se Asigno la Materia !!");
                           System.out.println("Horas de materia exedida ");
                           doce.setCargaHorActual(doce.getCargaHorActual()-materia.getHoraMateria());
                            System.out.println("Horas faltantes : "+(doce.getCargaHoraria()-doce.getCargaHorActual()));
                            }
                     }
                }
//                else{
//                    System.out.println("No se encuentra Registrado el Docente");
//                }
            }
            //docente.AdicMat(materia);
            
        }
        
        else{
            System.out.println("!!!No es posible asignar Materia!!!");
        }
        materia=null;
    }  
   /// CREAMOS DIRECTORIO
   
     public void crearDirectorio() {
        Path path = Paths.get("E:\\programacionIII\\Pract1B");
        try {
            if (!Files.exists(path)) {
                Files.createDirectory(path);
                System.out.println("directorio creado");
            } else {
                System.out.println("Ya existe el directorio");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
   
   ///CREAMOS ARCHIBO
      public void crearArchivo(){
        Path path=Paths.get("E:\\programacionIII\\Pract1B\\archivoDocente.txt");
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
        String ruta="E:\\programacionIII\\Pract1B\\archivoDocente.txt";
        //if(listaDoc.size()>0){
            try {
                
            FileOutputStream archivos=new FileOutputStream(ruta);  
            ObjectOutputStream ooss=new ObjectOutputStream(archivos);
            ooss.writeObject(listaDoc); 
            ooss.close();
            archivos.close();
           
        } catch (FileNotFoundException exe) {
            Logger.getLogger(OpercaionesDocMat.class.getName()).log(Level.SEVERE, null, exe);
        }catch(IOException exe){
            Logger.getLogger(OpercaionesDocMat.class.getName()).log(Level.SEVERE, null, exe);
            
        }
            
       // }else{
         //   System.out.println("lista vacia");
       // }
        
    }
    //cargamos los datos del archivo a un list<Cliente>
    public void leerDocentes(){
        String ruta="E:\\programacionIII\\Pract1B\\archivoDocente.txt";
        try {
            FileInputStream archivo=new FileInputStream(ruta);
            ObjectInputStream ois=new ObjectInputStream(archivo);
            if(ois!=null){
                listaDoc=(List<Docente>)ois.readObject();
            }else{
                System.out.println("El objeto es nulo");
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(OpercaionesDocMat.class.getName()).log(Level.SEVERE, null, e);
        }catch(IOException ex){
             Logger.getLogger(OpercaionesDocMat.class.getName()).log(Level.SEVERE, null, ex);
        }catch(ClassNotFoundException ex){
             Logger.getLogger(OpercaionesDocMat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
 
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prg1;

import java.util.Scanner;

/**
 *
 * @author win
 */
public class principalDocMat {
        public static void main(String[] args) {
        
        OpercaionesDocMat obj=new OpercaionesDocMat();
         Scanner leer = new Scanner(System.in);
        boolean continuar = true;
        int opcion;
        do {
            System.out.println("MENU DE OPCIONES");
            System.out.println("1. Crear Directorio");
            System.out.println("2. Crear Archivo");
            System.out.println("3. Crear Docente");
            System.out.println("4. Crear Materia");
            System.out.println("5. Asignar Materia a Docente");
            System.out.println("6. Mostrar Docente");
            System.out.println("7. Salir");
            System.out.println("digite una opcion");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    obj.crearDirectorio();
                    break;
                case 2:
                    obj.crearArchivo();
                    break;
                case 3:
                    String reg="s";
                    while(reg.equalsIgnoreCase("s")){
                        obj.crearDoc();
                    obj.guardarObjetos();
                        System.out.println("Desea Regsitrar otro Docente s/n");
                        leer.nextLine();
                        reg=leer.nextLine();
                    }
                    
                    break;
                case 4:
                    obj.crearMat();
                    obj.guardarObjetos();
                    break;
                case 5:
                    obj.leerDocentes();
                    obj.AsignarDocenteMateria();
                    obj.guardarObjetos();
                    break;
                case 6:
                    obj.leerDocentes();
                    obj.mostrarDocente();
                    break;
                default:
                    continuar = false;
                    break;
            }

        } while (continuar);
    }
}

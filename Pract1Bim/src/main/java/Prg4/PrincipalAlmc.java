/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prg4;

import java.util.Scanner;

/**
 *
 * @author win
 */
public class PrincipalAlmc {
      public static void main(String[] args) {
        
        OperacionesAlamc obj=new OperacionesAlamc();
         Scanner leer = new Scanner(System.in);
        boolean continuar = true;
        int opcion;
        do {
            System.out.println("MENU DE OPCIONES");
            System.out.println("1. Crear Archivo");
            System.out.println("2. Registrar Disco Duro-Archivo");
            System.out.println("3. Mostrar Disco Duro");
            System.out.println("4. Mostrar Archivos");
            System.out.println("5. Elimiar Archivo");
            System.out.println("6. Salir");
            System.out.println("digite una opcion");
            opcion = leer.nextInt();
            switch (opcion) {
               
                case 1:
                    obj.crearArchivo();
                    break;
                case 2:
                    obj.crearDisc();
                    obj.guardarObjetos();
                    break;
                case 3:
                    obj.leerDiscoDuro();
                    obj.mostrarDisc();
                    obj.guardarObjetos();
                    break;
                case 4:
                   obj.leerDiscoDuro();
                    obj.listArchivo();
                    obj.guardarObjetos();
                    break;
                case 5:
                     obj.leerDiscoDuro();
                    obj.eliminarArchi();
                    obj.guardarObjetos();
                    break;
                default:
                    continuar = false;
                    break;
            }

        } while (continuar);
    }
}

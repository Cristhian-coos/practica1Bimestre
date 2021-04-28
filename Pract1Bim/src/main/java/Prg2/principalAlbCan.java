/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prg2;

import java.util.Scanner;

/**
 *
 * @author win
 */
public class principalAlbCan {
     public static void main(String[] args) {
        
        OperacionesAlbCan obj=new OperacionesAlbCan();
         Scanner leer = new Scanner(System.in);
        boolean continuar = true;
        int opcion;
        do {
            System.out.println("====MENU DE OPCIONES====");
            System.out.println("1. CREAR ARCHIVO");
            System.out.println("2. CREAR ALBUN-CANCION");
            System.out.println("3. MOSTRAR ALBUN");
            System.out.println("4. BUSCAR CANCION");
            System.out.println("5. MOSTRAR CANCIONES");
            System.out.println("6. ELIMINAR ALBUN");
            System.out.println("7. SALIR");
            System.out.println("digite una opcion");
            System.out.println("-------------------------");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    obj.crearArchivo();
                    break;
                case 2:
                    obj.crearAlbun();
                    obj.guardarObjetos();
                    break;
                case 3:
                    obj.leerAlbun();
                    obj.mostrarAlbun();
                    break;
                case 4:
                    obj.leerAlbun();
                    obj.buscarCan();
                
                    break;
                case 5:
                    obj.leerAlbun();
                    obj.mostrarCanc();
                    break;
                case 6:
                    obj.leerAlbun();
                    obj.eliminarAlbun();
                    obj.guardarObjetos();
                    break;
                default:
                    continuar = false;
                    break;
            }

        } while (continuar);
    }
}

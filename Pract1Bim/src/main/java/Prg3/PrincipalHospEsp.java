/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prg3;

import java.util.Scanner;

/**
 *
 * @author win
 */
public class PrincipalHospEsp {
     public static void main(String[] args) {
        OperHospEsp obj=new OperHospEsp();
         Scanner leer = new Scanner(System.in);
        boolean continuar = true;
        int opcion;
        do {
            System.out.println("MENU DE OPCIONES");
            System.out.println("1. CREAR ARCHIVO");
            System.out.println("2. CREAR HOSPITAL");
            System.out.println("3. CREAR ESPECIALIDA");
            System.out.println("4. ASIGNAR ESPECIALIDAD A HOSPITAL");
            System.out.println("5. ESPCIALIDADES DE UN HOSPITAL");
            System.out.println("6. HOSPITALES CON UN DETERMINADA ESPECIALIDAD");
            System.out.println("7. salir");
            System.out.println("digite una opcion");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    obj.crearArchivo();
                    break;
                case 2:
                    obj.crearHos();
                    obj.guardarObjetos();
                    break;
                case 3:
                    obj.crearEsp();
                    break;
                case 4:
                    obj.asignarEspe();
                    obj.guardarObjetos();
                    break;
                case 5:
                    obj.leerHospital();
                    obj.mostrarEs();
                    obj.guardarObjetos();
                    break;
                case 6:
                    obj.leerHospital();
                    obj.listHosp();
                    obj.guardarObjetos();
                    break;
                default:
                    continuar = false;
                    break;
            }

        } while (continuar);
    }
}

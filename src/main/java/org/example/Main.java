package org.example;
import org.example.util.MenuCita;
import org.example.util.MenuDueño;
import org.example.util.MenuMascotas;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Gestionar Dueños");
            System.out.println("2. Gestionar Mascotas");
            System.out.println("3. Gestionar Citas");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    MenuDueño.mostrar();

                    break;
                case 2:
                    MenuMascotas.mostrar();

                    break;
                case 3:
                    MenuCita.mostrar();


                case 0:
                    System.out.println("Saliendo...");
                    break;
                default: System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }
    }

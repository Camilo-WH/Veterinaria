package org.example.util;

import org.example.dao.DueñoDAO;
import org.example.dao.DueñoDAOimpl;
import org.example.model.Dueño;

import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Connection;
import java.util.List;

public class MenuDueño {

    public static void mostrar() {
        try (Connection connection = ConexionBD.obtenerConexion()) {
            DueñoDAO ClientesDAO = new DueñoDAOimpl(connection);
            Scanner scanner = new Scanner(System.in);
            int opcion;

            do {
                System.out.println("\nMenu:");
                System.out.println("1. Registrar Dueños");
                System.out.println("2. Leer Dueños");
                System.out.println("3. Actualizar Dueños");
                System.out.println("4. Eliminar Dueños");
                System.out.println("5. Listar Dueños");
                System.out.println("0. Salir");
                System.out.print("Elige una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.print("ID Dueño: ");
                        int idDueño = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nombre: ");
                        String nombre = scanner.nextLine();
                        System.out.println("Telefono: ");
                        String telefono = scanner.nextLine();
                        scanner.nextLine();

                        Dueño dueño = new Dueño(idDueño, nombre,  telefono);
                        DueñoDAO dueñoDAO = new DueñoDAOimpl(connection);
                        dueñoDAO.crear(dueño);
                        System.out.println("Dueño registrado.");
                        break;

                    case 2:
                        System.out.print("Ingrese el ID del Dueño: ");
                        int idLeer = scanner.nextInt();

                        DueñoDAO dueñoDAO1 = new DueñoDAOimpl(connection);
                        Dueño dueño1 = dueñoDAO1.leer(idLeer);

                        if (dueño1 != null) {
                            System.out.println(dueño1);
                        } else {
                            System.out.println("Dueño no encontrado.");
                        }
                        break;

                    case 3:
                        System.out.print("ID del Dueño a actualizar: ");
                        int idDueno2 = scanner.nextInt();
                        scanner.nextLine();

                        DueñoDAO dueñoDAO2 = new DueñoDAOimpl(connection);
                        Dueño dueño2 = dueñoDAO2.leer(idDueno2);

                        if (dueño2 != null) {
                            System.out.print("Nuevo nombre: ");
                            String nuevoNombre = scanner.nextLine();

                            System.out.print("Nuevo teléfono: ");
                            String nuevoTelefono = scanner.nextLine();

                            dueño2.setNombre(nuevoNombre);
                            dueño2.setTelefono(nuevoTelefono);

                            dueñoDAO2.actualizar(dueño2);
                            System.out.println("Dueño actualizado.");
                        } else {
                            System.out.println("No se encontró ningún dueño con ese ID.");
                        }
                        break;

                    case 4:
                        System.out.print("ID del dueño a eliminar: ");
                        int dueno2 = scanner.nextInt();

                        ClientesDAO.eliminar(dueno2);
                        System.out.println("Dueño eliminado.");
                        break;

                    case 5:
                        DueñoDAO dueñoDAO3 = new DueñoDAOimpl(connection);
                        List<Dueño> listadueño = dueñoDAO3.listar();
                        for (Dueño p : listadueño) {
                            System.out.println(p);
                        }
                        break;

                    case 0:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }
            } while (opcion != 0);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package org.example.util;


import org.example.dao.MascotaDAO;
import org.example.dao.MascotaDAOimpl;
import org.example.model.Mascota;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MenuMascotas {
    public static void mostrar() {
        try (Connection connection = ConexionBD.obtenerConexion()) {
            MascotaDAO mascotaDAO = new MascotaDAOimpl(connection);
            Scanner scanner = new Scanner(System.in);
            int opcion;

            do {
                System.out.println("\nMenu:");
                System.out.println("1. Registrar Mascotas");
                System.out.println("2. Leer Mascotas");
                System.out.println("3. Actualizar Mascotas");
                System.out.println("4. Eliminar Mascotas");
                System.out.println("5. Listar Mascotas");
                System.out.println("0. Salir");
                System.out.print("Elige una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.print("ID Mascota: ");
                        int IDmascota = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nombre: ");
                        String nombre = scanner.nextLine();
                        System.out.println("Especie: ");
                        String Especie = scanner.nextLine();
                        System.out.println("ID Dueño");
                        int idDueño = scanner.nextInt();
                        scanner.nextLine();

                        Mascota mascota = new Mascota( nombre, Especie, IDmascota, idDueño);
                        MascotaDAO mascotaDAO1 = new MascotaDAOimpl(connection);
                        mascotaDAO1.crear(mascota);
                        System.out.println("Mascota registrada.");
                        break;

                    case 2:
                        System.out.print("Ingrese el ID de la mascota: ");
                        int idLeer = scanner.nextInt();

                        MascotaDAO mascotaDAO2 = new MascotaDAOimpl(connection);
                        Mascota mascota1 = mascotaDAO2.leer(idLeer);

                        if (mascota1 != null) {
                            System.out.println(mascota1);
                        } else {
                            System.out.println("Mascota no encontrada.");
                        }
                        break;

                    case 3:
                        System.out.print("ID de la mascota a actualizar: ");
                        int idmascota2 = scanner.nextInt();
                        scanner.nextLine();

                        MascotaDAO mascotaDAO3 = new MascotaDAOimpl(connection);
                        Mascota mascota2 = mascotaDAO3.leer(idmascota2);

                        if (mascota2 != null) {
                            System.out.print("Nuevo nombre: ");
                            String nuevoNombre = scanner.nextLine();

                            System.out.print("Nueva especie: ");
                            String nuevaEspecie = scanner.nextLine();

                            mascota2.setNombre(nuevoNombre);
                            mascota2.setEspecie(nuevaEspecie);

                            mascotaDAO3.actualizar(mascota2);
                            System.out.println("Mascota actualizada.");
                        } else {
                            System.out.println("No se encontró ningúna mascota con ese ID.");
                        }
                        break;

                    case 4:
                        System.out.print("ID de la mascota a eliminar: ");
                        int mascota4 = scanner.nextInt();

                        MascotaDAO mascotaDAO4 = new MascotaDAOimpl(connection);
                        mascotaDAO.eliminar(mascota4);
                        System.out.println("Mascota eliminada.");
                        break;

                    case 5:
                        MascotaDAO mascotaDAO5 = new MascotaDAOimpl(connection);
                        List<Mascota> listamascota = mascotaDAO5.listar();
                        for (Mascota p : listamascota) {
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

package org.example.util;

import org.example.dao.CitaDAO;
import org.example.dao.CitaDAOimpl;
import org.example.dao.MascotaDAO;
import org.example.dao.MascotaDAOimpl;
import org.example.model.Cita;
import org.example.model.Mascota;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MenuCita {

    public static void mostrar() {
        try (Connection connection = ConexionBD.obtenerConexion()) {
            CitaDAO mascotaDAO = new CitaDAOimpl(connection);
            Scanner scanner = new Scanner(System.in);
            int opcion;

            do {
                System.out.println("\nMenu:");
                System.out.println("1. Registrar Cita");
                System.out.println("2. Leer Cita");
                System.out.println("3. Actualizar Cita");
                System.out.println("4. Eliminar Cita");
                System.out.println("5. Listar Cita");
                System.out.println("0. Salir");
                System.out.print("Elige una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.print("ID Cita: ");
                        int IDcita = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Fecha: ");
                        String fecha = scanner.nextLine();
                        System.out.println("Motivo: ");
                        String motivo = scanner.nextLine();
                        System.out.println("ID Mascota");
                        int idmascota = scanner.nextInt();
                        scanner.nextLine();

                        Cita cita = new Cita( IDcita, fecha,motivo, idmascota);
                        CitaDAO citaDAO = new CitaDAOimpl(connection);
                        citaDAO.crear(cita);
                        System.out.println("Cita registrada.");
                        break;

                    case 2:
                        System.out.print("Ingrese el ID de la cita: ");
                        int idLeer = scanner.nextInt();

                        CitaDAO citaDAO1 = new CitaDAOimpl(connection);
                        Cita cita1 = citaDAO1.leer(idLeer);

                        if (cita1!= null) {
                            System.out.println(cita1);
                        } else {
                            System.out.println("Cita no encontrada.");
                        }
                        break;

                    case 3:
                        System.out.print("ID de la cita a actualizar: ");
                        int idcita2 = scanner.nextInt();
                        scanner.nextLine();

                        CitaDAO citaDAO2 = new CitaDAOimpl(connection);
                        Cita cita2 = citaDAO2.leer(idcita2);

                        if (cita2!= null) {
                            System.out.print("Nuevo motivo: ");
                            String nuevoMotivo = scanner.nextLine();

                            System.out.print("Nueva fecha: ");
                            String nuevaFecha = scanner.nextLine();


                            cita2.setFecha(nuevaFecha);
                            cita2.setMotivo(nuevoMotivo);

                            citaDAO2.actualizar(cita2);
                            System.out.println("Cita actualizada.");
                        } else {
                            System.out.println("No se encontró ningúna cita con ese ID.");
                        }
                        break;

                    case 4:
                        System.out.print("ID de la cita a eliminar: ");
                        int citaa = scanner.nextInt();

                        CitaDAO citaDAO3 = new CitaDAOimpl(connection);
                        citaDAO3.eliminar(citaa);
                        System.out.println("Cita eliminada.");
                        break;

                    case 5:
                        CitaDAO citaDAO4 = new CitaDAOimpl(connection);
                        List<Cita> listaCita = citaDAO4.listar();
                        for (Cita p : listaCita) {
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

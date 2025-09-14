package org.laboratorio1.controller;

import org.laboratorio1.service.GestorTareas;
import org.laboratorio1.model.Tarea;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestorTareas gestor = new GestorTareas();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- GESTOR DE TAREAS ---");
            System.out.println("1. Agregar nueva tarea");
            System.out.println("2. Ver tareas pendientes");
            System.out.println("3. Marcar tarea como completada");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa la descripción de la tarea: ");
                    String descripcion = scanner.nextLine();
                    gestor.agregarTarea(descripcion);
                    System.out.println("✅ Tarea agregada correctamente.");
                    break;

                case 2:
                    ArrayList<Tarea> pendientes = gestor.obtenerTareasPendientes();
                    if (pendientes.isEmpty()) {
                        System.out.println("📭 No hay tareas pendientes.");
                    } else {
                        System.out.println("📋 Tareas pendientes:");
                        for (Tarea tarea : pendientes) {
                            System.out.println("ID: " + tarea.getId() + " | " + tarea.getDescripcion());
                        }
                    }
                    break;

                case 3:
                    System.out.print("Ingresa el ID de la tarea a completar: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // limpiar el buffer
                    gestor.marcarTareaComoCompletada(id);
                    System.out.println("✅ Tarea marcada como completada (si existía).");
                    break;

                case 4:
                    salir = true;
                    System.out.println("👋 ¡Hasta luego!");
                    break;

                default:
                    System.out.println("⚠️ Opción inválida. Intenta de nuevo.");
                    break;
            }
        }

        scanner.close();
    }
}

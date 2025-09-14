package org.laboratorio1.service;

import org.laboratorio1.model.Tarea;
import java.util.ArrayList;

public class GestorTareas {
    private ArrayList<Tarea> listaTareas;
    private int proximoId;

    public GestorTareas() {
        listaTareas = new ArrayList<>();
        proximoId = 1;
    }

    public void agregarTarea(String descripcion) {
        Tarea nuevaTarea = new Tarea(proximoId, descripcion);
        listaTareas.add(nuevaTarea);
        proximoId++;
    }

    public void marcarTareaComoCompletada(int id) {
        for (Tarea tarea : listaTareas) {
            if (tarea.getId() == id) {
                tarea.setCompletada(true);
                break; // Tarea encontrada, salimos del bucle
            }
        }
    }

    public ArrayList<Tarea> obtenerTareasPendientes() {
        ArrayList<Tarea> pendientes = new ArrayList<>();
        for (Tarea tarea : listaTareas) {
            if (!tarea.isCompletada()) {
                pendientes.add(tarea);
            }
        }
        return pendientes;
    }
}

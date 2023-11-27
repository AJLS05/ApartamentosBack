package hn.proyecto.apartamentos.services;

import java.util.List;

import hn.proyecto.apartamentos.model.Cuotas;

public interface CuotasService {
    public Cuotas crearCuota(Cuotas nvaCuota);

    public List<Cuotas> obtenerTodosCuotas();
    
}


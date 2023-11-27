package hn.proyecto.apartamentos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import hn.proyecto.apartamentos.model.Cuotas;

@Service
public interface CuotasService {
    public Cuotas crearCuota(Cuotas nvaCuota);

    public List<Cuotas> obtenerTodosCuotas();
    
}


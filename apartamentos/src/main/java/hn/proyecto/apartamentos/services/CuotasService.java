package hn.proyecto.apartamentos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import hn.proyecto.apartamentos.model.Cuota;

@Service
public interface CuotasService {
    public Cuota crearCuota(Cuota nvaCuota);

    public List<Cuota> obtenerTodosCuotas();
    
}


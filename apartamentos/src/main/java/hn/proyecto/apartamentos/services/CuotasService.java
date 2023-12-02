package hn.proyecto.apartamentos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import hn.proyecto.apartamentos.model.Cuota;
import hn.proyecto.apartamentos.services.dto.CuotaDTO;

@Service
public interface CuotasService {
    public Cuota crearCuota(CuotaDTO nvaCuota);

    public List<Cuota> obtenerTodosCuotas();
    
}


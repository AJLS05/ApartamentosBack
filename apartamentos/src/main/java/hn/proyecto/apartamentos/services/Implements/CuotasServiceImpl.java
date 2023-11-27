package hn.proyecto.apartamentos.services.Implements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.proyecto.apartamentos.model.Cuotas;
import hn.proyecto.apartamentos.repositories.CuotasRepository;
import hn.proyecto.apartamentos.services.CuotasService;

@Service
public class CuotasServiceImpl implements CuotasService {

    @Autowired
    private CuotasRepository cuotaRepository;

    @Override
    public Cuotas crearCuota(Cuotas nvaCuota) {
        return cuotaRepository.save(nvaCuota);
    }

    @Override
    public List<Cuotas> obtenerTodosCuotas() {
        return this.cuotaRepository.findAll();
    }
    
}

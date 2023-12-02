package hn.proyecto.apartamentos.services.Implements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.proyecto.apartamentos.model.Apartamento;
import hn.proyecto.apartamentos.model.Cuota;
import hn.proyecto.apartamentos.model.Inquilino;
import hn.proyecto.apartamentos.repositories.ApartamentoRepository;
import hn.proyecto.apartamentos.repositories.CuotasRepository;
import hn.proyecto.apartamentos.repositories.InquilinoRepository;
import hn.proyecto.apartamentos.services.CuotasService;
import hn.proyecto.apartamentos.services.dto.CuotaDTO;

@Service
public class CuotasServiceImpl implements CuotasService {

    @Autowired
    private CuotasRepository cuotaRepository;

    @Autowired
    private ApartamentoRepository apartamentoRepository;

    @Autowired
    private InquilinoRepository inquilinoRepository;

    @Override
    public Cuota crearCuota(CuotaDTO nvaCuota) {
        Cuota cuota = new Cuota();
        cuota.setCodigoCuota(nvaCuota.getCodigoCuota());
        cuota.setDescripcion(nvaCuota.getDescripcion());
        cuota.setFechaCobro(nvaCuota.getFechaCobro());
        cuota.setMonto(nvaCuota.getMonto());

        Inquilino inquilino = this.inquilinoRepository
            .findById(nvaCuota.getIdInquilino()).get();
        cuota.setInquilino(inquilino);

        Apartamento apartamento = this.apartamentoRepository
            .findById(nvaCuota.getNumApartamento()).get();
        cuota.setApartamento(apartamento);

        return cuotaRepository.save(cuota);
    }

    @Override
    public List<Cuota> obtenerTodosCuotas() {
        return this.cuotaRepository.findAll();
    }
    
}

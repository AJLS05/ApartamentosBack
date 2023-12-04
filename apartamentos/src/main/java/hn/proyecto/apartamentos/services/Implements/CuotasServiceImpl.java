package hn.proyecto.apartamentos.services.Implements;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.proyecto.apartamentos.model.Apartamento;
import hn.proyecto.apartamentos.model.Cuota;
import hn.proyecto.apartamentos.model.Inquilino;
import hn.proyecto.apartamentos.repositories.ApartamentoRepository;
import hn.proyecto.apartamentos.repositories.CuotasRepository;
import hn.proyecto.apartamentos.services.CuotasService;
import hn.proyecto.apartamentos.services.dto.CuotaDTO;

@Service
public class CuotasServiceImpl implements CuotasService {

    @Autowired
    private CuotasRepository cuotaRepository;

    @Autowired
    private ApartamentoRepository apartamentoRepository;

    @Override
    public Cuota crearCuota(CuotaDTO nvaCuota) {
        Cuota cuota = new Cuota();
        cuota.setDescripcion(nvaCuota.getDescripcion());
        cuota.setFechaCobro(new Date());
        cuota.setMonto(nvaCuota.getMonto());

        Apartamento apartamento = this.apartamentoRepository
        .findById(nvaCuota.getNumApartamento()).get();
        cuota.setApartamento(apartamento);
        
        Inquilino inquilino = apartamento.getInquilino();
        cuota.setInquilino(inquilino);

        return cuotaRepository.save(cuota);
    }

    @Override
    public List<Cuota> obtenerTodosCuotas(boolean canceladas) {
        List<Cuota> cuotas = this.cuotaRepository.findAll();
        if (!canceladas) cuotas.removeIf(cuota -> cuota.isCancelada());
        return cuotas;
    }

    public String cancelarCuota(int codigoCuota) {
        Cuota cuota = this.cuotaRepository.findById(codigoCuota).get();
        if (cuota != null) {
            cuota.setCancelada(true);
            this.cuotaRepository.save(cuota);
            return "Cuota cancelada con exito.";
        }
        return "Error al cancelar la cuota!";
    }

    @Override
    public List<Cuota> obtenerCuotasInquilino(int idInquilino, boolean canceladas) {
        
        List<Cuota> cuotas = this.cuotaRepository.findAll();

        if (!canceladas) cuotas.removeIf(cuota -> cuota.isCancelada());
        cuotas.removeIf(cuota -> cuota.getInquilino() == null);
        cuotas.removeIf(cuota -> cuota.getInquilino().getIdInquilino() != idInquilino);

        return cuotas;
    }

    @Override
    public List<Cuota> obtenerCuotasDueno(int idDueno, boolean canceladas) {
        List<Cuota> cuotas = this.cuotaRepository.findAll();

        if (!canceladas) cuotas.removeIf(cuota -> cuota.isCancelada());
        cuotas.removeIf(cuota -> cuota.getInquilino() != null);
        cuotas.removeIf(cuota -> cuota.getApartamento().getDueno().getIdDueno() != idDueno);

        return cuotas;
    }

    @Override
    public List<Cuota> obtenerCuotasApartamento(int numApartamento, boolean canceladas) {
        
        List<Cuota> cuotas = this.cuotaRepository.findAll();

        if (!canceladas) cuotas.removeIf(cuota -> cuota.isCancelada());
        cuotas.removeIf(cuota -> cuota.getApartamento().getNumApartamento() != numApartamento);

        return cuotas;
    }
    
}

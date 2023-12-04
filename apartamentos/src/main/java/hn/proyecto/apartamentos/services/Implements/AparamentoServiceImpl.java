package hn.proyecto.apartamentos.services.Implements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.proyecto.apartamentos.model.Apartamento;
import hn.proyecto.apartamentos.model.Dueno;
import hn.proyecto.apartamentos.model.Inquilino;
import hn.proyecto.apartamentos.repositories.ApartamentoRepository;
import hn.proyecto.apartamentos.repositories.DuenoRepository;
import hn.proyecto.apartamentos.repositories.InquilinoRepository;
import hn.proyecto.apartamentos.services.ApartamentoService;

@Service
public class AparamentoServiceImpl implements ApartamentoService{


    @Autowired
    private ApartamentoRepository apartamentoRepository;

    @Autowired
    private DuenoRepository duenoRepository;

    @Autowired
    private InquilinoRepository inquilinoRepository;
    
    @Override
    public Apartamento crearApartamento(Apartamento nvoApartamento) {
        return apartamentoRepository.save(nvoApartamento);
    }

    @Override
    public Apartamento obtenerApartamentoPorNum(int numApartamento) {
        return apartamentoRepository.findById(numApartamento).get();
    }

    @Override
    public String eliminarApartamentoPorNum(int numApartamento) {
        Apartamento AppEliminar = this.apartamentoRepository.findById(numApartamento).get();

        if(AppEliminar != null){
            this.apartamentoRepository.delete(AppEliminar);
            return "Se ha eliminado el Apartamento: " + AppEliminar.getNumApartamento(); 
        }

        return "No existe el Apartamento con numero: " + numApartamento;
    }

    @Override
    public List<Apartamento> obtenerTodosApartamentos() {
        return this.apartamentoRepository.findAll();
    }
    
    @Override
    public String agregarInquilino(int numApartamento, int idInquilino) {
        Apartamento apartamento = this.apartamentoRepository.findById(numApartamento).get();
        if(apartamento != null){
            Inquilino inquilino = this.inquilinoRepository.findById(idInquilino).get();
            if (inquilino != null) {
                apartamento.setInquilino(inquilino);   
                inquilino.setApartamento(apartamento);
                this.apartamentoRepository.save(apartamento);
                this.inquilinoRepository.save(inquilino);
                return "Se ha asociado el apartamento" + apartamento.getNumApartamento() + " al inquilino " + inquilino.getIdInquilino();
            }
            return "No se ha podido encontrar al inquilino...";
        }
        return "No se ha podido encontrar el apartamento...";
    }

    @Override
    public String agregarDueno(int numApartamento, int idDueno) {
        Apartamento apartamento = this.apartamentoRepository.findById(numApartamento).get();
        if (apartamento != null) {
            Dueno dueno = this.duenoRepository.findById(idDueno).get();
            if (dueno != null) {
                apartamento.setDueno(dueno);
                this.apartamentoRepository.save(apartamento);
                return "Se ha asociado el apartamento" + apartamento.getNumApartamento() + " al dueño " + dueno.getIdDueno();
            }
            return "No se ha podido encontrar al dueño...";
        }
        return "No se ha podido encontrar el apartamento...";
    }
}


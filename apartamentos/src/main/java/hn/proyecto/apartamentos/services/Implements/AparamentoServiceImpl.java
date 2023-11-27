package hn.proyecto.apartamentos.services.Implements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.proyecto.apartamentos.model.Apartamento;
import hn.proyecto.apartamentos.model.Inquilinos;
import hn.proyecto.apartamentos.repositories.ApartamentoRepository;
import hn.proyecto.apartamentos.services.ApartamentoService;

@Service
public class AparamentoServiceImpl implements ApartamentoService{


    @Autowired
    private ApartamentoRepository apartamentoRepository;

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
    public String agregarInquilino(int numApartamento, Inquilinos inquilino ) {
        Apartamento ApartamentoAAgregar = apartamentoRepository.findById(numApartamento).get();

        if(ApartamentoAAgregar != null){
            ApartamentoAAgregar.setInquilino(inquilino);
            
            this.apartamentoRepository.save(ApartamentoAAgregar);
            return "Se ha Agregado el inquilino: " + inquilino;
        }

        return "No existe el apartamento con num: " + numApartamento;

    }
}


package hn.proyecto.apartamentos.services.Implements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.proyecto.apartamentos.model.Apartamento;
import hn.proyecto.apartamentos.model.Inquilino;
import hn.proyecto.apartamentos.repositories.InquilinosRepository;
import hn.proyecto.apartamentos.services.InquilinosService;

@Service
public class InquilinosServiceImpl implements InquilinosService{

    @Autowired
    private InquilinosRepository inquilinosRepository;

    @Override
    public Inquilino crearInquilino(Inquilino nvoInquilino, Apartamento Apartamento) {

        return inquilinosRepository.save(nvoInquilino);
    }

    @Override
    public Inquilino obtenerInquilino(int codigoInquilino) {
        return inquilinosRepository.findById(codigoInquilino).get();
    }

    @Override
    public String eliminarInquilino(int codigoInquilino) {
        Inquilino InqEliminar = this.inquilinosRepository.findById(codigoInquilino).get();

        if(InqEliminar != null){
            this.inquilinosRepository.delete(InqEliminar);
            return "Se ha eliminado el Dueno: " + InqEliminar.getCodigoInquilino(); 
        }

        return "No existe el Dueno con ID: " + InqEliminar;
    }

    @Override
    public List<Inquilino> obtenerTodosInquilinos() {
        return this.inquilinosRepository.findAll();
    }
    
}

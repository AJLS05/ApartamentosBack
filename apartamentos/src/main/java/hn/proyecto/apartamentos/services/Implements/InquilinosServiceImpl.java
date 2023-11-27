package hn.proyecto.apartamentos.services.Implements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import hn.proyecto.apartamentos.model.Inquilinos;
import hn.proyecto.apartamentos.repositories.InquilinosRepository;
import hn.proyecto.apartamentos.services.InquilinosService;

public class InquilinosServiceImpl implements InquilinosService{

    @Autowired
    private InquilinosRepository inquilinosRepository;

    @Override
    public Inquilinos crearInquilino(Inquilinos nvoInquilino) {
        return inquilinosRepository.save(nvoInquilino);
    }

    @Override
    public Inquilinos obtenerInquilino(int codigoInquilino) {
        return inquilinosRepository.findById(codigoInquilino).get();
    }

    @Override
    public String eliminarInquilino(int codigoInquilino) {
        Inquilinos InqEliminar = this.inquilinosRepository.findById(codigoInquilino).get();

        if(InqEliminar != null){
            this.inquilinosRepository.delete(InqEliminar);
            return "Se ha eliminado el Dueno: " + InqEliminar.getCodigoInquilino(); 
        }

        return "No existe el Dueno con ID: " + InqEliminar;
    }

    @Override
    public List<Inquilinos> obtenerTodosInquilinos() {
        return this.inquilinosRepository.findAll();
    }
    
}

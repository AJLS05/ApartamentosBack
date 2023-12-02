package hn.proyecto.apartamentos.services.Implements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.proyecto.apartamentos.model.Apartamento;
import hn.proyecto.apartamentos.model.Inquilino;
import hn.proyecto.apartamentos.repositories.InquilinoRepository;
import hn.proyecto.apartamentos.services.InquilinosService;

@Service
public class InquilinosServiceImpl implements InquilinosService{

    @Autowired
    private InquilinoRepository inquilinosRepository;

    @Override
    public Inquilino crearInquilino(Inquilino nvoInquilino) {

        return inquilinosRepository.save(nvoInquilino);
    }

    @Override
    public Inquilino obtenerInquilino(int idInquilino) {
        return inquilinosRepository.findById(idInquilino).get();
    }

    @Override
    public String eliminarInquilino(int idInquilino) {
        Inquilino InqEliminar = this.inquilinosRepository.findById(idInquilino).get();

        if(InqEliminar != null){
            this.inquilinosRepository.delete(InqEliminar);
            return "Se ha eliminado el Dueno: " + InqEliminar.getIdInquilino(); 
        }

        return "No existe el Dueno con ID: " + InqEliminar;
    }

    @Override
    public List<Inquilino> obtenerTodosInquilinos() {
        return this.inquilinosRepository.findAll();
    }
    
}

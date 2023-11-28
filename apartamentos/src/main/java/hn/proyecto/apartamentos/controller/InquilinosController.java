package hn.proyecto.apartamentos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hn.proyecto.apartamentos.model.Apartamento;
import hn.proyecto.apartamentos.model.Inquilinos;
import hn.proyecto.apartamentos.services.Implements.InquilinosServiceImpl;

@RestController
@RequestMapping("/Inquilinos")
class InquilinoController {

    @Autowired
    private InquilinosServiceImpl inquilinosServiceImpl;

    @GetMapping("/obtener/todos")
    public List<Inquilinos> obtenerTodos() {
        return this.inquilinosServiceImpl.obtenerTodosInquilinos();
    }

    @GetMapping("/obtener")
    public Inquilinos obtenerInquilino(@RequestParam(name="codigoInquilino") int codigoInquilino){
        return this.inquilinosServiceImpl.obtenerInquilino(codigoInquilino);
    }

    @PostMapping("/crear")
    public Inquilinos crearInquilino(@RequestBody Inquilinos nvoiInquilino, Apartamento Apartamento){
        nvoiInquilino.setApartamentos(Apartamento);
        return this.inquilinosServiceImpl.crearInquilino(nvoiInquilino, Apartamento);
    }
    
    @DeleteMapping("/eliminar")
    public String eliminarDueno(@RequestParam(name="codigoInquilino") int codigoInquilino){
        return this.inquilinosServiceImpl.eliminarInquilino(codigoInquilino);
    }
}
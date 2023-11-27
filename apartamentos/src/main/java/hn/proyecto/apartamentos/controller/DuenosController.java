package hn.proyecto.apartamentos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hn.proyecto.apartamentos.model.Apartamento;
import hn.proyecto.apartamentos.model.Duenos;
import hn.proyecto.apartamentos.services.Implements.DuenosServiceImpl;

@RestController
@RequestMapping("/Duenos")
class DuenosController {

    @Autowired
    DuenosServiceImpl duenosServiceImpl;

    @GetMapping("/obtener/todos")
    public List<Duenos> obtenerTodos() {
        return this.duenosServiceImpl.obtenerTodosDuenos();
    }

    @GetMapping("/obtener")
    public Duenos obtenerDueno(@RequestParam(name="IdDueno") int IdDueno){
        return this.duenosServiceImpl.obtenerDueno(IdDueno);
    }

    @PostMapping("/crear")
    public Duenos crearDuenos(@RequestBody Duenos nvoDueno){

        return this.duenosServiceImpl.crearDueno(nvoDueno);
    }

    @PutMapping("/agregarApartamento")
    public String agregarApartamento(@RequestParam(name="IdDueno") int IdDueno,
                                  @RequestBody Apartamento numApartamento){
        return this.duenosServiceImpl.agregarDuenoApp(IdDueno, numApartamento);
    }


    @DeleteMapping("/eliminar")
    public String eliminarDueno(@RequestParam(name="IdDueno") int IdDueno){
        return this.duenosServiceImpl.eliminarDueno(IdDueno);
    }
}
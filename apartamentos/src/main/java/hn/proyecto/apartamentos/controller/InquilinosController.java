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

import hn.proyecto.apartamentos.model.Inquilino;
import hn.proyecto.apartamentos.services.Implements.InquilinosServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Inquilinos", description = "Gestión de los inquilinos de los apartamentos")
@RestController
@RequestMapping("/api/inquilinos")
class InquilinoController {

    @Autowired
    private InquilinosServiceImpl inquilinosServiceImpl;
    @Operation(summary = "Obtener todos los inquilinos", description = "Obtiene todos los inquilinos de los apartamentos")
    @GetMapping("/obtener/todos")
    public List<Inquilino> obtenerTodos() {
        return this.inquilinosServiceImpl.obtenerTodosInquilinos();
    }

    @Operation(summary = "Buscar inquilino", description = "Busca un inquilino por medio del id")
    @GetMapping("/obtener")
    public Inquilino obtenerInquilino(@RequestParam(name="idInquilino") int idInquilino){
        return this.inquilinosServiceImpl.obtenerInquilino(idInquilino);
    }

    @Operation(summary = "Crear nuevo inquilino", description = "Crea un nuevo inquilino")
    @PostMapping("/crear")
    public Inquilino crearInquilino(@RequestBody Inquilino nvoiInquilino){
        return this.inquilinosServiceImpl.crearInquilino(nvoiInquilino);
    }
    
    @Operation(summary = "Eliminar inquilino", description = "Crea un inquilino por medio del id")
    @DeleteMapping("/eliminar")
    public String eliminarDueno(@RequestParam(name="idInquilino") int idInquilino){
        return this.inquilinosServiceImpl.eliminarInquilino(idInquilino);
    }
}
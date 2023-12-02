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
import hn.proyecto.apartamentos.model.Dueno;
import hn.proyecto.apartamentos.services.Implements.DuenosServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Dueños", description = "Gestión de los dueños de los apartamentos")
@RestController
@RequestMapping("/api/duenos")
class DuenosController {

    @Autowired
    private DuenosServiceImpl duenosServiceImpl;

    @Operation(summary = "Obtener todos los dueños", description = "Obtiene todos los dueños de apartamentos")
    @GetMapping("/obtener/todos")
    public List<Dueno> obtenerTodos() {
        return this.duenosServiceImpl.obtenerTodosDuenos();
    }

    
    @Operation(summary = "Buscar dueño", description = "Busca un dueño de apartamentos")
    @GetMapping("/buscar")
    public Dueno obtenerDueno(@RequestParam(name="IdDueno") int IdDueno){
        return this.duenosServiceImpl.obtenerDueno(IdDueno);
    }

    @Operation(summary = "Crear nuevo dueño", description = "Crea un nuevo dueño de apartamentos")
    @PostMapping("/crear")
    public Dueno crearDuenos(@RequestBody Dueno nvoDueno){

        return this.duenosServiceImpl.crearDueno(nvoDueno);
    }

    @Operation(summary = "Eliminar dueño", description = "Elimina un dueño de apartamentos")
    @DeleteMapping("/eliminar")
    public String eliminarDueno(@RequestParam(name="IdDueno") int IdDueno){
        return this.duenosServiceImpl.eliminarDueno(IdDueno);
    }
}
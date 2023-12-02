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
import hn.proyecto.apartamentos.model.Inquilino;
import hn.proyecto.apartamentos.services.Implements.AparamentoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Apartamentos", description = "Gestión de los apartamentos del edificio")
@RequestMapping("/api/apartamentos")
public class ApartamentoController {

    @Autowired
    private AparamentoServiceImpl apartamentoServiceImpl;

    @Operation(summary = "Obtener todos los apartamentos", description = "Obtener todos los apartamentos del edificio")
    @GetMapping("/obtener/todos")
    public List<Apartamento> obteneApartamentos() {
        return this.apartamentoServiceImpl.obtenerTodosApartamentos();
    }

    @Operation(summary = "Buscar apartamento", description = "Busca un apartamento por medio del número de apartamento")
    @GetMapping("/buscar")
    public Apartamento obtenerApartamentoPorNum(@RequestParam(name="numApartamento") int numApartamento){
        return this.apartamentoServiceImpl.obtenerApartamentoPorNum(numApartamento);
    }


    @Operation(summary = "Crear nuevo apartamento", description = "Crea un nuevo apartamento")
    @PostMapping("/crear")
    public Apartamento crearApartamento(@RequestBody Apartamento nvoApartamento){
        return this.apartamentoServiceImpl.crearApartamento(nvoApartamento);
    }

    
    @Operation(summary = "Asociar inquilino", description = "Asocia un apartamento con un inquilino")
    @PutMapping("/asociarInquilino")
    public String agregarInquilino(
        @RequestParam(name="numApartamento") int numApartamento,
        @RequestParam(name="idInquilino") int idInquilino
        ){
        return this.apartamentoServiceImpl.agregarInquilino(numApartamento, idInquilino);
    }

    @Operation(summary = "Asociar dueño", description = "Asocia un apartamento con un dueño")
    @PutMapping("/asociarDueno")
    public String agregarDueno(
        @RequestParam(name="numApartamento") int numApartamento, 
        @RequestParam(name="idDueno") int idDueno
        ) {
        return this.apartamentoServiceImpl.agregarDueno(numApartamento, idDueno);
    }

    @Operation(summary = "Eliminar un apartamento", description = "Elimina un apartamento por medio del número de apartamento")
    @DeleteMapping("/eliminar")
    public String eliminarApartameto(@RequestParam(name="numApartamento") int numApartamento){
        return this.apartamentoServiceImpl.eliminarApartamentoPorNum(numApartamento);
    }
}
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
import hn.proyecto.apartamentos.model.Inquilinos;
import hn.proyecto.apartamentos.services.Implements.AparamentoServiceImpl;

@RestController
@RequestMapping("/api/Apartamentos")
public class ApartamentoController {

    @Autowired
    private AparamentoServiceImpl apartamentoServiceImpl;

    @GetMapping("/obtener/todos")
    public List<Apartamento> obteneApartamentos() {
        return this.apartamentoServiceImpl.obtenerTodosApartamentos();
    }

    @GetMapping("/obtener")
    public Apartamento obtenerApartamentoPorNum(@RequestParam(name="numApartamento") int numApartamento){
        return this.apartamentoServiceImpl.obtenerApartamentoPorNum(numApartamento);
    }

    @PostMapping("/crear")
    public Apartamento crearApartamento(@RequestBody Apartamento nvoApartamento){     
        if(nvoApartamento.getInquilino() != null)   {
            nvoApartamento.getInquilino().setApartamentos(nvoApartamento);
        }

        if (nvoApartamento.getDueno() != null) {
            nvoApartamento.getDueno().setApartamentos(nvoApartamento);
        }

        return this.apartamentoServiceImpl.crearApartamento(nvoApartamento);
    }

    @PutMapping("/agregarInquilino")
    public String agregarInquilino(@RequestParam(name="numApartamento") int numApartamento,
                                  @RequestBody Inquilinos inquilino){
        return this.apartamentoServiceImpl.agregarInquilino(numApartamento, inquilino);
    }


    @DeleteMapping("/eliminar")
    public String eliminarApartameto(@RequestParam(name="numApartamento") int numApartamento){
        return this.apartamentoServiceImpl.eliminarApartamentoPorNum(numApartamento);
    }
}
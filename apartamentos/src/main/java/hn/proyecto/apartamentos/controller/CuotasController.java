package hn.proyecto.apartamentos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.proyecto.apartamentos.model.Cuotas;
import hn.proyecto.apartamentos.services.Implements.CuotasServiceImpl;

@RestController
@RequestMapping("/api/Cuotas")
class resourceNameController {

    @Autowired
    private CuotasServiceImpl cuotasServiceImpl;

    @GetMapping("/obtener/todos")
    public List<Cuotas> obtenerTodosCuotas() {
        return this.cuotasServiceImpl.obtenerTodosCuotas();
    }

    @PostMapping
    public Cuotas CrearCuota(@RequestBody Cuotas nvaCuota){     
        
    return this.cuotasServiceImpl.crearCuota(nvaCuota);    
    }

}
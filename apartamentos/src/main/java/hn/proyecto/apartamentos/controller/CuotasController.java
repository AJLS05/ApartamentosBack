package hn.proyecto.apartamentos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.proyecto.apartamentos.model.Cuota;
import hn.proyecto.apartamentos.services.Implements.CuotasServiceImpl;
import hn.proyecto.apartamentos.services.dto.CuotaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Cuotas", description = "Gestión de las cuotas de pago por alquiler de los apartamentos")
@RestController
@RequestMapping("/api/cuotas")
class CuotasController {

    @Autowired
    private CuotasServiceImpl cuotasServiceImpl;

    @Operation(summary = "Obtener todas las cuotas de pago", description = "Obtiene todas las cuotas de pago")
    @GetMapping("/obtener/todos")
    public List<Cuota> obtenerTodosCuotas() {
        return this.cuotasServiceImpl.obtenerTodosCuotas();
    }

    @Operation(summary = "Crear nueva cuota de pago", description = "Crea una nueva cuota de pago")
    @PostMapping("/nueva")
    public Cuota CrearCuota(@RequestBody CuotaDTO nvaCuota){     
        return this.cuotasServiceImpl.crearCuota(nvaCuota);    
    }

}
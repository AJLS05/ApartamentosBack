package hn.proyecto.apartamentos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public List<Cuota> obtenerTodosCuotas(
        @RequestParam(name = "incluirCanceladas", defaultValue = "false") boolean canceladas 
    ) {
        return this.cuotasServiceImpl.obtenerTodosCuotas(canceladas);
    }

    @Operation(summary = "Crear nueva cuota de pago", description = "Crea una nueva cuota de pago")
    @PostMapping("/nueva")
    public Cuota CrearCuota(@RequestBody CuotaDTO nvaCuota){     
        return this.cuotasServiceImpl.crearCuota(nvaCuota);    
    }

    @Operation(summary = "Cancelar una cuota", description = "Cancela una cuota por medio del id")
    @PutMapping("/cancelar")
    public String cancelarCuota(@RequestParam(name = "codigoCuota") int codigoCuota) {
        return this.cuotasServiceImpl.cancelarCuota(codigoCuota);
    }

    @Operation(summary = "Obtener las cuotas del inquilino", description = "Obtiene todas las cuotas correspondientes a un inquilino")
    @GetMapping("/obtener/inquilino")
    public List<Cuota> obtenerCuotasInquilino(
        @RequestParam(name = "idInquilino") int idInquilino, 
        @RequestParam(name = "incluirCanceladas", defaultValue = "false") boolean canceladas 
    ) {
        return this.cuotasServiceImpl.obtenerCuotasInquilino(idInquilino, canceladas);
    }
    
    @Operation(summary = "Obtener las cuotas del dueño", description = "Obtiene todas las cuotas correspondientes a un dueño")
    @GetMapping("/obtener/dueno")
    public List<Cuota> obtenerCuotasDueno(
        @RequestParam(name = "idDueno") int idDueno,
        @RequestParam(name = "incluirCanceladas", defaultValue = "false") boolean canceladas 
    ) {
        return this.cuotasServiceImpl.obtenerCuotasDueno(idDueno, canceladas);
    }

    @Operation(summary = "Obtener las cuotas del apartamento", description = "Obtiene todas las cuotas correspondientes a un apartamento")
    @GetMapping("/obtener/apartamento")
    public List<Cuota> obtenerCuotasApartamento(
        @RequestParam(name = "numApartamento") int numApartamento,
        @RequestParam(name = "incluirCanceladas", defaultValue = "false") boolean canceladas 
    ) {
        return this.cuotasServiceImpl.obtenerCuotasApartamento(numApartamento, canceladas);
    }
}
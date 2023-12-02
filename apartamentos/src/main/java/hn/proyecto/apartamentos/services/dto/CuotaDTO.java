package hn.proyecto.apartamentos.services.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CuotaDTO {
    					
    private int codigoCuota;
    
    private int idInquilino;
    
    private int numApartamento;
    
    private float monto;
    
    private String descripcion;
    
    private String fechaCobro;	
        
}

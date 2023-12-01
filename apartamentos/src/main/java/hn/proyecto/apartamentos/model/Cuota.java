package hn.proyecto.apartamentos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="cuotas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cuota {
    					
    @Id
    @Column(name="codigocuota")
    @GeneratedValue(strategy =  GenerationType.IDENTITY)  
    private int codigoCuota;
    
    @ManyToOne
    @JoinColumn(name="idinquilino", referencedColumnName = "idinquilino")
    private Inquilino inquilino;
    
    @ManyToOne
    @JoinColumn(name = "numapartamento", referencedColumnName = "numapartamento")
    private Apartamento apartamento;
    
    @Column(name="monto")	
    private float monto;
    
    @Column(name="descripcion")
    private String descripcion;
    
    @Column(name="fechacobro")
    private String fechaCobro;	
        
}
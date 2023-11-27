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
public class Cuotas {
    					
    @Id
    @Column(name="codigoCuota")
    @GeneratedValue(strategy =  GenerationType.IDENTITY)  
    private int codigoCuota;
    
    @ManyToOne
    @JoinColumn(name="codigoInquilino", referencedColumnName = "codigoInquilino")
    private Inquilinos inquilino;
    
    @Column(name="numApartamento")
    private int numApartamento;
    
    @Column(name="Monto")	
    private String Monto;
    
    @Column(name="Descripcion")
    private String Descripcion;
    
    @Column(name="FechaCobro;")
    private String FechaCobro;	
        
}
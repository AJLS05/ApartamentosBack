package hn.proyecto.apartamentos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="apartamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Apartamento {

    @Id
    @Column(name="numApartamento")
    @GeneratedValue(strategy =  GenerationType.IDENTITY)  
    private int numApartamento;
    
    @Column(name="AreaApart")
    private int AreaApart;
    
    @Column(name="PrecioXmetro")
    private String PrecioXmetro;
    
    @Column(name="Disponible")	
    private boolean Disponible;
    
    @ManyToOne
    @JoinColumn(name="IdDueno", referencedColumnName = "IdDueno")
    private Duenos Dueno;
    
    @OneToOne
    @JoinColumn(name="codigoInquilino", referencedColumnName = "codigoInquilino")
    private Inquilinos inquilino;
    
    @OneToMany
    @JoinColumn(name="codigoCuota", referencedColumnName = "codigoCuota")
    private Cuotas Cuota;
        
}

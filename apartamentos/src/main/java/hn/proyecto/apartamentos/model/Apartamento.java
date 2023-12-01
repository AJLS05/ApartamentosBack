package hn.proyecto.apartamentos.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
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
@Table(name="apartamentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Apartamento {

    @Id
    @Column(name="numapartamento")
    @GeneratedValue(strategy =  GenerationType.IDENTITY)  
    private int numApartamento;
    
    @Column(name="area")
    private float area;
    
    @Column(name="precioxmetro")
    private float precioXmetro;
    
    @Column(name="disponible")	
    private boolean disponible;
    
    @ManyToOne
    @JoinColumn(name="iddueno", referencedColumnName = "iddueno")
    private Dueno dueno;
    
    @OneToOne
    @JoinColumn(name="codigoinquilino", referencedColumnName = "codigoinquilino")
    private Inquilino inquilino;
    
    @JsonIgnore
    @OneToMany(mappedBy = "apartamento", cascade = CascadeType.ALL)
    private List<Cuota> cuotas = new ArrayList<>();
        
}

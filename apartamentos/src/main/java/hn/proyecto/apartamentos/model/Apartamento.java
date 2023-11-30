package hn.proyecto.apartamentos.model;

import java.util.ArrayList;
import java.util.List;

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
    private int area;
    
    @Column(name="precioXmetro")
    private String precioXmetro;
    
    @Column(name="disponible")	
    private boolean disponible;
    
    @ManyToOne
    @JoinColumn(name="iddueno", referencedColumnName = "iddueno")
    private Duenos dueno;
    
    @OneToOne
    @JoinColumn(name="codigoinquilino", referencedColumnName = "codigoinquilino")
    private Inquilinos inquilino;
    
    @OneToMany(mappedBy = "numapartamento", cascade = CascadeType.ALL)
    private List<Cuotas> cuotas = new ArrayList<>();
        
}

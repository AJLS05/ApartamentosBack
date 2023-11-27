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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="inquilinos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Inquilinos {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)  
    @Column(name="codigoInquilino")
    private int codigoInquilino;
    
    @Column(name="Nombre")
    private int Nombre;
    
    @Column(name="Apellido")
    private int Apellido;
    
    @Column(name="Telefono")	
    private String Telefono;
    
    @Column(name="Correo")
    private String Correo;
    
    @Column(name="FechaIngreso")
    private String FechaIngreso;

    
    @OneToMany(mappedBy = "codigoCuota", cascade = CascadeType.ALL)
    private List<Cuotas> Cuota = new ArrayList<>();

    @OneToOne
    @JoinColumn(name="numApartamento", referencedColumnName = "numApartamento")
    private Apartamento Apartamentos;	
        
}

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
    @Column(name="codigoinquilino")
    private int codigoInquilino;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="apellido")
    private String apellido;
    
    @Column(name="telefono")	
    private String telefono;
    
    @Column(name="correo")
    private String correo;
    
    @Column(name="fechaingreso")
    private String fechaIngreso;

    
    @OneToMany(mappedBy = "codigoCuota", cascade = CascadeType.ALL)
    private List<Cuotas> cuotas = new ArrayList<>();

    @OneToOne
    @JoinColumn(name="numapartamento", referencedColumnName = "numapartamento")
    private Apartamento apartamento;	
        
}

package hn.proyecto.apartamentos.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="duenos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Duenos {
    								
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)  
    @Column(name="iddueno")
    private int idDueno;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="apellido")
    private String apellido;
    
    @Column(name="telefono")	
    private String telefono;
    
    @Column(name="correo")
    private String correo;
    
    @OneToMany(mappedBy = "numapartamento", cascade = CascadeType.ALL)
    private List<Apartamento> apartamentos = new ArrayList<>();
        
}

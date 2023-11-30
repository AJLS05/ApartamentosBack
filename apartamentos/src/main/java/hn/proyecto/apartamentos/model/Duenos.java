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
    @Column(name="IdDueno")
    private int IdDueno;
    
    @Column(name="Nombre")
    private String Nombre;
    
    @Column(name="Apellido")
    private String Apellido;
    
    @Column(name="Telefono")	
    private String Telefono;
    
    @Column(name="Correo")
    private String Correo;
    
    @OneToMany(mappedBy = "numApartamento", cascade = CascadeType.ALL)
    private List<Apartamento> Apartamentos = new ArrayList<>();
        
}

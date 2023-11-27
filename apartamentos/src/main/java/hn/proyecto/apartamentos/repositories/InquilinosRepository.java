package hn.proyecto.apartamentos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import hn.proyecto.apartamentos.model.Inquilinos;


public interface InquilinosRepository extends JpaRepository<Inquilinos, Integer>{
    
}
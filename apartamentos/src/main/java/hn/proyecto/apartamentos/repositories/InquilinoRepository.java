package hn.proyecto.apartamentos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import hn.proyecto.apartamentos.model.Inquilino;


public interface InquilinoRepository extends JpaRepository<Inquilino, Integer>{
    
}
package hn.proyecto.apartamentos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.proyecto.apartamentos.model.Apartamento;

public interface ApartamentoRepository extends JpaRepository<Apartamento, Integer> {
    
}
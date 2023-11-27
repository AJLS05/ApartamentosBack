package hn.proyecto.apartamentos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.proyecto.apartamentos.model.Cuotas;

public interface CuotasRepository extends JpaRepository<Cuotas, Integer> {

}
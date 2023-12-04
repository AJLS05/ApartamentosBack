package hn.proyecto.apartamentos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.proyecto.apartamentos.model.Cuota;

public interface CuotasRepository extends JpaRepository<Cuota, Integer> {

}
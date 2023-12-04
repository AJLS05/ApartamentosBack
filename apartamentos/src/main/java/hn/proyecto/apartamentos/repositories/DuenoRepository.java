package hn.proyecto.apartamentos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.proyecto.apartamentos.model.Dueno;

public interface DuenoRepository extends JpaRepository<Dueno, Integer>{}
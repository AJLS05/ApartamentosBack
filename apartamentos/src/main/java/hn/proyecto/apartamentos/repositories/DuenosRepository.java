package hn.proyecto.apartamentos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.proyecto.apartamentos.model.Dueno;

public interface DuenosRepository extends JpaRepository<Dueno, Integer>{}
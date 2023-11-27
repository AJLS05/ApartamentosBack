package hn.proyecto.apartamentos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.proyecto.apartamentos.model.Duenos;

public interface DuenosRepository extends JpaRepository<Duenos, Integer>{}
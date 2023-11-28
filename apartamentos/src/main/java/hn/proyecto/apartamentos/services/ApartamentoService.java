package hn.proyecto.apartamentos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import hn.proyecto.apartamentos.model.Apartamento;
import hn.proyecto.apartamentos.model.Duenos;
import hn.proyecto.apartamentos.model.Inquilinos;

/**
 * ApartamentoService
 */
@Service
public interface ApartamentoService {

    public Apartamento crearApartamento(Apartamento nvoApartamento, Duenos Dueno);

    public Apartamento obtenerApartamentoPorNum(int numApartamento);

    public String eliminarApartamentoPorNum(int numApartamento);

    public List<Apartamento> obtenerTodosApartamentos();

    public String agregarInquilino(int numApartamento, Inquilinos inquilino);
}
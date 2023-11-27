package hn.proyecto.apartamentos.services;

import java.util.List;

import hn.proyecto.apartamentos.model.Apartamento;
import hn.proyecto.apartamentos.model.Inquilinos;

/**
 * ApartamentoService
 */
public interface ApartamentoService {

    public Apartamento crearApartamento(Apartamento nvoApartamento);

    public Apartamento obtenerApartamentoPorNum(int numApartamento);

    public String eliminarApartamentoPorNum(int numApartamento);

    public List<Apartamento> obtenerTodosApartamentos();

    public String agregarInquilino(int numApartamento, Inquilinos inquilino);
}
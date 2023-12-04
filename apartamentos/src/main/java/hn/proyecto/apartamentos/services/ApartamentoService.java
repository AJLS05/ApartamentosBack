package hn.proyecto.apartamentos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import hn.proyecto.apartamentos.model.Apartamento;
import hn.proyecto.apartamentos.model.Inquilino;

/**
 * ApartamentoService
 */
@Service
public interface ApartamentoService {

    public Apartamento crearApartamento(Apartamento nvoApartamento);

    public Apartamento obtenerApartamentoPorNum(int numApartamento);

    public String eliminarApartamentoPorNum(int numApartamento);

    public List<Apartamento> obtenerTodosApartamentos();

    public String agregarInquilino(int numApartamento, int idInquilino);

    public String agregarDueno(int numApartamento, int idDueno);

}
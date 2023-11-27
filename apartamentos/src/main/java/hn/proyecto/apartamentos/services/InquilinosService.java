package hn.proyecto.apartamentos.services;

import java.util.List;

import hn.proyecto.apartamentos.model.Inquilinos;

public interface InquilinosService {
    public Inquilinos crearInquilino(Inquilinos nvoInquilino);

    public Inquilinos obtenerInquilino(int codigoInquilino);

    public String eliminarInquilino(int codigoInquilino);

    public List<Inquilinos> obtenerTodosInquilinos();
}

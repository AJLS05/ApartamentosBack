package hn.proyecto.apartamentos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import hn.proyecto.apartamentos.model.Inquilinos;
@Service
public interface InquilinosService {
    public Inquilinos crearInquilino(Inquilinos nvoInquilino);

    public Inquilinos obtenerInquilino(int codigoInquilino);

    public String eliminarInquilino(int codigoInquilino);

    public List<Inquilinos> obtenerTodosInquilinos();
}

package hn.proyecto.apartamentos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import hn.proyecto.apartamentos.model.Apartamento;
import hn.proyecto.apartamentos.model.Inquilino;
@Service
public interface InquilinosService {
    public Inquilino crearInquilino(Inquilino nvoInquilino, Apartamento Apartamento);

    public Inquilino obtenerInquilino(int codigoInquilino);

    public String eliminarInquilino(int codigoInquilino);

    public List<Inquilino> obtenerTodosInquilinos();
}

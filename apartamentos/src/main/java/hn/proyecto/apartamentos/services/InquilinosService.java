package hn.proyecto.apartamentos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import hn.proyecto.apartamentos.model.Inquilino;
@Service
public interface InquilinosService {
    public Inquilino crearInquilino(Inquilino nvoInquilino);

    public Inquilino obtenerInquilino(int idInquilino);

    public String eliminarInquilino(int idInquilino);

    public List<Inquilino> obtenerTodosInquilinos();
}

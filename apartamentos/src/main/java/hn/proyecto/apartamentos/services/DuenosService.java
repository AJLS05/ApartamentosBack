package hn.proyecto.apartamentos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import hn.proyecto.apartamentos.model.Apartamento;
import hn.proyecto.apartamentos.model.Duenos;
@Service
public interface DuenosService {
    
    public Duenos crearDueno(Duenos nvoDueno);

    public Duenos obtenerDueno(int IdDueno);

    public String eliminarDueno(int IdDueno);

    public String agregarDuenoApp(int IdDueno, List<Apartamento> Apartamentos);

    public List<Duenos> obtenerTodosDuenos();

}

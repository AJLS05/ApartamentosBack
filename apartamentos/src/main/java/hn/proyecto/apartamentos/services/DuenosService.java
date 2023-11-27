package hn.proyecto.apartamentos.services;

import java.util.List;

import hn.proyecto.apartamentos.model.Apartamento;
import hn.proyecto.apartamentos.model.Duenos;

public interface DuenosService {
    
    public Duenos crearDueno(Duenos nvoDueno);

    public Duenos obtenerDueno(int IdDueno);

    public String eliminarDueno(int IdDueno);

    public String agregarDuenoApp(int IdDueno, Apartamento numApartamento);

    public List<Duenos> obtenerTodosDuenos();

}

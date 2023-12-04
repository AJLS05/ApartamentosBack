package hn.proyecto.apartamentos.services.Implements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.proyecto.apartamentos.model.Apartamento;
import hn.proyecto.apartamentos.model.Dueno;
import hn.proyecto.apartamentos.repositories.DuenoRepository;
import hn.proyecto.apartamentos.services.DuenosService;

@Service
public class DuenosServiceImpl implements DuenosService{

    @Autowired
    private DuenoRepository duenosRepository;

    @Override
    public Dueno crearDueno(Dueno nvoDueno) {
        return duenosRepository.save(nvoDueno);
    }

    @Override
    public Dueno obtenerDueno(int IdDueno) {
        return duenosRepository.findById(IdDueno).get();
    }

    @Override
    public String agregarDuenoApp(int IdDueno, List<Apartamento> Apartamentos) {
        Dueno DuenoAAgregar = duenosRepository.findById(IdDueno).get();

        if(DuenoAAgregar != null){
            DuenoAAgregar.setApartamentos(Apartamentos);
            
            this.duenosRepository.save(DuenoAAgregar);
            return "Se ha Agregado el Dueno: " +DuenoAAgregar.getIdDueno()+" al apartamento "+Apartamentos;
        }

        return "No existe el apartamento con num: " + Apartamentos;
    }

    @Override
    public String eliminarDueno(int IdDueno) {
        Dueno AppEliminar = this.duenosRepository.findById(IdDueno).get();

        if(AppEliminar != null){
            this.duenosRepository.delete(AppEliminar);
            return "Se ha eliminado el Dueno: " + AppEliminar.getIdDueno(); 
        }

        return "No existe el Dueno con ID: " + IdDueno;
    }

    @Override
    public List<Dueno> obtenerTodosDuenos() {
        return this.duenosRepository.findAll();
    }
    
}

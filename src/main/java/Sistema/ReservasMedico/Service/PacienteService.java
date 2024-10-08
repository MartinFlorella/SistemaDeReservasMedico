package Sistema.ReservasMedico.Service;

import Sistema.ReservasMedico.Exceptions.DatabaseOperationException;
import Sistema.ReservasMedico.Exceptions.EntityNotFoundException;
import Sistema.ReservasMedico.Model.Paciente;
import Sistema.ReservasMedico.Repository.PacienteRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

public class PacienteService implements IPacienteService {

    @Autowired
    private PacienteRepository pacienteRepo;
    
    @Override
    public Paciente crearPaciente(Paciente paciente) {
        try{
       return pacienteRepo.save(paciente);
        }catch(DataAccessException e){
            throw new DatabaseOperationException("Error al guardar el Paciente.", e);
        }
         
    
    }

    @Override
    public Paciente obtenerPacientePorId(Long id) {

      return pacienteRepo.findById(id).orElseThrow(() -> 
            new EntityNotFoundException("Paciente con id " + id + " no encontrado."));
        
    
    }

    @Override
    public List<Paciente> obtenerTodosLosPacientes() {
       try{
        List<Paciente> listaPacientes = pacienteRepo.findAll();
        if(listaPacientes.isEmpty()){
            throw new EntityNotFoundException("No se encontraron Pacientes en la base de datos.");
        
       }
       return listaPacientes;
       
       }catch(DataAccessException e){
            throw new DatabaseOperationException("Error al obtener la lista de Pacientes.", e);
       }
    
    }

    @Override
    public void eliminarPaciente(Long id) {

        if (pacienteRepo.existsById(id)) {
            
            try{
            pacienteRepo.deleteById(id);
            }catch(DataAccessException e){
                throw new DatabaseOperationException("Error al eliminar paciente con id:  "+ id , e );
            }
        } else {
            throw new EntityNotFoundException("Paciente con id " + id + " no encontrado.");
        }
    
    }
    
     
    
}

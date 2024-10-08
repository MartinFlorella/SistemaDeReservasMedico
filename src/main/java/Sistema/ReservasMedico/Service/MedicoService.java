package Sistema.ReservasMedico.Service;

import Sistema.ReservasMedico.Exceptions.DatabaseOperationException;
import Sistema.ReservasMedico.Exceptions.EntityNotFoundException;
import Sistema.ReservasMedico.Model.Medico;
import Sistema.ReservasMedico.Repository.MedicoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class MedicoService implements IMedicoService{

    @Autowired
    private MedicoRepository medicoRepo;
    
    @Override
    public Medico crearMedico(Medico medico) {

      try {
            
          return medicoRepo.save(medico);
          } catch (DataAccessException e) {   
            throw new DatabaseOperationException("Error al guardar el médico.", e);
        }
    }

    @Override
    public Medico obtenerMedicoPorId(Long id) {
        
      return  medicoRepo.findById(id).orElseThrow(() -> 
            new EntityNotFoundException("Médico con id " + id + " no encontrado."));
        
   

    }

    @Override
    public List<Medico> obtenerTodosLosMedicos() {
        try{
        List<Medico> listaMedicos = medicoRepo.findAll();
        if(listaMedicos.isEmpty()){
        throw new EntityNotFoundException("No se encontraron médicos en la base de datos.");
        }
        
            return listaMedicos;
        }catch(DataAccessException e){
            throw new DatabaseOperationException("Error al obtener la lista de médicos.", e);
        }
        }

    @Override
    public void eliminarMedico(Long id) {
    if (medicoRepo.existsById(id)) {
            try {
                medicoRepo.deleteById(id);
            } catch (DataAccessException e) {
                throw new DatabaseOperationException("Error al eliminar el médico con id " + id, e);
            }
        } else {
            throw new EntityNotFoundException("Médico con id " + id + " no encontrado.");
        }
    
}
}
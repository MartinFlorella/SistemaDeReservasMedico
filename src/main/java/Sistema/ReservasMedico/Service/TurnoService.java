
package Sistema.ReservasMedico.Service;

import Sistema.ReservasMedico.Exceptions.DatabaseOperationException;
import Sistema.ReservasMedico.Exceptions.EntityNotFoundException;
import Sistema.ReservasMedico.Model.Turno;
import Sistema.ReservasMedico.Repository.TurnoRepository;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class TurnoService implements ITurnoService{
    
    @Autowired
    private TurnoRepository turnoRepo;

    @Override
    public String RegistrarTurno(Turno turno) {
            //Verificar si existe el paciente y el medico
            if(turno.getPaciente() == null  || turno.getMedico() == null ){
                throw new EntityNotFoundException("El paciente o el medico no fueron encontrados");

            }
            //Verifica que no se pisan las fechas 
            List<Turno> listaTurnos = turnoRepo.findAll();
            for(Turno turno_For : listaTurnos){
            if(haySuperposicion(turno.getFechaHora()  , turno_For.getFechaHora())){
                 throw new EntityNotFoundException("Fecha de el turno No disponible");
            }
            }
            
            
            turnoRepo.save(turno);
            return "Turno Registrado Fecha: " + turno.getFechaHora() + "Con el Medico:  " + turno.getMedico().getNombre();
            
    }

    @Override
    public Turno obtenerTurnoPorId(Long id) {

        return turnoRepo.findById(id).orElseThrow(()-> 
    new EntityNotFoundException("El turno con id" + "no fue encontrado"));
    }

    @Override
    public List<Turno> obtenerTodosLosTurno() {
try{
    List<Turno> listaTurnos = turnoRepo.findAll();
            if(listaTurnos.isEmpty()){
                throw new EntityNotFoundException("No se encontraron turnos en la lista");
            }
            return listaTurnos;
            }catch(DataAccessException e){
               throw new DatabaseOperationException("Error al traer la lista de turnos", e);
            }
                
    }

    @Override
    public void eliminarTurno(Long id) {

    if(turnoRepo.existsById(id)){
        try{
            turnoRepo.deleteById(id);
        }catch(DataAccessException e){
            throw new DatabaseOperationException("Error al eliminar el turno", e);
        }
        
    } else{
         throw new EntityNotFoundException("Turno con id " + id + " no encontrado.");
    }
    
    }
    
    public boolean haySuperposicion(LocalDateTime nuevaFechaHora, LocalDateTime existenteFechaHora) {
    // Definir la duración de un turno
    Duration duracionTurno = Duration.ofHours(1);
    
    // Calcular el rango del turno existente
    LocalDateTime inicioExistente = existenteFechaHora;
    LocalDateTime finExistente = existenteFechaHora.plus(duracionTurno);
    
    // Calcular el rango del nuevo turno
    LocalDateTime inicioNuevo = nuevaFechaHora;
    LocalDateTime finNuevo = nuevaFechaHora.plus(duracionTurno);
    
    // Verificar si los rangos se superponen
    return inicioNuevo.isBefore(finExistente) && finNuevo.isAfter(inicioExistente);
}
}

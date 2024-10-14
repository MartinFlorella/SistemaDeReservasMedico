
package Sistema.ReservasMedico.Service;

import Sistema.ReservasMedico.Model.Paciente;
import Sistema.ReservasMedico.Model.Turno;
import java.time.LocalDateTime;
import java.util.List;

public interface ITurnoService {
        
    //Sacar un turno
    
    public String registrarTurno (Turno turno);
    
     Turno obtenerTurnoPorId(Long id);
    
     List<Turno> obtenerTodosLosTurnos();
     
     void eliminarTurno(Long id);
     
     public boolean haySuperposicion(LocalDateTime nuevaFechaHora, LocalDateTime existenteFechaHora);
}

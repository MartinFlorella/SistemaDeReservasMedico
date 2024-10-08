
package Sistema.ReservasMedico.Service;

import Sistema.ReservasMedico.Model.Paciente;
import java.util.List;

public interface IPacienteService {
     
    
     Paciente crearPaciente(Paciente paciente);
    
     Paciente obtenerPacientePorId(Long id);
    
     List<Paciente> obtenerTodosLosPacientes();
     
     void eliminarPaciente(Long id);
}

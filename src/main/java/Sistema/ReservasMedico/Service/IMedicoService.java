
package Sistema.ReservasMedico.Service;

import Sistema.ReservasMedico.Model.Medico;
import java.util.List;

public interface IMedicoService {
    
        Medico crearMedico(Medico medico);
        Medico obtenerMedicoPorId(Long id);
        List<Medico> obtenerTodosLosMedicos();
        void eliminarMedico(Long id);

}

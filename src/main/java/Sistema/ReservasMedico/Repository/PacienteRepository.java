
package Sistema.ReservasMedico.Repository;

import Sistema.ReservasMedico.Model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository <Paciente , Long>{
    
}

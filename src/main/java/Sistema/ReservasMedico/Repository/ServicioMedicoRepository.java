
package Sistema.ReservasMedico.Repository;

import Sistema.ReservasMedico.Model.ServicioMedico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioMedicoRepository extends JpaRepository <ServicioMedico, Long> {
    
}

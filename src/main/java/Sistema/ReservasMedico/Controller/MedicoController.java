
package Sistema.ReservasMedico.Controller;

import Sistema.ReservasMedico.Model.Medico;
import Sistema.ReservasMedico.Service.MedicoService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MedicoController {
     @Autowired
    private MedicoService medicoServi;
    
    
    @PostMapping("medico/crear")
    public String registrarMedico(@RequestBody @Valid Medico medico){
        
            medicoServi.crearMedico(medico);
            return "Medico Registrado con exito";
    }
    
    @GetMapping("medicos/traer")
    public List <Medico> traerMedicos(){
        return medicoServi.obtenerTodosLosMedicos();
    }
    
    @DeleteMapping("medico/borrar/{idMedico}")
    public void borrarMedico(@PathVariable Long idMedico){
        medicoServi.eliminarMedico(idMedico);
        
    }
}

package Sistema.ReservasMedico.Controller;

import Sistema.ReservasMedico.Model.Paciente;
import Sistema.ReservasMedico.Service.IPacienteService;
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
public class PacienteController {
    
    @Autowired
    private IPacienteService pacienteServi;
    
    
    @PostMapping("paciente/crear")
    public String registrarPaciente(@RequestBody @Valid Paciente paciente){
        
            pacienteServi.crearPaciente(paciente);
            return "Paciente Registrado con exito";
    }
    
    @GetMapping("pacientes/traer")
    public List <Paciente> traerPacientes(){
        return pacienteServi.obtenerTodosLosPacientes();
    }
    
    @DeleteMapping("paciente/borrar/{idPaciente}")
    public void borrarPaciente(@PathVariable Long idPaciente){
        pacienteServi.eliminarPaciente(idPaciente);
        
    }
    
}


package Sistema.ReservasMedico.Controller;

import Sistema.ReservasMedico.Model.Turno;
import Sistema.ReservasMedico.Service.ITurnoService;
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
public class TurnoController {
    
     @Autowired
    private ITurnoService turnoServi;
    
    @PostMapping("turno/crear")
    public String registrarTurno(@RequestBody @Valid Turno turno){
     return   turnoServi.registrarTurno(turno);
      
    }
    
    @GetMapping("/turno/traer")
    public List <Turno> traerTurnos(){
        return turnoServi.obtenerTodosLosTurnos();
    }
    
    @DeleteMapping("turno/borrar/{idTurno}")
    public String borrarTurno(@PathVariable long idTurno){
        turnoServi.eliminarTurno(idTurno);
        return "Turno Eliminado";
    }  
}

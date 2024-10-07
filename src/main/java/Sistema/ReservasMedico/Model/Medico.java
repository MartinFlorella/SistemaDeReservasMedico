
package Sistema.ReservasMedico.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Getter@Setter
@Entity
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String especialidad;
    private String telefono;
    private String horarioAtencion; // Horario en formato String o crear una clase específica para horarios

    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL)
    private List<Turno> turnos;

    public Medico() {
    }

    public Medico(Long id, String nombre, String especialidad, String telefono, String horarioAtencion, List<Turno> turnos) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.telefono = telefono;
        this.horarioAtencion = horarioAtencion;
        this.turnos = turnos;
    }

   
}

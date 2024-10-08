
package Sistema.ReservasMedico.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Getter@Setter
@Entity
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    private String nombre;
    @NotBlank
    private String especialidad;
    @Min(6)@Max(8)
    private String telefono;
    private String horarioAtencion; // Horario en formato String o crear una clase específica para horarios
    
    @JsonIgnore
    @OneToMany(mappedBy = "medico")
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

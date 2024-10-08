
package Sistema.ReservasMedico.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    private String dni;
    private String telefono;
    private String direccion;
    
    @JsonIgnore
    @OneToMany(mappedBy = "paciente")
    private List<Turno> turnos;

    public Paciente() {
    }

    public Paciente(Long id, String nombre, String dni, String telefono, String direccion, List<Turno> turnos) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.direccion = direccion;
        this.turnos = turnos;
    }

    
}


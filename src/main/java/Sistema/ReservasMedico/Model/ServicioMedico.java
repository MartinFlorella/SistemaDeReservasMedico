
package Sistema.ReservasMedico.Model;

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
public class ServicioMedico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private double precio;
    private int duracionMinutos; // Duración del servicio

    @OneToMany(mappedBy = "servicioMedico")
    private List<Turno> turnos;

    public ServicioMedico() {
    }

    public ServicioMedico(Long id, String nombre, double precio, int duracionMinutos, List<Turno> turnos) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.duracionMinutos = duracionMinutos;
        this.turnos = turnos;
    }
    
    

}

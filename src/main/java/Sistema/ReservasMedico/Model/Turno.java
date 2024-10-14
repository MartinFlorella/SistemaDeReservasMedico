package Sistema.ReservasMedico.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Future;


import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    @Valid
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    @Valid
    private Medico medico;
    
    @Future
    private LocalDateTime fechaHora; // Fecha y hora del turno
    
    private ServicioMedico servicio;  // Nombre del servicio médico
    private boolean confirmado; // Para marcar si el turno fue confirmado o no
    

    public Turno() {
    }

    public Turno(Long id, Paciente paciente, Medico medico, LocalDateTime fechaHora, ServicioMedico servicio, boolean confirmado) {
        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
        this.fechaHora = fechaHora;
        this.servicio = servicio;
        this.confirmado = confirmado;
    }

    
    


    
    
    
}

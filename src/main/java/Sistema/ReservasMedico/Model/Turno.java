package Sistema.ReservasMedico.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

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
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    private LocalDateTime fechaHora; // Fecha y hora del turno

    private String servicio; // Nombre del servicio médico
    private boolean confirmado; // Para marcar si el turno fue confirmado o no
    
    @OneToOne
    private ServicioMedico serviMedico;
    
    public Turno() {
    }

    public Turno(Long id, Paciente paciente, Medico medico, LocalDateTime fechaHora, String servicio, boolean confirmado, ServicioMedico serviMedico) {
        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
        this.fechaHora = fechaHora;
        this.servicio = servicio;
        this.confirmado = confirmado;
        this.serviMedico = serviMedico;
    }


    
    
    
}

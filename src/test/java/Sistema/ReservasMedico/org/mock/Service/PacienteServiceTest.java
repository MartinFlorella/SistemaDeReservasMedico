
package Sistema.ReservasMedico.org.mock.Service;

import Sistema.ReservasMedico.Exceptions.DatabaseOperationException;
import Sistema.ReservasMedico.Model.Paciente;
import Sistema.ReservasMedico.Repository.PacienteRepository;
import Sistema.ReservasMedico.Service.IPacienteService;
import Sistema.ReservasMedico.Service.PacienteService;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import org.springframework.dao.DataAccessException;

public class PacienteServiceTest {
    
    
    

 @Test
    public void testCrearPaciente() {
        Paciente paciente = new Paciente(1L, "Leonel Messi", "45318322", "28713779", "12 de octubre");

        // Simulamos el comportamiento del repositorio al guardar el paciente
        when(pacienteRepo.save(paciente)).thenReturn(paciente);

        // Probamos el método real del servicio
        Paciente pacienteTest = pacienteService.crearPaciente(paciente);

        // Verificaciones
        assertNotNull(pacienteTest);
        assertEquals("Leonel Messi", pacienteTest.getNombre());
        assertEquals("28713779", pacienteTest.getTelefono());
        assertEquals("45318322", pacienteTest.getDni());
    }
    
     private PacienteRepository pacienteRepo;  // Simulamos el repositorio
    private PacienteService pacienteService;  // Creamos el servicio manualmente
    
@BeforeEach
    public void setUp() {
        pacienteRepo = mock(PacienteRepository.class);  // Creamos el mock del repositorio
        pacienteService = new PacienteService(pacienteRepo);  // Inyectamos el mock en el servicio
    }
    @Test
    public void testCrearPacienteLanzaDatabaseOperationException() {
        // given
        Paciente paciente = new Paciente(1L, "Lionel Messi", "45318322", "28713779", "12 de octubre");

        // Simulamos una excepción en el repositorio al intentar guardar el paciente
        Mockito.when(pacienteRepo.save(paciente)).thenThrow(new DataAccessException("Error de acceso a la base de datos") {});

        // when & then
        DatabaseOperationException exception = assertThrows(DatabaseOperationException.class, () -> {
            pacienteService.crearPaciente(paciente);  // Llamamos al método que debería lanzar la excepción
        });

        // Verificamos el mensaje de la excepción
        assertEquals("Error al guardar el Paciente.", exception.getMessage());
    }

}
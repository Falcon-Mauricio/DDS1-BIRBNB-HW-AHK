package dds.birbnb_ahk.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class Reserva {
    private LocalDate fechaAlta;
    private Usuario usuario;
    private Alojamiento alojamiento;
    private RangoFecha reangoFechas;
    private EstadoReserva estado;
    private Double precioPorNoche;

    public void actualizarEstado(EstadoReserva estado){
        this.estado = estado;
        //TODO Pendiente de ser guardado
        Notificacion notificacion = new FactoryNotification().crearSegunReseva(this);
    }

}
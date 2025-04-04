package dds.birbnb_ahk.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class RangoFecha {
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public boolean haySuperposicionCon(RangoFecha rangoDeLaReserva) {
        return this.fechaInicio.isBefore(rangoDeLaReserva.getFechaFin())
                &&
                this.fechaFin.isBefore(rangoDeLaReserva.getFechaFin());
    }
}
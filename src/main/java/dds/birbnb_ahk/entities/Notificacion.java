package dds.birbnb_ahk.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Notificacion {
    private String mensaje;
    private Usuario usuario;
    private LocalDate fechaAlta;
    private Boolean leida;
    private LocalDate fechaLeida;

    public Notificacion(){
        this.leida = false;
        this.fechaAlta = LocalDate.now();
    }

    public void marcarComoLeida(){
        this.leida = true;
        this.fechaLeida = LocalDate.now();
    }
}
package dds.birbnb_ahk.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Alojamiento {
    @Setter
    @Getter
    private Usuario usuario;

    @Setter
    @Getter
    private String nombre;

    @Setter
    @Getter
    private String descripcion;

    @Setter
    @Getter
    private Double precioPorNoche;

    @Setter
    @Getter
    private Moneda moneda;

    @Setter
    @Getter
    private LocalTime horarioCheckin;

    @Setter
    @Getter
    private LocalTime horarioCheckOut;

    @Setter
    @Getter
    private Integer cantHuespedesMax;

    @Getter
    private List<Reserva> reservas;

    @Getter
    private List<Caracteristica> caracteristicas;

    @Getter
    private List<Foto> fotos;

    public Alojamiento(){
        this.fotos = new ArrayList<>();
        this.caracteristicas = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public Boolean tuPrecioEstaDentroDe(Double valorMin, Double valorMax){
        return this.precioPorNoche < valorMax && this.precioPorNoche > valorMin;
    }

    public Boolean estasDispinibleEn(RangoFecha RangoDeFechas){
        /* boolean haySuperposicion = false;
        int i= 0;
        while(i < this.reservas.size() && !haySuperposicion){
            Reserva reserva = this.reservas.get(i);
            RangoFecha rangoDeLaReserva = reserva.getReangoFechas();

            if (rangoDeLaReserva.haySuperposicionCon(rangoDeLaReserva)){
                haySuperposicion = true;
            }
            i++;
        }

        return haySuperposicion;
        */
        return this.reservas.stream().anyMatch(r ->r.getReangoFechas().haySuperposicionCon(RangoDeFechas));
    }

    public Boolean tenesCaracteristica(Caracteristica caracteristica){
        return caracteristicas.contains(caracteristica);
    }

    public Boolean puedenAlojarse(Integer cantHuespedes){
        return cantHuespedes <= this.cantHuespedesMax;
    }
}
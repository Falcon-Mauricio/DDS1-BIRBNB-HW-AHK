package dds.birbnb_ahk.entities;

public class FactoryNotification {

    private String crearMensaje(Reserva reserva){
        return switch (reserva.getEstado()){
            case PENDIENTE -> "Tenes una reserva de " + reserva.getUsuario().getNombre()
                    + ", para el alojamiento" + reserva.getAlojamiento().getNombre()
                    + " hasta el dia" + reserva.getReangoFechas().getFechaFin().toString()
                    + ".";
            case CONFIRMADA -> "La reserva para el alojamiento " + reserva.getUsuario().getNombre()
                    + ", desde el dia" + reserva.getReangoFechas().getFechaInicio().toString()
                    + " hasta el dia" + reserva.getReangoFechas().getFechaFin().toString()
                    + "Fue confirmada.";
            case CANCELADA -> "La reserva de " + reserva.getUsuario().getNombre()
                    + ", para el alojamiento" + reserva.getAlojamiento().getNombre()
                    + ", desde el dia" + reserva.getReangoFechas().getFechaInicio().toString()
                    + " hasta el dia" + reserva.getReangoFechas().getFechaFin().toString()
                    + " fue CANCELADA.";
        };
    }

    public Notificacion crearSegunReseva(Reserva reserva){
        Notificacion noti = new Notificacion();
        if (reserva.getEstado().equals(EstadoReserva.PENDIENTE)){
            noti.setUsuario(reserva.getAlojamiento().getUsuario());
        }
        else if (reserva.getEstado().equals(EstadoReserva.CONFIRMADA)){
            noti.setUsuario(reserva.getUsuario());
        }
        else if (reserva.getEstado().equals(EstadoReserva.CANCELADA)){
            noti.setUsuario(reserva.getAlojamiento().getUsuario());
        }

        return crearMensaje(reserva);
    }
}
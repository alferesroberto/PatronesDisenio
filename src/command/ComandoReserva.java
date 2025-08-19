package command;

import builder.Reserva;
import singleton.SistemaReservas;

public class ComandoReserva implements Comando {
    private Reserva reserva;
    public ComandoReserva(Reserva reserva) {
        this.reserva = reserva;
    }
    public void ejecutar() {
        SistemaReservas.getInstancia().procesarReserva(reserva);
    }
}
package facade;

import builder.Reserva;
import factory.ServicioFactory;
import factory.ServicioReserva;
import observer.Notificador;
import singleton.SistemaReservas;

// --- Facade ---
public class FachadaReservas {
    public void realizarReservaCompleta(String cliente, String tipo, boolean seguro, boolean extra) {
        ServicioReserva servicio = ServicioFactory.crearServicio(tipo);
        Reserva reserva = new Reserva.Builder(cliente, servicio.getTipo())
                .conSeguro()
                .conServicioExtra()
                .build();

        SistemaReservas.getInstancia().procesarReserva(reserva);
        new Notificador().registrar(cliente);
    }
}
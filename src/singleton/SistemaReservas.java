package singleton;

import builder.Reserva;

// --- Singleton ---
public class SistemaReservas {
    private static SistemaReservas instancia;

    private SistemaReservas() {}

    public static synchronized SistemaReservas getInstancia() {
        if (instancia == null) instancia = new SistemaReservas();
        return instancia;
    }

    public void procesarReserva(Reserva reserva) {
        System.out.println("Procesando: " + reserva);
    }
}
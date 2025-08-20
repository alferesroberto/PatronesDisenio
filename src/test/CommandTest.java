package test;

import builder.Reserva;
import command.Comando;
import command.ComandoReserva;
import org.junit.Test;

public class CommandTest {

    @Test
    public void testComandoReservaEjecutar() {
        Reserva reserva = new Reserva.Builder("Mario", "Vuelo").build();
        Comando comando = new ComandoReserva(reserva);
        comando.ejecutar(); // Se valida que no falle
    }
}
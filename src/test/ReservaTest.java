package test;

import builder.Reserva;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReservaTest {

    @Test
    public void testReservaBuilderConSeguroYExtra() {
        Reserva reserva = new Reserva.Builder("Ana", "Vuelo")
                .conSeguro()
                .conServicioExtra()
                .build();

        assertEquals("Reserva de Ana para Vuelo + Seguro + Servicio Extra", reserva.toString());
    }
}
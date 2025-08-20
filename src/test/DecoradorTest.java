package test;

import decorator.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class DecoradorTest {

    @Test
    public void testDecoratorReservaConSeguroYExtra() {
        ReservaBase reserva = new ReservaSimple();
        reserva = new SeguroDecorator(reserva);
        reserva = new ExtraDecorator(reserva);
        assertEquals("Reserva básica + Seguro + Extra", reserva.getDescripcion());
    }
}
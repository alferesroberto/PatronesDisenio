package test;

import singleton.SistemaReservas;
import org.junit.Test;
import static org.junit.Assert.*;

public class SistemaReservasTest {

    @Test
    public void testSingletonUnicaInstancia() {
        SistemaReservas s1 = SistemaReservas.getInstancia();
        SistemaReservas s2 = SistemaReservas.getInstancia();
        assertSame(s1, s2);
    }
}
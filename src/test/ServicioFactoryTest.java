package test;

import factory.ServicioFactory;
import factory.ServicioReserva;
import org.junit.Test;
import static org.junit.Assert.*;

public class ServicioFactoryTest {

    @Test
    public void testFactoryCreaServicioHotel() {
        ServicioReserva servicio = ServicioFactory.crearServicio("hotel");
        assertEquals("Hotel", servicio.getTipo());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFactoryTipoNoSoportado() {
        ServicioFactory.crearServicio("barco");
    }
}
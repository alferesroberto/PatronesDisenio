package test;

import strategy.MetodoPago;
import strategy.PagoTarjeta;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class StrategyTest {

    @Test
    public void testPagoTarjeta() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        MetodoPago pago = new PagoTarjeta();
        pago.pagar(200.0);

        String salida = outContent.toString();
        assertTrue(salida.contains("Pagando 200.0 con tarjeta"));

        System.setOut(System.out);
    }
}
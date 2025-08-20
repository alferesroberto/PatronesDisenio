package test;

import facade.FachadaReservas;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class FachadaReservasTest {

    @Test
    public void testFachadaReservaCompleta() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        FachadaReservas fachada = new FachadaReservas();
        fachada.realizarReservaCompleta("Luis", "Auto", true, false);

        String salida = outContent.toString();
        assertTrue(salida.contains("Procesando: Reserva de Luis para Alquiler de Auto + Seguro"));

        System.setOut(System.out); // Restaurar salida
    }
}
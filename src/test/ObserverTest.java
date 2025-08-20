package test;

import observer.Notificador;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class ObserverTest {

    @Test
    public void testNotificador() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Notificador notificador = new Notificador();
        notificador.registrar("Pedro");

        String salida = outContent.toString();
        assertTrue(salida.contains("Notificando a Pedro: Reserva realizada con éxito"));

        System.setOut(System.out);
    }
}
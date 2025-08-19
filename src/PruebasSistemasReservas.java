

import adapter.AdapterReservadorHotel;
import adapter.ReservadorExterno;
import adapter.ReservadorHotelExterno;
import builder.Reserva;
import command.Comando;
import command.ComandoReserva;
import factory.ServicioFactory;
import factory.ServicioReserva;
import observer.Notificador;
import singleton.SistemaReservas;
import strategy.MetodoPago;
import strategy.PagoPaypal;

import java.util.*;

public class PruebasSistemasReservas {

    private int pruebasRealizadas = 0;
    private int pruebasExitosas = 0;
    private int pruebasFallidas = 0;

    public static void main(String[] args) {
        PruebasSistemasReservas tester = new PruebasSistemasReservas();

        tester.probarSingleton();
        tester.probarFactoryMethod();
        tester.probarBuilder();
        tester.probarAdapter();
        tester.probarStrategy();
        tester.probarObserver();
        tester.probarCommand();

        tester.mostrarResumen();
    }

    private void probarOperacion(String descripcion, boolean resultado, boolean esperado) {
        pruebasRealizadas++;
        if (resultado == esperado) {
            pruebasExitosas++;
            System.out.println("✓ " + descripcion + " - ÉXITO");
        } else {
            pruebasFallidas++;
            System.out.println("✗ " + descripcion + " - FALLO");
            System.out.println("  Resultado: " + resultado + " (Esperado: " + esperado + ")");
        }
    }

    private void probarSingleton() {
        SistemaReservas s1 = SistemaReservas.getInstancia();
        SistemaReservas s2 = SistemaReservas.getInstancia();
        probarOperacion("Singleton devuelve misma instancia", s1 == s2, true);
    }

    private void probarFactoryMethod() {
        ServicioReserva hotel = ServicioFactory.crearServicio("hotel");
        ServicioReserva vuelo = ServicioFactory.crearServicio("vuelo");
        ServicioReserva auto = ServicioFactory.crearServicio("auto");

        probarOperacion("Factory crea Hotel", hotel.getTipo().equals("Hotel"), true);
        probarOperacion("Factory crea Vuelo", vuelo.getTipo().equals("Vuelo"), true);
        probarOperacion("Factory crea Auto", auto.getTipo().equals("Alquiler de Auto"), true);
    }

    private void probarBuilder() {
        Reserva reserva = new Reserva.Builder("Pedro", "Hotel")
                .conSeguro()
                .conServicioExtra()
                .build();
        probarOperacion("Builder crea reserva con seguro y extra", reserva.toString().contains("Seguro") && reserva.toString().contains("Extra"), true);
    }

    private void probarAdapter() {
        ReservadorHotelExterno externo = new ReservadorHotelExterno();
        ReservadorExterno adaptado = new AdapterReservadorHotel(externo);

        try {
            adaptado.realizarReserva();
            probarOperacion("Adapter funciona correctamente", true, true);
        } catch (Exception e) {
            probarOperacion("Adapter funciona correctamente", false, true);
        }
    }

    private void probarStrategy() {
        MetodoPago pago = new PagoPaypal();
        try {
            pago.pagar(50.0);
            probarOperacion("Strategy ejecuta pago PayPal", true, true);
        } catch (Exception e) {
            probarOperacion("Strategy ejecuta pago PayPal", false, true);
        }
    }

    private void probarObserver() {
        Notificador notificador = new Notificador();
        try {
            notificador.registrar("Carlos");
            probarOperacion("Observer notifica correctamente", true, true);
        } catch (Exception e) {
            probarOperacion("Observer notifica correctamente", false, true);
        }
    }

    private void probarCommand() {
        Reserva reserva = new Reserva.Builder("Marta", "Auto").build();
        Comando comando = new ComandoReserva(reserva);
        try {
            comando.ejecutar();
            probarOperacion("Command ejecuta reserva", true, true);
        } catch (Exception e) {
            probarOperacion("Command ejecuta reserva", false, true);
        }
    }

    private void mostrarResumen() {
        System.out.println("\nResumen de pruebas:");
        System.out.println("Pruebas realizadas: " + pruebasRealizadas);
        System.out.println("Pruebas exitosas: " + pruebasExitosas);
        System.out.println("Pruebas fallidas: " + pruebasFallidas);
        double porcentaje = (double) pruebasExitosas / pruebasRealizadas * 100;
        System.out.printf("Porcentaje de éxito: %.2f%%\n", porcentaje);
    }
}

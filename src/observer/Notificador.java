package observer;

import java.util.ArrayList;
import java.util.List;

public class Notificador {
    List<Observador> observadores = new ArrayList<>();
    public void registrar(String cliente) {
        observadores.add(mensaje -> System.out.println("Notificando a " + cliente + ": " + mensaje));
        notificar("Reserva realizada con éxito");
    }
    public void notificar(String mensaje) {
        for (Observador o : observadores) o.actualizar(mensaje);
    }
}
package factory;

import factory.ServicioReserva;

public class ServicioFactory {
    public static ServicioReserva crearServicio(String tipo) {
        return switch (tipo.toLowerCase()) {
            case "hotel" -> new Hotel();
            case "vuelo" -> new Vuelo();
            case "auto" -> new Auto();
            default -> throw new IllegalArgumentException("Tipo no soportado");
        };
    }
}
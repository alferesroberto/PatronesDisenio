public class Main {
    public static void main(String[] args) {
        FachadaReservas fachada = new FachadaReservas();
        fachada.realizarReservaCompleta("Ana", "Hotel", true, true);

        ReservaBase reserva = new ReservaSimple();
        reserva = new SeguroDecorator(reserva);
        reserva = new ExtraDecorator(reserva);
        System.out.println(reserva.getDescripcion());

        MetodoPago pago = new PagoTarjeta();
        pago.pagar(120.0);

        Reserva reserva1 = new Reserva.Builder("Luis", "Vuelo").build();
        Comando comando = new ComandoReserva(reserva1);
        comando.ejecutar();
    }
}
package adapter;

public class AdapterReservadorHotel implements ReservadorExterno {
    private ReservadorHotelExterno externo;
    public AdapterReservadorHotel(ReservadorHotelExterno externo) {
        this.externo = externo;
    }
    public void realizarReserva() {
        externo.hacerReservaHotel();
    }
}
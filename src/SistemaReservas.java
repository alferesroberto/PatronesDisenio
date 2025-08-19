    // Manuel Alejandro Valdes Zuniga
    import java.util.ArrayList;
    import java.util.List;

    // --- Singleton ---
    class SistemaReservas {
        private static SistemaReservas instancia;

        private SistemaReservas() {}

        public static synchronized SistemaReservas getInstancia() {
            if (instancia == null) instancia = new SistemaReservas();
            return instancia;
        }

        public void procesarReserva(Reserva reserva) {
            System.out.println("Procesando: " + reserva);
        }
    }

    // --- Builder ---
    class Reserva {
        String cliente;
        String servicio;
        boolean seguro;
        boolean servicioExtra;

        private Reserva(Builder builder) {
            this.cliente = builder.cliente;
            this.servicio = builder.servicio;
            this.seguro = builder.seguro;
            this.servicioExtra = builder.servicioExtra;
        }

        public static class Builder {
            String cliente;
            String servicio;
            boolean seguro;
            boolean servicioExtra;

            public Builder(String cliente, String servicio) {
                this.cliente = cliente;
                this.servicio = servicio;
            }

            public Builder conSeguro() {
                this.seguro = true;
                return this;
            }

            public Builder conServicioExtra() {
                this.servicioExtra = true;
                return this;
            }

            public Reserva build() {
                return new Reserva(this);
            }
        }

        public String toString() {
            return "Reserva de " + cliente + " para " + servicio +
                    (seguro ? " + Seguro" : "") +
                    (servicioExtra ? " + Servicio Extra" : "");
        }
    }

    // --- Factory Method ---
    abstract class ServicioReserva {
        public abstract String getTipo();
    }
    class Hotel extends ServicioReserva {
        public String getTipo() { return "Hotel"; }
    }
    class Vuelo extends ServicioReserva {
        public String getTipo() { return "Vuelo"; }
    }
    class Auto extends ServicioReserva {
        public String getTipo() { return "Alquiler de Auto"; }
    }
    class ServicioFactory {
        public static ServicioReserva crearServicio(String tipo) {
            return switch (tipo.toLowerCase()) {
                case "hotel" -> new Hotel();
                case "vuelo" -> new Vuelo();
                case "auto" -> new Auto();
                default -> throw new IllegalArgumentException("Tipo no soportado");
            };
        }
    }

    // --- Adapter ---
    interface ReservadorExterno {
        void realizarReserva();
    }
    class ReservadorHotelExterno {
        public void hacerReservaHotel() {
            System.out.println("Reserva realizada con proveedor externo de hotel");
        }
    }
    class AdapterReservadorHotel implements ReservadorExterno {
        private ReservadorHotelExterno externo;
        public AdapterReservadorHotel(ReservadorHotelExterno externo) {
            this.externo = externo;
        }
        public void realizarReserva() {
            externo.hacerReservaHotel();
        }
    }

    // --- Facade ---
    class FachadaReservas {
        public void realizarReservaCompleta(String cliente, String tipo, boolean seguro, boolean extra) {
            ServicioReserva servicio = ServicioFactory.crearServicio(tipo);
            Reserva reserva = new Reserva.Builder(cliente, servicio.getTipo())
                    .conSeguro()
                    .conServicioExtra()
                    .build();

            SistemaReservas.getInstancia().procesarReserva(reserva);
            new Notificador().registrar(cliente);
        }
    }

    // --- Decorator ---
    interface ReservaBase {
        String getDescripcion();
    }
    class ReservaSimple implements ReservaBase {
        public String getDescripcion() {
            return "Reserva básica";
        }
    }
    abstract class ReservaDecorator implements ReservaBase {
        protected ReservaBase base;
        public ReservaDecorator(ReservaBase base) { this.base = base; }
    }
    class SeguroDecorator extends ReservaDecorator {
        public SeguroDecorator(ReservaBase base) { super(base); }
        public String getDescripcion() {
            return base.getDescripcion() + " + Seguro";
        }
    }
    class ExtraDecorator extends ReservaDecorator {
        public ExtraDecorator(ReservaBase base) { super(base); }
        public String getDescripcion() {
            return base.getDescripcion() + " + Extra";
        }
    }

    // --- Strategy ---
    interface MetodoPago {
        void pagar(double monto);
    }
    class PagoTarjeta implements MetodoPago {
        public void pagar(double monto) {
            System.out.println("Pagando " + monto + " con tarjeta");
        }
    }
    class PagoPaypal implements MetodoPago {
        public void pagar(double monto) {
            System.out.println("Pagando " + monto + " con PayPal");
        }
    }

    // --- Observer ---
    interface Observador {
        void actualizar(String mensaje);
    }
    class Notificador {
        List<Observador> observadores = new ArrayList<>();
        public void registrar(String cliente) {
            observadores.add(mensaje -> System.out.println("Notificando a " + cliente + ": " + mensaje));
            notificar("Reserva realizada con éxito");
        }
        public void notificar(String mensaje) {
            for (Observador o : observadores) o.actualizar(mensaje);
        }
    }

    // --- Command ---
    interface Comando {
        void ejecutar();
    }
    class ComandoReserva implements Comando {
        private Reserva reserva;
        public ComandoReserva(Reserva reserva) {
            this.reserva = reserva;
        }
        public void ejecutar() {
            SistemaReservas.getInstancia().procesarReserva(reserva);
        }
    }





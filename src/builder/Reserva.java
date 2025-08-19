package builder;

// --- Builder ---
public class Reserva {
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

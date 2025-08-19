package decorator;

public class ExtraDecorator extends ReservaDecorator {
    public ExtraDecorator(ReservaBase base) { super(base); }
    public String getDescripcion() {
        return base.getDescripcion() + " + Extra";
    }
}
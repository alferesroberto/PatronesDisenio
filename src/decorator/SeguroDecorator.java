package decorator;

public class SeguroDecorator extends ReservaDecorator {
    public SeguroDecorator(ReservaBase base) { super(base); }
    public String getDescripcion() {
        return base.getDescripcion() + " + Seguro";
    }
}
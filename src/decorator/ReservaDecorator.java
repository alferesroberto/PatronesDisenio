package decorator;

abstract class ReservaDecorator implements ReservaBase {
    protected ReservaBase base;
    public ReservaDecorator(ReservaBase base) { this.base = base; }
}
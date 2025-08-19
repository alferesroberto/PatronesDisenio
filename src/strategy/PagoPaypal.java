package strategy;

public class PagoPaypal implements MetodoPago {
    public void pagar(double monto) {
        System.out.println("Pagando " + monto + " con PayPal");
    }
}
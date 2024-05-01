package Trabalho;

public class Pagamento {
    private int id;
    private double valorPago;

    public Pagamento(int id, double valorPago) {
        this.id = id;
        this.valorPago = valorPago;
    }

    // Getters
    public int getId() {
        return id;
    }

    public double getValorPago() {
        return valorPago;
    }
}

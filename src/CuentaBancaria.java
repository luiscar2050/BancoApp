public class CuentaBancaria {
    private String titular;
    private double saldo;

    public CuentaBancaria(String titular) {
        this.titular = titular;
        this.saldo = 0.0;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void depositar(double monto) throws MontoNegativoException {
        if (monto < 0) {
            throw new MontoNegativoException("El monto a depositar no puede ser negativo.");
        }
        saldo += monto;
    }

    public void retirar(double monto) throws SaldoInsuficienteException, MontoNegativoException {
        if (monto < 0) {
            throw new MontoNegativoException("El monto a retirar no puede ser negativo.");
        }
        if (monto > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar la operación.");
        }
        saldo -= monto;
    }

    public void transferir(CuentaBancaria cuentaDestino, double monto) throws SaldoInsuficienteException, MontoNegativoException {
        retirar(monto);
        cuentaDestino.depositar(monto);
    }
}

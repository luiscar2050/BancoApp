class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(String mensaje) {
        super(mensaje);
    }
}

class MontoNegativoException extends Exception {
    public MontoNegativoException(String mensaje) {
        super(mensaje);
    }
}

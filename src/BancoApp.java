public class BancoApp {
    public static void main(String[] args) {
        CuentaBancaria cuenta1 = new CuentaBancaria("Alice");
        CuentaBancaria cuenta2 = new CuentaBancaria("Bob");

        try {
            cuenta1.depositar(500000);
            System.out.println("Saldo de " + cuenta1.getTitular() + ": " + cuenta1.getSaldo());

            cuenta1.retirar(200000);
            System.out.println("Saldo de " + cuenta1.getTitular() + " después de retirar: " + cuenta1.getSaldo());

            cuenta1.retirar(400000);
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        } catch (MontoNegativoException e) {
            System.out.println(e.getMessage());
        }

        try {
            cuenta1.transferir(cuenta2, 100000);
            System.out.println("Saldo de " + cuenta1.getTitular() + " después de transferir: " + cuenta1.getSaldo());
            System.out.println("Saldo de " + cuenta2.getTitular() + " después de recibir la transferencia: " + cuenta2.getSaldo());
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        } catch (MontoNegativoException e) {
            System.out.println(e.getMessage());
        }

        try {
            cuenta2.depositar(-5000);
        } catch (MontoNegativoException e) {
            System.out.println(e.getMessage());
        }
    }
}

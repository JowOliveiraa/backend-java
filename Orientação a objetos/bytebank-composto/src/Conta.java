public class Conta {
    
    double saldo;
    int angencia;
    int numero;
    String titular;

     public void depositar( double valor ) {
        this.saldo += valor;

     }

     public void sacar( double valor ) {
        if (this.saldo >= valor){
            this.saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente!");
        }
     }

     public void transferir( double valor, Conta destino) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            destino.saldo += valor;
            System.out.println("Transferiado com sucesso");
        } else {
            System.out.println("Saldo insuficiente");
        }
     }

}

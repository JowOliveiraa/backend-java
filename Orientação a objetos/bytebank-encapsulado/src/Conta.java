public class Conta {
    
    private double saldo;
    private int angencia;
    private int numero;
    private Cliente titular;

    public Conta ( int angencia, int numero ) {

        this.angencia = angencia;
        this.numero = numero;
        

    }

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

     public void transferir( double valor, Conta destino ) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            destino.saldo += valor;
            System.out.println("Transferiado com sucesso");
        } else {
            System.out.println("Saldo insuficiente");
        }

     }

     public double getSaldo() {
         return saldo;
     }

     public void setSaldo(double saldo) {
         this.saldo = saldo;
     }

     public int getAngencia() {
         return angencia;
     }

     public void setAngencia(int angencia) {
         this.angencia = angencia;
     }

     public int getNumero() {
         return numero;
     }

     public void setNumero(int numero) {
         this.numero = numero;
     }

     public Cliente getTitular() {
         return titular;
     }
     public void setTitular(Cliente titular) {
         this.titular = titular;
     }

}

package br.com.bytebank.modelo;

public abstract class Conta {
    
    private double saldo;
    private int agencia;
    private int numero;
    private Cliente titular;

    public Conta ( int agencia, int numero ) {

        
        this.agencia = agencia;
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
         return agencia;
     }

     public void setAngencia(int agencia) {
         this.agencia = agencia;
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

    @Override
    public String toString() {
        return "Agencia: " + this.agencia + ", Número: " + this.numero;
    }
}


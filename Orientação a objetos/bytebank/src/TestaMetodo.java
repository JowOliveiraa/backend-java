public class TestaMetodo {
    public static void main(String[] args) {
        Conta contaDoPaulo = new Conta();
        contaDoPaulo.saldo = 100;
       
        contaDoPaulo.depositar(50);
        System.out.println("Saldo do Paulo " + contaDoPaulo.saldo);
        contaDoPaulo.sacar(15);
        System.out.println("Saldo do Paulo " + contaDoPaulo.saldo);

        Conta contaDaMaria = new Conta();
        contaDaMaria.saldo =1000;

        contaDaMaria.transferir(1000, contaDoPaulo);

        System.out.println("Saldo do Paulo " + contaDoPaulo.saldo);


    }
    
}
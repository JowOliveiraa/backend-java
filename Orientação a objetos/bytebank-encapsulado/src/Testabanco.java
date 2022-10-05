public class Testabanco {
    public static void main(String[] args) {
        Cliente paulo = new Cliente("Paulo Silveira","222.222.222-22","Programador");

        Conta contaDoPaulo = new Conta(0, 1, 123, paulo);
        contaDoPaulo.depositar(100);

        System.out.println("O titular dessa conta é " + contaDoPaulo.getTitular().getNome());
    
    
    }
    
}
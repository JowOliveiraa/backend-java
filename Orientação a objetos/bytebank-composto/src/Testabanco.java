public class Testabanco {
    public static void main(String[] args) {
        Cliente paulo = new Cliente();
        paulo.nome ="Paulo Silveira";
        paulo.cpf ="222.222.222-22";
        paulo.profissao = "Programador";

        Conta contaDoPaulo = new Conta();
        contaDoPaulo.depositar(100);

        contaDoPaulo.titular = paulo;
        System.out.println("O titular dessa conta é " + contaDoPaulo.titular.nome);
            }
    
}
public class Testabanco {
    public static void main(String[] args) {
        Cliente paulo = new Cliente();
        paulo.setNome("Paulo Silveira");
        paulo.setCpf("222.222.222-22");
        paulo.setProfissao("Programador");

        Conta contaDoPaulo = new Conta();
        contaDoPaulo.depositar(100);

        contaDoPaulo.setTitular(paulo);
        System.out.println("O titular dessa conta é " + contaDoPaulo.getTitular().getNome());
            }
    
}
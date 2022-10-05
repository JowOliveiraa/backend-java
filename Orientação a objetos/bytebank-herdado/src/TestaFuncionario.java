public class TestaFuncionario {

    public static void main(String[] args) {
        
        Funcionario nico = new Funcionario();

        nico.setNome("Nico Stepoot");
        nico.setCpf("333.333.333-33");
        nico.setSalario(1000);

        System.out.println("O nome do usuário é " + nico.getNome());
        System.out.println("A bonificação do " + nico.getNome() + " é " + nico.getBonification());
    }

}
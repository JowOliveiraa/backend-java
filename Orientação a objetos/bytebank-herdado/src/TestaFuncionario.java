public class TestaFuncionario {

    public static void main(String[] args) {
        
        Funcionario nico = new Gerente();

        nico.setNome("Nico Stepoot");
        nico.setCpf("333.333.333-33");
        nico.setSalario(1000);

        System.out.println("O nome do funcionario é " + nico.getNome());
        System.out.println("A bonificação do " + nico.getNome() + " é " + nico.getBonification());
    
        System.out.println("*************************************************");

        Gerente gerente1 = new Gerente();

        gerente1.setNome("Chico");
        gerente1.setSalario(5000);

        System.out.println("O nome do gerente é " + gerente1.getNome());
        System.out.println("A bonificação do " + gerente1.getNome() + " é " + gerente1.getBonification());
        gerente1.autenticaSenha(0);

        System.out.println("***********************");

        Funcionario designer = new Designer();

        designer.setSalario(1000.0);

        System.out.println(designer.getSalario());
        System.out.println(designer.getBonification());
    }

}
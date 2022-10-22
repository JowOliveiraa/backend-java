public class SistemaInterno {

    private int senha = 2022;

    public void autentica( FuncionarioAutenticavel funcionario ) {

        if ( funcionario.getSenha() == senha ) {
            System.out.println("Pode entrar no sistema!");
        } else{
            System.out.println("Não pode entrar no sistema!");
        }
    }
    
}
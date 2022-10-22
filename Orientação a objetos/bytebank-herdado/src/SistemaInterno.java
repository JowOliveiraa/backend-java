public class SistemaInterno {

    private int senha = 2022;

    public void autentica( Autenticavel autenticavel ) {

        if ( autenticavel.getSenha() == senha ) {
            System.out.println("Pode entrar no sistema!");
        } else{
            System.out.println("Não pode entrar no sistema!");
        }
    }
    
}
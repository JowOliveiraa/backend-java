public class TesteSistema {

  
    public static void main(String[] args) {
        
        Gerente gerente0 = new Gerente();

        gerente0.setSenha(202);

        SistemaInterno sistema = new SistemaInterno();

        sistema.autentica(gerente0);

        Administrador administrador = new Administrador();

        administrador.setSenha(2022);

         sistema.autentica(administrador);

        
    }
    
}
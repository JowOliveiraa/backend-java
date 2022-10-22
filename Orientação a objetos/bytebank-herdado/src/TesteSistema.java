public class TesteSistema {

  
    public static void main(String[] args) {
        
        Gerente gerente0 = new Gerente();

        gerente0.setSenha(2022);

        SistemaInterno sistema = new SistemaInterno();

        sistema.autentica(gerente0);

        Administrador administrador = new Administrador();

        administrador.setSenha(022);

         sistema.autentica(administrador);

        
    }
    
}
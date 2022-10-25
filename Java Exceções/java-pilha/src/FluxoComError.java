public class FluxoComError {
    public static void main(String[] args) {
        System.out.println("Ini do main");

        try {
            metodo1();
        } catch (ArithmeticException | NullPointerException | MinhaExcecao ex ) {

            System.out.println("Exception " + ex.getMessage() );
            ex.printStackTrace();
        }

        System.out.println("Fim do main");
    }

    private static void metodo1() {
        System.out.println("Ini do metodo1");
        metodo2();
        System.out.println("Fim do metodo1");
    }

    private static void metodo2() {
        System.out.println("Chamando o metodo2 infinitamente para gerar Error");
        metodo2();
    }
}

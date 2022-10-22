public class ContaCorrente extends Conta {

    public ContaCorrente(int angencia, int numero) {
        super(angencia, numero);
        
    }

    
    @Override
    public void sacar(double valor) {
        
        super.sacar(valor + 0.2);
    }
    
}
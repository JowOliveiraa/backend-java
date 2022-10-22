public class ContaCorrente extends Conta {

    public ContaCorrente(int agencia, int numero) {
        super(agencia, numero);
        
    }

    
    @Override
    public void sacar(double valor) {
        
        super.sacar(valor + 0.2);
    }
    
}
public class Gerente extends Funcionario implements Autenticavel {
    
    private int senha;

    public double getBonification() {
        return super.getSalario();
    }

    @Override
    public void setSenha(int senha) {
        this.senha = senha;
        
    }

    @Override
    public int getSenha() {
        return this.senha;
    }

    @Override
    public void autenticaSenha(int senha)  {
        if (this.senha == senha) {
            System.out.println("Senha correta!");
        } else{
            System.out.println("Senha incorreta!"); 
        }
    }

    
    
}
public class Administrador extends Funcionario implements Autenticavel {

    private int senha;

    @Override
    public double getBonification() {
        return 50;
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
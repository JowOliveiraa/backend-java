public class Gerente extends Funcionario {
    
    private int senha;

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public int getSenha() {
        return senha;
    }

    public double getBonification() {
        return super.getSalario();
    }

    public void autenticaSenha(int senha) {
        if (this.senha == senha) {
            System.out.println("Senha correta!");
        } else{
            System.out.println("Senha errada!"); 
        }
    }
    
}
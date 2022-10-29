package br.com.bytebank.modelo;

public class GuardadorDeContas {

    private Conta[] referencias;
    private int posicaoLivre;

    public int getPosicaoLivre() {
        return posicaoLivre;
    }

    public GuardadorDeContas() {
        this.referencias = new Conta[10];
        this.posicaoLivre = 0;
    }

    public void adiciona(Conta ref) {
        this.referencias[this.posicaoLivre] = ref;
        this.posicaoLivre++;

    }

    public int getQuantidade() {
        return this.posicaoLivre;
    }
}
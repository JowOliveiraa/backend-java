package br.com.bytebank.modelo;

public class CalculadordeImposto {

    private double totalImposto;

    public void registra(Tributavel tributavel) {

        this.totalImposto += tributavel.getValorImposto();

    }

    public double getTotalImposto() {
        return totalImposto;
    }
    
}
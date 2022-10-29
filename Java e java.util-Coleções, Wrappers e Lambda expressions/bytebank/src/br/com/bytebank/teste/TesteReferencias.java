package br.com.bytebank.teste;

import br.com.bytebank.modelo.*;

public class TesteReferencias {

    public static void main(String[] args) {

        GuardadorDeContas guardador = new GuardadorDeContas();


        Conta cc = new ContaCorrente(22, 11);
        guardador.adiciona(cc);

        Conta cc2 = new ContaCorrente(22,12);
        guardador.adiciona(cc2);

        int tamanho = guardador.getQuantidade();

        System.out.println(tamanho);

    }

}

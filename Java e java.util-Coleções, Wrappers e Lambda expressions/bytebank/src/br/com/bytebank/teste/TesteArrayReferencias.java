package br.com.bytebank.teste;

import br.com.bytebank.modelo.*;

public class TesteArrayReferencias {

    public static void main(String[] args) {

        Conta[] contas = new ContaCorrente[5];

        contas[0] = new ContaCorrente(22, 11);
        contas[1] = new ContaCorrente(22, 12);



        System.out.println("Número da conta na primeira posição " + contas[0].getNumero());
    }
}

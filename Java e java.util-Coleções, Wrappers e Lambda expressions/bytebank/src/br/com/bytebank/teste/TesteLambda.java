package br.com.bytebank.teste;

import br.com.bytebank.modelo.Conta;
import br.com.bytebank.modelo.ContaCorrente;
import br.com.bytebank.modelo.ContaPoupanca;

import java.util.ArrayList;
import java.util.List;

public class TesteLambda {

    public static void main(String[] args) {

        Conta cc1 = new ContaCorrente(22,33);
        cc1.depositar(333);

        Conta cc2 = new ContaPoupanca(22,44);
        cc2.depositar(444);

        Conta cc3 = new ContaCorrente(22,11);
        cc3.depositar(111);

        Conta cc4 = new ContaPoupanca(22,22);
        cc4.depositar(222);

        List<Conta> lista = new ArrayList<>();
        lista.add(cc1);
        lista.add(cc2);
        lista.add(cc3);
        lista.add(cc4);

        for (Conta conta : lista) {
            System.out.println(conta);
        }


        lista.sort( (c1, c2) -> Integer.compare(c1.getNumero(), c2.getNumero()) );

        System.out.println("******************************************************");

        for (Conta conta : lista) {
            System.out.println(conta);
        }

        System.out.println("******************************************************");

        lista.forEach( (conta) -> System.out.println(conta) );
    }
}





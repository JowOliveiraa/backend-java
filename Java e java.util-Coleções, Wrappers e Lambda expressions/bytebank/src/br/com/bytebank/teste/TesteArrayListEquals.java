package br.com.bytebank.teste;

import br.com.bytebank.modelo.Conta;
import br.com.bytebank.modelo.ContaCorrente;

import java.util.ArrayList;

public class TesteArrayListEquals {

    public static void main(String[] args) {

        ArrayList<Conta> lista = new ArrayList<>();

        Conta cc = new ContaCorrente(22,11);
        lista.add(cc);

        Conta cc2 = new ContaCorrente(22, 12);
        lista.add(cc2);

        Conta cc3 = new ContaCorrente(22,13);
        boolean existe = lista.contains(cc3);

        System.out.println("Ja existe? " + existe);

        for (Conta conta : lista) {
            if (conta.eIgual(cc3)) {
                System.out.println("Ja tenho essa conta");
            }
        }

        for (Conta conta : lista) {
            System.out.println(conta);
        }

        System.out.println("*****************************************************************");

        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }
}

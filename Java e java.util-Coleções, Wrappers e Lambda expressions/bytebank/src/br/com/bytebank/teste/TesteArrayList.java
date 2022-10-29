package br.com.bytebank.teste;

import br.com.bytebank.modelo.*;

import java.util.ArrayList;

public class TesteArrayList {

    public static void main(String[] args) {

        ArrayList<Conta> lista = new ArrayList<>();

        Conta cc = new ContaCorrente(22, 11);
        lista.add(cc);

        Conta cc2 = new ContaCorrente(22,12);
        lista.add(cc2);

        System.out.println("Tamanho da lista " + lista.size());
        Conta ref = lista.get(0);
        System.out.println(ref.getNumero());

        lista.remove(0);

        System.out.println("Tamanho da lista " + lista.size());

        Conta cc3 = new ContaCorrente(22, 13);
        lista.add(cc3);

        Conta cc4 = new ContaCorrente(22,14);
        lista.add(cc4);


        for(Conta conta : lista) {
            System.out.println(conta);
        }

    }
}

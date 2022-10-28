package br.com.bytebank.teste;

public class TesteArrayDePrimitivos {

    public static void main(String[] args) {

        int [] idades = new int[5];




        System.out.println("Quantas posições tem o array idades: " + idades.length);

        System.out.println("*********************************************************************");

        for (int i = 0; i < idades.length; i++) {
            idades[i] *= i;

        }

        for (int i = 0; i <idades.length; i++) {
            System.out.println(i);
        }

    }
}

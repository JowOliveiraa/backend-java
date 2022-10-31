package br.com.alura;

import java.util.ArrayList;
import java.util.Collections;

public class TestandoListas {

    public static void main(String[] args) {

        String aula1 = "Conhecendo mais de listas";
        String aula2 = "Modelando a classe Aula";
        String aula3 = "Trabalhando com Cursos e Sets";

        ArrayList<String> aulas = new ArrayList<>();
        aulas.add(aula1);
        aulas.add(aula2);
        aulas.add(aula3);

        System.out.println(aulas);

        System.out.println("********************************************");

        aulas.forEach( aula -> System.out.println("Aula: " + aula) );

        System.out.println("********************************************");

        for ( String aula : aulas ) {
            System.out.println(aula);
        }

        System.out.println("********************************************");

        System.out.println("A primeira aula é: " + aulas.get(0));

        System.out.println("********************************************");

        for (int i = 0; i < aulas.size(); i++) {
            System.out.println("Aula: " + aulas.get(i));
        }

        System.out.println("********************************************");


        aulas.add("Aumentando nosso conhecimento");
        aulas.forEach( aula -> System.out.println(aula));

        System.out.println("********************************************");

        System.out.println("Depois de ordenado em ordem alfabetica: ");
        Collections.sort(aulas);
        aulas.forEach( aula -> System.out.println(aula));


    }
}

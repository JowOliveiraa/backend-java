package br.com.alura.io.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TesteLeitura2 {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(new File("contas.csv"));

        String linha = null;
        while (scanner.hasNextLine()) {
            linha = scanner.nextLine();
            System.out.println(linha);
        }

        Scanner linhaScanner = new Scanner(linha);
        linhaScanner.useDelimiter(",");

        String valor1 = linhaScanner.next();
        String valor2 = linhaScanner.next();
        String valor3 = linhaScanner.next();
        String valor4 = linhaScanner.next();
        String valor5 = linhaScanner.next();

        System.out.println(valor1+valor2+valor3+valor4+valor5);

        scanner.close();
        linhaScanner.close();

    }
}

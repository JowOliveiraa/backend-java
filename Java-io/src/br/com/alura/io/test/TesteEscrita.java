package br.com.alura.io.test;

import java.io.*;

public class TesteEscrita {

    public static void main(String[] args) throws IOException {

        OutputStream outputStream = new FileOutputStream("lorem2.txt");
        Writer writer = new OutputStreamWriter(outputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        bufferedWriter.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
        bufferedWriter.newLine();
        bufferedWriter.write("NUubububuibiubiu");

        bufferedWriter.close();



    }
}

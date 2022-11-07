package br.com.alura.io.test;

import java.io.*;

public class TesteEscritaFileWriter {

    public static void main(String[] args) throws IOException {

//        OutputStream outputStream = new FileOutputStream("lorem2.txt");
//        Writer writer = new OutputStreamWriter(outputStream);
//        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        BufferedWriter bw = new BufferedWriter(new FileWriter("lorem2.txt"));

        bw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
        bw.newLine();
        bw.write("NUubububuibiubiu");

        bw.close();



    }
}

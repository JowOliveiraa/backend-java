package br.com.alura.io.test;

import java.io.*;

public class TesteEscritaPrintStreamPrintWriter {

    public static void main(String[] args) throws IOException {

//        OutputStream outputStream = new FileOutputStream("lorem2.txt");
//        Writer writer = new OutputStreamWriter(outputStream);
//        BufferedWriter bufferedWriter = new BufferedWriter(writer);

//        BufferedWriter bw = new BufferedWriter(new FileWriter("lorem2.txt"));

//        PrintStream ps = new PrintStream(new File("lorem2.txt"));

        PrintWriter pw = new PrintWriter(new File("lorem2.txt"));

        pw.println("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
        pw.println();
        pw.println("NUubububuibiubiu");

        pw.close();



    }
}

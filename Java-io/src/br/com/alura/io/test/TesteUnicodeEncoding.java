package br.com.alura.io.test;

import java.nio.charset.Charset;

public class TesteUnicodeEncoding {

    public static void main(String[] args) {
         String s = "C";
        System.out.println(s.codePointAt(0));

        Charset charset = Charset.defaultCharset();
        System.out.println(charset);

        byte[] bytes = s.getBytes();
        System.out.println(bytes.length + ", " + charset);

    }
}
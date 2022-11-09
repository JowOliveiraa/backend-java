package br.com.alura.io.test;

import java.io.*;

public class TesteSerializacao {

    public static void main(String[] args) throws IOException, ClassNotFoundException {


        Cliente cliente = new Cliente("Nico","123.456.789-12","Dev");

        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("cliente.bin"));
        os.writeObject(cliente);
        os.close();

//        String nome = "Nico Steppat";

//        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("objeto.bin"));
//        os.writeObject(nome);
//        os.close();

        ObjectInputStream oic = new ObjectInputStream(new FileInputStream("cliente.bin"));
        Cliente objetoCliente = (Cliente) oic.readObject();
        System.out.println(objetoCliente);
        System.out.println(cliente.getProfissao());

        ObjectInputStream oi = new ObjectInputStream(new FileInputStream("objeto.bin"));
        String objeto = (String) oi.readObject();
        System.out.println(objeto);
        oi.close();

    }
}

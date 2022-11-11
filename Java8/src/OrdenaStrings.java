import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrdenaStrings {

    public static void main(String[] args) {

        List<String> palavras = new ArrayList<>();

        palavras.add("Alura online");
        palavras.add("Editora Casa do Código");
        palavras.add("Caelum");

        Comparator<String> comparador = new ComparadorPorTamanho();

        //Collections.sort(palavras, comparador);
        palavras.sort(comparador);
        System.out.println(palavras);

        palavras.forEach(p -> System.out.println(p));
    }

}

class ComparadorPorTamanho implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        if (s1.length() < s2.length())
            return -1;
        if (s1.length() > s2.length())
            return 1;
        return 0;
    }
}

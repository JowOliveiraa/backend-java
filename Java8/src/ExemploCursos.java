import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

class Curso {

    private String nome;
    private int alunos;

    public Curso(String nome, int alunos) {
        this.nome = nome;
        this.alunos = alunos;
    }

    public String getNome() {
        return nome;
    }

    public int getAlunos() {
        return alunos;
    }

    @Override
    public String toString() {
        return this.nome + ", " + this.getAlunos();
    }
}

public class ExemploCursos {

    public static void main(String[] args) {

        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso("Python", 45));
        cursos.add(new Curso("javaScript", 150));
        cursos.add(new Curso("Java 8", 113));
        cursos.add(new Curso("C", 55));

         cursos.forEach(System.out::println);

         cursos.sort(Comparator.comparingInt(Curso::getAlunos));

        System.out.println("*****************************************************");
         cursos.forEach(System.out::println);

        System.out.println("*****************************************************");
         cursos.stream()
                 .filter(curso -> curso.getAlunos() >= 100 )
                 .map(Curso::getNome)
                 .forEach(System.out::println);

        System.out.println("*****************************************************");


         cursos.stream()
                 .filter(curso-> curso.getAlunos() >= 100)
                 .map(Curso::getAlunos)
                 .forEach(System.out::println);

        System.out.println("*****************************************************");

        cursos.stream()
                .filter(curso -> curso.getAlunos() >= 100)
                .map(curso -> curso.getNome() + " tem " +curso.getAlunos())
                .forEach(System.out::println);

        System.out.println("*****************************************************");

        int total = cursos.stream()
                 .filter(curso -> curso.getAlunos() >= 100)
                 .mapToInt(Curso::getAlunos)
                 .sum();

        System.out.println("Total de alunos " + total);

        System.out.println("*****************************************************");

        cursos.stream()
                .map(Curso::getNome)
                .forEach(System.out::println);

        System.out.println("*****************************************************");

        List<Curso> cursoFiltrado = cursos.stream()
                .filter(curso -> curso.getAlunos() > 50)
                .collect(Collectors.toList());

        cursoFiltrado.forEach(System.out::println);



    }

}

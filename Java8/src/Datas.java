import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class Datas {

    public static void main(String[] args) {

        LocalDateTime hoje = LocalDateTime.now();
        System.out.println(hoje);

        DateTimeFormatter hojeFormatado = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
        System.out.println(hoje.format(hojeFormatado));
    }
}

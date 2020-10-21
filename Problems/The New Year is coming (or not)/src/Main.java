import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        String[] tokens = new Scanner(System.in).nextLine().split(" ");
        LocalDate date = LocalDate.parse(tokens[0]);
        System.out.println(date.getYear() !=
                date.plusDays(Long.parseLong(tokens[1])).getYear());
    }
}
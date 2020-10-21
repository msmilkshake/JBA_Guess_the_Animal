import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        LocalDate date = LocalDate.parse(new Scanner(System.in).nextLine());
        System.out.println(date.getDayOfYear() + " " + date.getDayOfMonth());
    }
}
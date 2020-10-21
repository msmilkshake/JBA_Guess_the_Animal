import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        String[] tokens = new Scanner(System.in).nextLine().split(" ");
        int year = Integer.parseInt(tokens[0]);
        int month = Integer.parseInt(tokens[1]);
        int day = LocalDate.of(year, month, 1)
                .lengthOfMonth() - Integer.parseInt(tokens[2]) + 1;
        System.out.println(LocalDate.of(year, month, day));
        
    }
}
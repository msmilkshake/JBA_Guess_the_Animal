import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    public static LocalDateTime merge(LocalDateTime dt1, LocalDateTime dt2) {
        int year = Math.max(dt1.getYear(), dt2.getYear());
        int month = Math.max(dt1.getMonthValue(), dt2.getMonthValue());
        int day = Math.max(dt1.getDayOfMonth(), dt2.getDayOfMonth());
        int hours = Math.max(dt1.getHour(), dt2.getHour());
        int mins = Math.max(dt1.getMinute(), dt2.getMinute());
        int secs = Math.max(dt1.getSecond(), dt2.getSecond());
        return LocalDateTime.of(year, month, day, hours, mins, secs);
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final LocalDateTime firstDateTime = LocalDateTime.parse(scanner.nextLine());
        final LocalDateTime secondDateTime = LocalDateTime.parse(scanner.nextLine());
        System.out.println(merge(firstDateTime, secondDateTime));
    }
}
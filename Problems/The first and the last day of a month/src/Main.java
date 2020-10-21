import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int year = scn.nextInt();
        int month = scn.nextInt();
        int day = Month.of(month).length(Year.isLeap(year));
        System.out.println(LocalDate.of(year, month, 1) + " " +
                LocalDate.of(year, month, day));
    }
}
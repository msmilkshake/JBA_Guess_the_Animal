import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        LocalTime t1 = LocalTime.parse(scn.nextLine());
        LocalTime t2 = LocalTime.parse(scn.nextLine());
        long seconds = Math.abs(t2.toSecondOfDay() - t1.toSecondOfDay());
        System.out.println(seconds);
    }
}
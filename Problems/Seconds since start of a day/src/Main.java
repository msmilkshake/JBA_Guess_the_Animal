import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        int elapsedSecs = new Scanner(System.in).nextInt();
        LocalTime time = LocalTime.ofSecondOfDay(elapsedSecs);
        System.out.println(time);
    }
}
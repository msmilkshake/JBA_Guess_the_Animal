import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        LocalTime time = LocalTime.parse(scn.nextLine());
        time = time.minusHours(scn.nextLong());
        time = time.minusMinutes(scn.nextLong());
        System.out.println(time);
    }
}
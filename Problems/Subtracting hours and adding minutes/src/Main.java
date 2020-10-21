import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        LocalDateTime ldt = LocalDateTime.parse(scn.nextLine());
        ldt = ldt.minusHours(scn.nextInt()).plusMinutes(scn.nextInt());
        System.out.println(ldt);
    }
}
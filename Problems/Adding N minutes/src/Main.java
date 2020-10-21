import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        LocalDateTime dt = LocalDateTime.parse(scn.nextLine());
        dt = dt.plusMinutes(scn.nextInt());
        System.out.println(dt.getYear() + " " +
                dt.getDayOfYear() + " " +
                dt.toLocalTime());
    }
}
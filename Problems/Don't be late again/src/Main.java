import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        LocalTime refTime = LocalTime.of(20, 0);
        for (int i = 0; i < n; ++i) {
            String shop = scn.next();
            LocalTime closeTime = LocalTime.parse(scn.next());
            if (closeTime.isAfter(refTime)) {
                System.out.println(shop);
            }
        }
    }
}
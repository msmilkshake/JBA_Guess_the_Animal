import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        LocalDateTime dt1 = LocalDateTime.parse(scn.nextLine());
        LocalDateTime dt2 = LocalDateTime.parse(scn.nextLine());
        if (dt1.compareTo(dt2) > 0) {
            LocalDateTime tmp = dt1;
            dt1 = dt2;
            dt2 = tmp;
        }
        int n = Integer.parseInt(scn.nextLine());
        int count = 0;
        for (int i = 0; i < n; ++i) {
            LocalDateTime dt = LocalDateTime.parse(scn.nextLine());
            if (dt.compareTo(dt1) >= 0 && dt.compareTo(dt2) < 0) {
                ++count;
            }
        }
        System.out.println(count);
    }
}
package 수학;

import java.util.*;

public class AlarmClock {
    public void run() {
        Scanner sc = new Scanner(System.in);
        int hour = sc.nextInt();
        int minute = sc.nextInt();
        if (hour > 23 || hour < 0) {
            System.out.println("존재하지 않는 시간입니다.");
            return;
        }
        if (minute - 45 >= 0) {
            minute -= 45;
            System.out.print(hour + " " + minute);
            sc.close();
            return;
        } else {
            hour -= 1;
            if (hour < 0)
                hour = 23;
            minute = minute + 15;
            System.out.print(hour + " " + minute);
            sc.close();
            return;
        }
    }

    public static void main(String[] args) {
        AlarmClock alarmClock = new AlarmClock();
        alarmClock.run();
    }
}

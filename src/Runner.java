import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Runner {
    private static Alarm alarm;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        alarm = new Alarm(scanner.nextInt());

        new Timer().schedule(new TimerTask(){
            @Override
            public void run() {
                alarm.runAlarm();
            }
        },0, 1000);
    }
}

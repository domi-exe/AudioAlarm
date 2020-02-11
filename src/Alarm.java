import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.FileInputStream;
import java.io.IOException;

public class Alarm {
    private static int seconds;
    private static String ringtone = "ringtone.mp3";

    Alarm(int seconds) {
        this.seconds = seconds;
    }

    private static int countdown() {
        return --seconds;
    }

    public static void runAlarm() {
        if (seconds > 0) {
            seconds = countdown();
        } else {
            try (FileInputStream fis = new FileInputStream(ringtone))
            {
                Player player = new Player(fis);
                player.play();
            } catch (IOException | JavaLayerException e) {
                e.printStackTrace();
            }
        }
    }
}

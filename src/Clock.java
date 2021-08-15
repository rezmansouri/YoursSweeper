
import javax.swing.JLabel;

public class Clock extends Thread {

    JLabel time;
    MainWindow frame;
    int seconds = 0;

    public Clock(JLabel time, MainWindow frame) {
        this.time = time;
        this.frame = frame;
    }

    public String getTime() {
        return String.valueOf(seconds);
    }

    @Override
    public void run() {
        while (true) {
            time.setText("" + seconds);
            synchronized (this) {
                try {
                    this.wait(1000);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                seconds++;
            }
        }
    }
}

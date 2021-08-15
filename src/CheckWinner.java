
public class CheckWinner extends Thread {

    MainWindow frame;
    boolean win;

    public CheckWinner(MainWindow frame) {
        this.frame = frame;
    }

    @Override
    public void run() {
        synchronized (this) {
            boolean firstBreak;
            while (true) {
                firstBreak = false;
                win = false;
                for (int j = 0; j < frame.houses.length; j++) {
                    if (firstBreak) {
                        break;
                    }
                    for (int i = 0; i < frame.houses[j].length; i++) {
                        if (frame.houses[j][i].finalize || frame.houses[j][i].situation == Situation.bomb) {
                            win = true;
                        } else {
                            win = false;
                            firstBreak = true;
                            break;
                        }
                    }
                }
                if (win) {
                    break;
                }
            }

        }
        frame.clock.suspend();
        for (int j = 0; j < frame.houses.length; j++) {
            for (int i = 0; i < frame.houses.length; i++) {
                if (frame.houses[j][i].situation == Situation.bomb) {

                    frame.houses[j][i].label.setIcon(Sprites.unflagged_bomb_ico);

                }
            }

        }
        AfterWinOrLose afterWinOrLose = new AfterWinOrLose(true, frame);
        afterWinOrLose.setVisible(true);
        this.suspend();
    }

}

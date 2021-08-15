
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class House {

    MainWindow frame;
    int x, y;
    public JLabel label;
    Situation situation;
    int numberOfBombs = 0;
    boolean clicked = false, flaged = false, questioned = false, unclickable = false, afterClick = false;
    boolean finalize = false;
    private ImageIcon numberIco;

    void leftClick(House house) {
        if (!house.flaged || !house.questioned) {
            house.afterClick = true;
        }
        if (!house.clicked) {
            house.clicked = true;
            house.unclickable = true;
            if (house.label.getIcon() == Sprites.flag_idle_ico) {

            } else if (house.numberOfBombs != 0) {
                house.label.setIcon(house.numberIco);
                house.finalize = true;
            } else if (house.numberOfBombs == 0) {
                house.finalize = true;
                house.label.setIcon(Sprites.house_empty_ico);
                house.eightLeftClicks();
            }
        }
        if (house.situation == Situation.bomb) {
            if (house.label.getIcon() == Sprites.flag_idle_ico) {

            } else {
                house.label.setIcon(Sprites.misclicked_bomb_ico);
                try {
                    frame.showBombs(house.x, house.y);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    void eightLeftClicks() {
        int movingY = y - 1;
        for (int j = 0; j < 3; j++) {
            if (movingY >= 0 && movingY < 9) {
                int movingX = x - 1;
                for (int i = 0; i < 3; i++) {
                    if (movingX >= 0 && movingX < 9) {
                        if (!(movingX == x && movingY == y)) {
                            leftClick(frame.houses[movingY][movingX]);
                        }
                    }
                    movingX++;
                }
            }
            movingY++;
        }
    }

    House(MainWindow frame) throws IOException {
        this.frame = frame;
        label = new JLabel();
        label.setIcon(Sprites.house_idle_ico);
        label.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (frame.letPlay) {
                    switch (e.getButton()) {
                        case 1:
                            if (e.getClickCount() == 1) {
                                frame.setNumberOfBombs();
                                if (!frame.clock.isAlive()) {
                                    frame.time.setText("");
                                    frame.clock.start();
                                }
                                if (frame.firstClick) {
                                    frame.firstClick = false;
                                    frame.plantBombs(10, x, y);
                                    frame.putNumberOfBombs();
                                }
                                if (!clicked && !unclickable) {
                                    clicked = true;
                                    label.setIcon(Sprites.house_empty_ico);
                                }
                            } else if (e.getClickCount() == 2) {
                                if (clicked) {
                                    int numberOfFlags = 0;
                                    int jj = y - 1;
                                    for (int j = 0; j < 3; j++) {
                                        int ii = x - 1;
                                        for (int i = 0; i < 3; i++) {
                                            if (!(ii == x && jj == y)) {
                                                if (ii >= 0 && ii < 9 && jj >= 0 && jj < 9) {
                                                    if (frame.houses[jj][ii].label.getIcon() == Sprites.flag_idle_ico) {
                                                        numberOfFlags++;
                                                    }
                                                }
                                            }
                                            ii++;
                                        }
                                        jj++;
                                    }
                                    if (numberOfFlags == numberOfBombs) {
                                        eightLeftClicks();
                                    }
                                }
                            }
                            break;

                        case 2:
                            if (clicked) {
                                int numberOfFlags = 0;
                                int jj = y - 1;
                                for (int j = 0; j < 3; j++) {
                                    int ii = x - 1;
                                    for (int i = 0; i < 3; i++) {
                                        if (!(ii == x && jj == y)) {
                                            if (ii >= 0 && ii < 9 && jj >= 0 && jj < 9) {
                                                if (frame.houses[jj][ii].label.getIcon() == Sprites.flag_idle_ico) {
                                                    numberOfFlags++;
                                                }
                                            }
                                        }
                                        ii++;
                                    }
                                    jj++;
                                }
                                if (numberOfFlags == numberOfBombs) {
                                    eightLeftClicks();
                                }
                            }
                            break;

                        case 3:

                            if (label.getIcon() == Sprites.flag_hover_ico
                                    || label.getIcon() == Sprites.flag_idle_ico
                                    || label.getIcon() == Sprites.question_hover_ico
                                    || label.getIcon() == Sprites.question_idle_ico
                                    || label.getIcon() == Sprites.house_idle_ico
                                    || label.getIcon() == Sprites.house_hover_ico) {
                                if (!flaged && !questioned) {
                                    clicked = true;
                                    unclickable = true;
                                    flaged = true;
                                    label.setIcon(Sprites.flag_idle_ico);
                                    frame.numberOfBombsLeft--;
                                    frame.setNumberOfBombs();
                                } else if (!questioned && flaged) {
                                    clicked = true;
                                    unclickable = true;
                                    questioned = true;
                                    flaged = false;
                                    label.setIcon(Sprites.question_idle_ico);
                                    frame.numberOfBombsLeft++;
                                    frame.setNumberOfBombs();
                                } else if (questioned) {
                                    clicked = false;
                                    unclickable = false;
                                    questioned = false;
                                    flaged = false;
                                    label.setIcon(Sprites.house_idle_ico);
                                }
                            }
                            break;
                    }
                }
            }

            @Override

            public void mouseReleased(MouseEvent e) {
                if (frame.letPlay) {
                    switch (e.getButton()) {
                        case 1:
                            finalize = true;
                            if (!flaged || !questioned) {
                                afterClick = true;
                            }
                            if (!unclickable) {
                                if (situation == Situation.bomb) {
                                    label.setIcon(Sprites.misclicked_bomb_ico);
                                    try {
                                        frame.showBombs(x, y);
                                        frame.clickedXx = x;
                                        frame.clickedYy = y;
                                    } catch (Exception ex) {

                                    }
                                } else if (numberOfBombs != 0) {
                                    label.setIcon(numberIco);
                                } else {
                                    label.setIcon(Sprites.house_empty_ico);
                                    eightLeftClicks();
                                }
                            }
                            break;
                        case 2:
                            break;
                        case 3:
                            break;

                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (frame.letPlay) {
                    if (label.getIcon() == Sprites.house_idle_ico) {
                        label.setIcon(Sprites.house_hover_ico);
                    } else if (label.getIcon() == Sprites.flag_idle_ico) {
                        label.setIcon(Sprites.flag_hover_ico);
                    } else if (label.getIcon() == Sprites.question_idle_ico) {
                        label.setIcon(Sprites.question_hover_ico);

                    }
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (frame.letPlay) {
                    if (label.getIcon() == Sprites.flag_hover_ico) {
                        label.setIcon(Sprites.flag_idle_ico);
                    } else if (label.getIcon() == Sprites.house_hover_ico) {
                        label.setIcon(Sprites.house_idle_ico);
                    } else if (label.getIcon() == Sprites.question_hover_ico) {
                        label.setIcon(Sprites.question_idle_ico);
                    }
                }
            }
        }
        );
    }

    void putNumberOfBombs() {
        if (situation != Situation.bomb) {
            int movingY = y - 1;
            for (int j = 0; j < 3; j++) {
                if (movingY >= 0 && movingY < 9) {
                    int movingX = x - 1;
                    for (int i = 0; i < 3; i++) {
                        if (movingX >= 0 && movingX < 9) {
                            if (!(movingX == x && movingY == y)) {
                                if (frame.houses[movingY][movingX].situation == Situation.bomb) {
                                    numberOfBombs++;
                                }
                            }
                        }
                        movingX++;
                    }
                }
                movingY++;
            }
        } else {
            numberOfBombs = -1;
        }
        putNumberIcon();
    }

    void putNumberIcon() {

        if (situation != Situation.bomb) {
            switch (numberOfBombs) {
                case 0:
                    numberIco = Sprites.house_empty_ico;
                    break;
                case 1:
                    numberIco = Sprites.number_1_ico;
                    break;
                case 2:
                    numberIco = Sprites.number_2_ico;
                    break;
                case 3:
                    numberIco = Sprites.number_3_ico;
                    break;
                case 4:
                    numberIco = Sprites.number_4_ico;
                    break;
                case 5:
                    numberIco = Sprites.number_5_ico;
                    break;
                case 6:
                    numberIco = Sprites.number_6_ico;
                    break;
                case 7:
                    numberIco = Sprites.number_7_ico;
                    break;
                case 8:
                    numberIco = Sprites.number_8_ico;
                    break;

            }
        }
    }
}

enum Situation {
    bomb, empty
}

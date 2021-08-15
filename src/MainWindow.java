
import javax.swing.ImageIcon;

public final class MainWindow extends javax.swing.JFrame {

    int clickedXx, clickedYy;
    public boolean letPlay=true;
    void plantBombs(int bombCount, int clickedX, int clickedY) {
        int x1, x2, x3, y1, y2, y3;
        x1 = clickedX - 1;
        x2 = clickedX;
        x3 = clickedX + 1;
        y1 = clickedY - 1;
        y2 = clickedY;
        y3 = clickedY + 1;
        int counter = 0;
        boolean ifBreak1 = false, ifBreak2 = false;
        while (counter <= bombCount) {
            for (int i = 0; i < houses.length; i++) {
                for (int j = 0; j < houses[i].length; j++) {
                    int coin = (int) (Math.random() * 10);
                    if (coin % 7 == 0 && (houses[i][j].situation != Situation.bomb)) {
                        if (!(x1 == j && y1 == i)
                                && !(x1 == j && y2 == i)
                                && !(x1 == j && y3 == i)
                                && !(x2 == j && y1 == i)
                                && !(x2 == j && y2 == i)
                                && !(x2 == j && y3 == i)
                                && !(x3 == j && y1 == i)
                                && !(x3 == j && y2 == i)
                                && !(x3 == j && y3 == i)) {
                            houses[i][j].situation = Situation.bomb;
                            counter++;
                        }
                    } else {
                        houses[i][j].situation = Situation.empty;
                    }
                    if (counter == bombCount) {
                        ifBreak1 = true;
                        break;
                    }
                }
                if (ifBreak1) {
                    ifBreak2 = true;
                    break;
                }
            }
            if (ifBreak2) {
                break;
            }
        }
    }

    void initHouses(int x, int y, int ifPlant1) throws Exception {

        houses = new House[x][y];
        int yCounter = 0;
        for (int j = 0; j < houses.length; j++) {
            int xCounter = 0;
            for (int i = 0; i < houses[j].length; i++) {
                houses[j][i] = new House(this);
                houses[j][i].x = i;
                houses[j][i].y = j;
                HOUSEKEEPER.add(houses[j][i].label);
                houses[j][i].label.setBounds(81 * xCounter, 81 * yCounter, 81, 81);
                xCounter++;
            }
            yCounter++;
        }
    }

    void putNumberOfBombs() {
        for (int j = 0; j < houses.length; j++) {
            for (int i = 0; i < houses[j].length; i++) {
                houses[j][i].putNumberOfBombs();
            }
        }
    }

    void showBombs(int clickedX, int clickedY) throws Exception {
        clock.suspend();
        for (int j = 0; j < houses.length; j++) {
            for (int i = 0; i < houses.length; i++) {
                if (houses[j][i].situation == Situation.bomb) {
                    if (!(clickedX == i && clickedY == j)) {
                        if (houses[j][i].flaged) {
                            houses[j][i].label.setIcon(Sprites.flagged_bomb_ico);
                        } else {
                            houses[j][i].label.setIcon(Sprites.unflagged_bomb_ico);
                        }

                    }
                }
                if (houses[j][i].flaged && houses[j][i].situation == Situation.empty) {
                    houses[j][i].label.setIcon(Sprites.flagged_number_ico);
                }
            }
        }
        AfterWinOrLose afterWinOrLose = new AfterWinOrLose(false, this);
        afterWinOrLose.setVisible(true);
        letPlay=false;
        
    }
    House[][] houses;
    Clock clock;
    boolean firstClick = true;
    int numberOfBombsLeft = 10;
    boolean exit = false;
    CheckWinner checkWinner;

    void setNumberOfBombs() {
        bombsLeft.setText("" + numberOfBombsLeft);
    }

    public MainWindow() throws Exception {
        new Sprites().init();
        initComponents();
        this.setTitle("YoursSweeper");
        ImageIcon icon = new ImageIcon("YoursSweeper.png");
        this.setIconImage(icon.getImage());
        this.setSize(986, 999);
        initHouses(9, 9, 1);

        clock = new Clock(time, this);
        checkWinner = new CheckWinner(this);
        checkWinner.start();
        bombsLeft.setText("" + numberOfBombsLeft);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        HOUSEKEEPER = new javax.swing.JPanel();
        time = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        bombsLeft = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        BORDER = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(460, 10));
        setPreferredSize(new java.awt.Dimension(999, 986));
        setResizable(false);
        getContentPane().setLayout(null);

        HOUSEKEEPER.setMaximumSize(new java.awt.Dimension(729, 729));
        HOUSEKEEPER.setMinimumSize(new java.awt.Dimension(729, 729));

        javax.swing.GroupLayout HOUSEKEEPERLayout = new javax.swing.GroupLayout(HOUSEKEEPER);
        HOUSEKEEPER.setLayout(HOUSEKEEPERLayout);
        HOUSEKEEPERLayout.setHorizontalGroup(
            HOUSEKEEPERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 729, Short.MAX_VALUE)
        );
        HOUSEKEEPERLayout.setVerticalGroup(
            HOUSEKEEPERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 729, Short.MAX_VALUE)
        );

        getContentPane().add(HOUSEKEEPER);
        HOUSEKEEPER.setBounds(130, 130, 729, 729);

        time.setBackground(new java.awt.Color(255, 255, 255));
        time.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        time.setForeground(new java.awt.Color(255, 255, 255));
        time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(time);
        time.setBounds(210, 40, 100, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sprites/clock_text_holder.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(210, 40, 100, 51);

        bombsLeft.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        bombsLeft.setForeground(new java.awt.Color(255, 255, 255));
        bombsLeft.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(bombsLeft);
        bombsLeft.setBounds(700, 40, 100, 50);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sprites/clock_text_holder.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(700, 40, 100, 51);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sprites/bomb_icon.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(650, 40, 50, 51);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sprites/clock_icon.png"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(160, 40, 50, 51);

        BORDER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sprites/border.png"))); // NOI18N
        getContentPane().add(BORDER);
        BORDER.setBounds(0, 0, 986, 999);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainWindow().setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BORDER;
    public javax.swing.JPanel HOUSEKEEPER;
    private javax.swing.JLabel bombsLeft;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public javax.swing.JLabel time;
    // End of variables declaration//GEN-END:variables

}

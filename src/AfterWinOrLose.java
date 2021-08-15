
import java.awt.Color;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.ImageIcon;

public class AfterWinOrLose extends javax.swing.JFrame {

    MouseListener last;
    BufferedReader br;
    PrintWriter pw;
    boolean WinOrLose;
    MainWindow frame;
    String bestRecordTime;

    //true = win   false=lose
    public AfterWinOrLose(boolean WinOrLose, MainWindow frame) {
        ImageIcon icon = new ImageIcon("YoursSweeper.png");
        this.setIconImage(icon.getImage());
        frame.letPlay = false;
        try {
            this.WinOrLose = WinOrLose;
            this.frame = frame;
            br = new BufferedReader(new FileReader("records.txt"));
            String gamesPlayedString = br.readLine();
            String gamesWonString = br.readLine();
            String personalBestString = br.readLine();
            int gamesPlayed = Integer.parseInt(gamesPlayedString);
            int gamesWon = Integer.parseInt(gamesWonString);
            int personalBest = Integer.parseInt(personalBestString);
            gamesPlayed++;
            initComponents();
            int prcntg = (gamesWon * 100) / gamesPlayed;
            String prcntgg = String.valueOf(prcntg);
            //
            if (WinOrLose) {
                YouWonOrLost.setForeground(Color.green);
                YouWonOrLost.setText("Congrats! You Won!");
                setTitle("You Won!");
            } else {
                YouWonOrLost.setForeground(Color.red);
                YouWonOrLost.setText("Better Luck Next Time!");
                setTitle("You Lost");
            }

            //
            int currentInt = Integer.parseInt(frame.clock.getTime());
            currentRecord.setText(currentInt + " seconds");

            if (WinOrLose) {
                if (currentInt < personalBest) {
                    personalBestString = String.valueOf(currentInt);
                    personalBest = Integer.parseInt(personalBestString);
                }
                gamesWon++;
            }
            personalBestString = String.valueOf(personalBest);
            gamesPlayedString = String.valueOf(gamesPlayed);
            gamesWonString = String.valueOf(gamesWon);
            bestRecord.setText(personalBestString + " seconds");
            gmsPlayedLabel.setText(gamesPlayedString);
            gmsWonLabel.setText(gamesWonString);
            prc.setText(prcntgg + "%");

            pw = new PrintWriter(new FileWriter("records.txt"));
            pw.println(gamesPlayed);
            pw.println(gamesWon);
            pw.println(personalBest);
            pw.close();

        } catch (Exception ex) {
            System.out.println("EXCEPTION DUDE");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        YouWonOrLost = new javax.swing.JLabel();
        bestRecord = new javax.swing.JLabel();
        currentRecord = new javax.swing.JLabel();
        restartButton = new javax.swing.JButton();
        playAgainButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        currentRecord1 = new javax.swing.JLabel();
        labelOfRecord = new javax.swing.JLabel();
        gmsPlayedLabel = new javax.swing.JLabel();
        gamesPlayedLabel1 = new javax.swing.JLabel();
        gmsWonLabel = new javax.swing.JLabel();
        gamesWonLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        prc = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(790, 430));
        setPreferredSize(new java.awt.Dimension(400, 300));
        setResizable(false);
        setSize(new java.awt.Dimension(400, 300));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setLayout(null);

        YouWonOrLost.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        YouWonOrLost.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        YouWonOrLost.setText("you lose/win");
        jPanel1.add(YouWonOrLost);
        YouWonOrLost.setBounds(80, 10, 240, 34);

        bestRecord.setBackground(new java.awt.Color(255, 255, 255));
        bestRecord.setForeground(new java.awt.Color(255, 255, 255));
        bestRecord.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bestRecord.setText("bestTime");
        jPanel1.add(bestRecord);
        bestRecord.setBounds(129, 82, 80, 16);

        currentRecord.setBackground(new java.awt.Color(255, 255, 255));
        currentRecord.setForeground(new java.awt.Color(255, 255, 255));
        currentRecord.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        currentRecord.setText("currentTime");
        jPanel1.add(currentRecord);
        currentRecord.setBounds(80, 50, 92, 20);

        restartButton.setBackground(new java.awt.Color(102, 255, 255));
        restartButton.setText("Restart");
        restartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartButtonActionPerformed(evt);
            }
        });
        jPanel1.add(restartButton);
        restartButton.setBounds(150, 210, 100, 40);

        playAgainButton.setBackground(new java.awt.Color(102, 255, 255));
        playAgainButton.setText("Play Again");
        playAgainButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playAgainButtonActionPerformed(evt);
            }
        });
        jPanel1.add(playAgainButton);
        playAgainButton.setBounds(260, 210, 100, 40);

        exitButton.setBackground(new java.awt.Color(102, 255, 255));
        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        jPanel1.add(exitButton);
        exitButton.setBounds(40, 210, 100, 40);

        currentRecord1.setBackground(new java.awt.Color(255, 255, 255));
        currentRecord1.setForeground(new java.awt.Color(255, 255, 255));
        currentRecord1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        currentRecord1.setText("Time:");
        jPanel1.add(currentRecord1);
        currentRecord1.setBounds(30, 50, 50, 20);

        labelOfRecord.setBackground(new java.awt.Color(255, 255, 255));
        labelOfRecord.setForeground(new java.awt.Color(255, 255, 255));
        labelOfRecord.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelOfRecord.setText("Personal Best: ");
        jPanel1.add(labelOfRecord);
        labelOfRecord.setBounds(32, 80, 100, 20);

        gmsPlayedLabel.setForeground(new java.awt.Color(255, 255, 255));
        gmsPlayedLabel.setText("gmsPlayed");
        jPanel1.add(gmsPlayedLabel);
        gmsPlayedLabel.setBounds(130, 110, 90, 16);

        gamesPlayedLabel1.setForeground(new java.awt.Color(255, 255, 255));
        gamesPlayedLabel1.setText("Games Played: ");
        jPanel1.add(gamesPlayedLabel1);
        gamesPlayedLabel1.setBounds(40, 110, 90, 16);

        gmsWonLabel.setForeground(new java.awt.Color(255, 255, 255));
        gmsWonLabel.setText("gmsWon");
        jPanel1.add(gmsWonLabel);
        gmsWonLabel.setBounds(120, 140, 90, 16);

        gamesWonLabel.setForeground(new java.awt.Color(255, 255, 255));
        gamesWonLabel.setText("Games Won: ");
        jPanel1.add(gamesWonLabel);
        gamesWonLabel.setBounds(40, 140, 75, 16);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Percentage:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(40, 170, 70, 16);

        prc.setForeground(new java.awt.Color(255, 255, 255));
        prc.setText("jLabel2");
        jPanel1.add(prc);
        prc.setBounds(115, 170, 41, 16);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 400, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void restartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restartButtonActionPerformed
        dispose();
        for (int j = 0; j < frame.houses.length; j++) {
            for (int i = 0; i < frame.houses[j].length; i++) {
                frame.houses[j][i].label.setIcon(Sprites.house_idle_ico);
                frame.houses[j][i].clicked = false;
                frame.houses[j][i].flaged = false;
                frame.houses[j][i].questioned = false;
                frame.houses[j][i].unclickable = false;
                frame.houses[j][i].afterClick = false;
            }
        }
        for (int j = 0; j < frame.houses.length; j++) {
            for (int i = 0; i < frame.houses[j].length; i++) {
                frame.houses[j][i].label.setEnabled(true);
            }
        }
        frame.letPlay = true;
        frame.clock = new Clock(frame.time, frame);
        frame.checkWinner = new CheckWinner(frame);
        frame.checkWinner.start();
        frame.numberOfBombsLeft = 10;
    }//GEN-LAST:event_restartButtonActionPerformed

    private void playAgainButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playAgainButtonActionPerformed
        dispose();
        frame.dispose();
        try {
            new MainWindow().setVisible(true);
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_playAgainButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel YouWonOrLost;
    private javax.swing.JLabel bestRecord;
    private javax.swing.JLabel currentRecord;
    private javax.swing.JLabel currentRecord1;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel gamesPlayedLabel1;
    private javax.swing.JLabel gamesWonLabel;
    private javax.swing.JLabel gmsPlayedLabel;
    private javax.swing.JLabel gmsWonLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelOfRecord;
    private javax.swing.JButton playAgainButton;
    private javax.swing.JLabel prc;
    private javax.swing.JButton restartButton;
    // End of variables declaration//GEN-END:variables

}

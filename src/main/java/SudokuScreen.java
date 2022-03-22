/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BL4CKTRUM
 */

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SudokuScreen extends javax.swing.JFrame {
    private final int[][]puzzle;
    private final int[][]solutionOfPuzzle;
    private final ArrayList<Coords> filledcells = new ArrayList<Coords>();


    /**
     *
     * @param puzzle stores the puzzle to be able to give hint.
     * @param solutionOfPuzzle  stores the puzzle's solution.
     */
    public SudokuScreen(int[][] puzzle, int [][] solutionOfPuzzle) {
        this.puzzle=puzzle;
        this.solutionOfPuzzle=solutionOfPuzzle;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        giveHintButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        playOnOtherDeviceButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        showSolutionButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sudoku");
        setBackground(java.awt.SystemColor.activeCaption);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);

        giveHintButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        giveHintButton.setText("Give Hint");
        giveHintButton.setFocusable(false);
        giveHintButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setLayout(new java.awt.GridLayout(9, 9));

        playOnOtherDeviceButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        playOnOtherDeviceButton.setText("Play on Other Device");
        playOnOtherDeviceButton.setFocusable(false);
        playOnOtherDeviceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        exitButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        exitButton.setText("Exit");
        exitButton.setFocusable(false);
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        showSolutionButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        showSolutionButton.setText("Show Solution");
        showSolutionButton.setFocusable(false);
        showSolutionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(giveHintButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(playOnOtherDeviceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(showSolutionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(giveHintButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(showSolutionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(playOnOtherDeviceButton)
                                        .addComponent(exitButton))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        for(int i = 0 ; i < 9 ; i++){
            for(int j = 0 ; j < 9 ; j++){
                JLabel cell = new JLabel();
                cell.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                if(puzzle[i][j]==0)cell.setText(" ");
                else {cell.setText(String.valueOf(puzzle[i][j]));
                    filledcells.add(new Coords(i, j));
                }
                cell.setHorizontalAlignment(0);
                cell.setVerticalAlignment(0);
                jPanel1.add(cell);
            }
        }

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        GiveHint();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        showSolution();
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        showSentDeviceScreen();
    }

    private void showSentDeviceScreen(){
        setVisible(false);
        dispose();
        new SendToDeviceScreen().setVisible(true);
    }

    private void showSolution(){
        jPanel1.removeAll();
        for(int i = 0 ; i < 9 ; i++){
            for(int j = 0 ; j < 9 ; j++){
                puzzle[i][j]=solutionOfPuzzle[i][j];
                JLabel cell = new JLabel();
                cell.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                cell.setText(String.valueOf(solutionOfPuzzle[i][j]));
                cell.setHorizontalAlignment(0);
                cell.setVerticalAlignment(0);
                jPanel1.add(cell);
            }
        }
        jPanel1.revalidate();
        jPanel1.repaint();
    }

    private void GiveHint(){

        Coords randomcoord = new Coords((int)(Math.random()*10)%9, (int)(Math.random()*10)%9);
        for(int i = 0 ; i < filledcells.size(); i++) {
            while (filledcells.get(i).equals(randomcoord) & i!=filledcells.size()){
                randomcoord = new Coords((int)(Math.random()*10)%9, (int)(Math.random()*10)%9);}
        }

        if(filledcells.get(filledcells.size()-1)!=randomcoord){
            puzzle[randomcoord.x][randomcoord.y]=solutionOfPuzzle[randomcoord.x][randomcoord.y];

            jPanel1.removeAll();
            for(int i = 0 ; i < 9 ; i++){
                for(int j = 0 ; j < 9 ; j++){
                    JLabel cell = new JLabel();
                    cell.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    if(getPuzzle()[i][j]==0)cell.setText(" ");
                    else {cell.setText(String.valueOf(getPuzzle()[i][j]));
                        filledcells.add(new Coords(i, j));
                    }
                    cell.setHorizontalAlignment(0);
                    cell.setVerticalAlignment(0);
                    jPanel1.add(cell);
                }
            }

            jPanel1.revalidate();

            jPanel1.repaint();
        }
    }


    //To store filled cells.
    private static class Coords {
        int x;
        int y;

        public boolean equals(Object o) {
            Coords c = (Coords) o;
            return c.x == x && c.y == y;
        }

        public Coords(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
    }

    /**
     * @return the puzzle
     */
    public int[][] getPuzzle() {
        return puzzle;
    }

    // Variables declaration - do not modify
    private javax.swing.JButton giveHintButton;
    private javax.swing.JButton showSolutionButton;
    private javax.swing.JButton playOnOtherDeviceButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration


}
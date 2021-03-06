/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BL4CKTRUM
 */
public class DifficultySelectionScreen extends javax.swing.JFrame {

    private static SudokuScreen sudokuScreen;
    private static Solver solver = new Solver();
    private static Cleaner cleaner = new Cleaner();
    private static int initiateClue;
    /**
     * Creates new form Gui2
     */
    public DifficultySelectionScreen() {
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

        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        exitButton = new javax.swing.JButton();
        playButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sudo'KOnline");
        setBackground(new java.awt.Color(0, 0, 0));
        setLocationByPlatform(true);
        setResizable(false);

        jComboBox2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal", "Hard" }));
        jComboBox2.setFocusable(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel2.setText("Difficulty");

        exitButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        exitButton.setText("Exit");
        exitButton.setFocusable(false);
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        playButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        playButton.setText("Play");
        playButton.setFocusable(false);
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(playButton, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(27, 27, 27)
                                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                                .addComponent(playButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(exitButton)
                                .addGap(22, 22, 22))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {

        String value = (String)jComboBox2.getSelectedItem();
        if(value.equals("Hard")) {
            initiateClue = 17;
            System.out.println("17");
        } else {
            initiateClue = 25;
        }

        createSudoku();
    }


    // Variables declaration - do not modify
    private javax.swing.JButton exitButton;
    private javax.swing.JButton playButton;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration


    private void createSudoku(){
        //ald?????? inputlara g??re buras?? d??zenlenerek gui1'i uygun ??ekilde ??a????rmal??
        //create a full solved puzzle
        int [][] solved = createSolved(solver);
        int[][] copyOfSolved = new int[9][9];
        //Deep copy to show solution in the end.
        for(int i=0; i<9; i++) {
            for (int j = 0; j < 9; j++) {
                copyOfSolved[i][j] = solved[i][j];
            }
        }
        //clean full solved puzzle to introduce
        int[][] cleaned= createToIntroduce(cleaner,copyOfSolved);

        setVisible(false);
        dispose();
        sudokuScreen = new SudokuScreen(cleaned,solved);
        sudokuScreen.setVisible(true);
    }


    private static int[][] createSolved(Solver solver){
        int[][] solved = solver.generateFull();
        return solved;
    }


    private static int[][] createToIntroduce(Cleaner cleaner, int[][] grid){
        int[][] cleaned = cleaner.cleanFull(grid);
        return cleaned;
    }

    /**
     * @return the puzzleScreen
     */
    public static SudokuScreen getSudokuScreen() {
        return sudokuScreen;
    }

    /**
     * @return the initiateClue
     */
    public static int getInitiateClue() {
        return initiateClue;
    }

}

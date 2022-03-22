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

public class Main {

    public static void main(String[] args) {
        showLoginScreen();
    }


    private static void showLoginScreen(){

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); //set look&feel to system props.
                    new LoginScreen().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}




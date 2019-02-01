package com.sedatram.view.general;
import javax.swing.*;

public class App {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
        } catch(IllegalAccessException e) {
            e.printStackTrace();
        } catch(InstantiationException e) {
            e.printStackTrace();
        } catch(UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Auth();
            }
        });
    }
}

package edu.kcc;

import edu.kcc.Languages.LanguageOptions;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class App {

    public static void main(String[] args) {
        Languages.setResourceBundle(LanguageOptions.USA);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainFrame();
            }
        });

    }

}

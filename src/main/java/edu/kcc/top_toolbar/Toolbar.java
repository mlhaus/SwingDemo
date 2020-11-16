/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kcc.top_toolbar;

import edu.kcc.Languages;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Toolbar extends JPanel implements ActionListener {
    private ResourceBundle messages = Languages.getResourceBundle();
//    private JButton helloButton;
//    private JButton goodbyeButton;
    private JLabel name_label; // NEW
    private JTextField name_field; // NEW
    private JButton go_button; // NEW
    private StringListener textListener;

    public Toolbar() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        
//        helloButton = new JButton(messages.getString("say-hello"));
//        add(helloButton);
//        helloButton.addActionListener(this);
//        
//        goodbyeButton = new JButton(messages.getString("say-goodbye"));
//        add(goodbyeButton);
//        goodbyeButton.addActionListener(this);
        name_label = new JLabel(messages.getString("inquiry")); // NEW
        add(name_label); // NEW
        
        name_field = new JTextField(10); // NEW
        add(name_field); // NEW
        
        go_button = new JButton(messages.getString("button")); // NEW
        add(go_button); // NEW
        go_button.addActionListener(this); // NEW
    }
    
    public void setStringListener(StringListener listener) {
        this.textListener = listener;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(textListener != null) { 
            String name = name_field.getText();
            textListener.getText(name);
        }
//        JButton clicked = (JButton) e.getSource();
//        if(clicked == helloButton) {
//            if(textListener != null) {
//                textListener.getText(messages.getString("say-hello"));
//            }
//        } else if(clicked == goodbyeButton) {
//            if(textListener != null) {
//                textListener.getText(messages.getString("say-goodbye"));
//            }
//        }
    }
}
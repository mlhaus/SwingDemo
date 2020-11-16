/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kcc;

import edu.kcc.left_form.FormPanel;
import edu.kcc.left_form.FormListener;
import edu.kcc.left_form.FormEvent;
import edu.kcc.top_toolbar.StringListener;
import edu.kcc.top_toolbar.Toolbar;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MainFrame extends JFrame {
    private ResourceBundle messages = Languages.getResourceBundle();
    private Toolbar toolbar;
    private TextPanel textPanel;
    private FormPanel formPanel;
    
    public MainFrame() {
        super();
        setTitle(messages.getString("title"));
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(new BorderLayout());
        
        toolbar = new Toolbar();
        add(toolbar, BorderLayout.NORTH);
        toolbar.setStringListener(new StringListener() {
            @Override
            public void getText(String text) {
                textPanel.appendText(messages.getString("greeting") + ", " + text + "\n");
            }
        });
        
        formPanel = new FormPanel();
        add(formPanel, BorderLayout.WEST);
        formPanel.setListener(new FormListener() {
            @Override
            public void formSubmit(FormEvent formEvent) {
                String name = formEvent.getName();
                String occupation = formEvent.getOccupation();
                int ageCategoryId = formEvent.getAgeCategoryId();
                String employmentStatus = formEvent.getEmploymentStatus();
                
                textPanel.appendText(name + ": " + occupation + ": " + ageCategoryId + ": " + employmentStatus + "\n");
            }
        });
        
        textPanel = new TextPanel();
        add(textPanel, BorderLayout.CENTER);
        
        setVisible(true);
    }
}
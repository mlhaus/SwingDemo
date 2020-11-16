/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kcc.left_form;

import edu.kcc.left_form.FormListener;
import edu.kcc.left_form.FormEvent;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;

/**
 *
 * @author marchauschildt
 */
public class FormPanel extends JPanel {
    private JLabel name_label;
    private JLabel occupation_label;
    private JLabel age_label;
    private JLabel employment_type_label;
    private JTextField name_field;
    private JTextField occupation_field;
    private JButton go_button;
    private JList age_list;
    private JComboBox employment_type_combo;
    private FormListener formListener;
    
    public FormPanel () {
        Dimension size = getPreferredSize();
        size.width = 250;
        setPreferredSize(size);
        
        Border inner_border = BorderFactory.createTitledBorder("Add Person");
        Border outer_border = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outer_border, inner_border));
        
        name_label = new JLabel("Name: ");
        occupation_label = new JLabel("Occupation: ");
        age_label = new JLabel("Age: ");
        employment_type_label = new JLabel("Status: ");
        name_field = new JTextField(10);
        occupation_field = new JTextField(10);
        age_list = new JList();
        employment_type_combo = new JComboBox();
        
        // Sets up JList
        DefaultListModel<AgeCategory> ageModel = new DefaultListModel();
        ageModel.addElement(new AgeCategory(0, "Under 18"));
        ageModel.addElement(new AgeCategory(1, "18 to 32"));
        ageModel.addElement(new AgeCategory(2, "35 to 49"));
        ageModel.addElement(new AgeCategory(3, "50 to 64"));
        ageModel.addElement(new AgeCategory(4, "65 or over"));
        age_list.setModel(ageModel);
        age_list.setPreferredSize(new Dimension(110, 90));
        age_list.setBorder(BorderFactory.createEtchedBorder());
        age_list.setSelectedIndex(1);
        age_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        // Sets up JComboBox
        DefaultComboBoxModel empTypeModel = new DefaultComboBoxModel();
        empTypeModel.addElement("Employed");
        empTypeModel.addElement("Self-employed");
        empTypeModel.addElement("Unemployed");
        employment_type_combo.setModel(empTypeModel);
        employment_type_combo.setSelectedIndex(0);
        employment_type_combo.setEditable(true);
        
        
        go_button = new JButton("Go");
        go_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = name_field.getText();
                String occupation = occupation_field.getText();
                AgeCategory age_category = (AgeCategory)age_list.getSelectedValue();
                String employment_status = (String)employment_type_combo.getSelectedItem();
                
                FormEvent event = new FormEvent(this, name, occupation, age_category.getId(), employment_status);
                if(formListener != null) {
                    formListener.formSubmit(event);
                }
            }
        });
        
        layoutComponents();
    }
    
    public void setListener(FormListener formListener) {
        this.formListener = formListener;
    }
    
    public void layoutComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        
        /******** First row ********/
        gc.gridy = 0;
        
        gc.weightx = 1;
        gc.weighty = 1;
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        add(name_label, gc);
        
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(name_field, gc);
        
        /******** Second row ********/
        gc.gridy++;
        
        gc.weightx = 1;
        gc.weighty = 1;
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        add(occupation_label, gc);
        
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(occupation_field, gc);
        
        /******** Third row ********/
        gc.gridy++;
        
        gc.weightx = 1;
        gc.weighty = 1;
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(age_label, gc);
        
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(age_list, gc);
        
        /******** Fourth row ********/
        gc.gridy++;
        
        gc.weightx = 1;
        gc.weighty = 1;
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(employment_type_label, gc);
        
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(employment_type_combo, gc);
        
        /******** Fifth row ********/
        gc.gridy++;
        
        gc.weightx = 1;
        gc.weighty = 20;
        
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(go_button, gc);
    }
}

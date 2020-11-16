/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kcc.left_form;

/**
 *
 * @author marchauschildt
 */
public class AgeCategory {
    private int id;
    private String text;
    
    public AgeCategory(int id, String text) {
        this.id = id;
        this.text = text;
    }
    
    public String toString() {
        return text;
    }
    
    public int getId() {
        return id;
    }
}

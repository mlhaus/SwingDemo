/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kcc.left_form;

import java.util.EventObject;

/**
 *
 * @author marchauschildt
 */
public class FormEvent extends EventObject {
    private String name;
    private String occupation;
    private int ageCategoryId;
    private String employmentStatus;
    
    public FormEvent(Object source, String name, String occupation, int ageCategoryId, String employmentStatus) {
        super(source);
        this.name = name;
        this.occupation = occupation;
        this.ageCategoryId = ageCategoryId;
        this.employmentStatus = employmentStatus;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getOccupation() {
        return occupation;
    }
    
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    
    public int getAgeCategoryId() {
        return ageCategoryId;
    }
    
    public void setAgeCategoryId(int ageCategoryId) {
        this.ageCategoryId = ageCategoryId;
    }
    
    public String getEmploymentStatus() {
        return employmentStatus;
    }
    
    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }
}

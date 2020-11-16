/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kcc.left_form;

import edu.kcc.left_form.FormEvent;
import java.util.EventListener;

/**
 *
 * @author marchauschildt
 */
public interface FormListener extends EventListener {
    public void formSubmit(FormEvent formEvent);
}

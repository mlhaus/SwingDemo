/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kcc;

import java.util.Locale;
import java.util.ResourceBundle;

public class Languages {
    public enum LanguageOptions { USA }; // Add additional language options
    private static ResourceBundle messages = ResourceBundle.getBundle("messages", Locale.getDefault());
    
    public static ResourceBundle getResourceBundle() {
        return messages;
    }

    public static void setResourceBundle(LanguageOptions language) {
        Locale locale = Locale.getDefault();
        switch(language) {
            case USA:
                locale = Locale.US;
                break;
            // Add additional cases for each language
        }
        messages = ResourceBundle.getBundle("messages", locale);
    }
}

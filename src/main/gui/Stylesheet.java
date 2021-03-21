package main.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import java.awt.event.*;

public class Stylesheet {
    /**
     * Format a text field
     */
    public static void formatTextField(JTextField textField) {
        textField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));

        textField.addFocusListener(new TextFieldFocusListener());

        
    } 

    /**
     * Used for the blue highlight on focus
     */
    private static class TextFieldFocusListener implements FocusListener {
        public void focusLost(FocusEvent e) {
            JTextField field = (JTextField) e.getSource();

            Stylesheet.formatTextField(field);
        }

        public void focusGained(FocusEvent e) {
            JTextField field = (JTextField) e.getSource();

            field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 153, 255)),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
            ));
        }
    }


    /**
     * Format a button 
     * 
     * @param style - primary, secondary
     */
    public static void formatButton(JButton button, String style) {
        if (style.equals("primary")) {
            button.setBackground(new Color(2, 117, 36));
            button.setForeground(Color.WHITE);

            button.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, new Color(2, 117, 36)));
        } else if (style.equals("secondary")) {
            button.setBackground(Color.WHITE);
            button.setForeground(new Color(2, 117, 36));

            button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(2, 117, 36)),
                BorderFactory.createEmptyBorder(3, 3, 3, 3)
            ));
        }

        button.setFont(new Font("Arial", Font.PLAIN, 18));

        
    }
}

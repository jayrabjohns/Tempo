package main.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.border.Border;
import java.awt.event.*;

public class Stylesheet {
    /**
     * Format an input field
     * 
     * Applies a grey border that turns blue when the input is put in focus
     */
    public static void formatInput(JComponent textField) {
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

            Stylesheet.formatInput(field);
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

    /**
     * Format an alert box
     */
    public static void formatAlert(JAlert alert) {
        Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);

        // Format based on alert type
        if (alert.getType() == JAlert.TYPE_SUCCESS) {
            alert.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(45, 134, 45)),
                padding
            ));

            alert.setBackground(new Color(179, 230, 179));
        } else if (alert.getType() == JAlert.TYPE_ERROR) {
            alert.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(204, 51, 0)),
                padding
            ));

            alert.setBackground(new Color(255, 153, 153));
        }  else if (alert.getType() == JAlert.TYPE_INFO) {
            alert.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0, 115, 230)),
                padding
            ));

            alert.setBackground(new Color(179, 217, 255));
        }
    }
}

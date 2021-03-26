package main.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.border.Border;
import java.awt.event.*;
import java.awt.Component;
import java.awt.Dimension;

public class Stylesheet {

    // Generic App
    public static final Color  APP_BACKGROUND                  = new Color(240, 240, 249);
    public static final Color  APP_HEADER_BACKGROUND           = new Color(0, 51, 0);
    public static final Color  APP_FOOTER_BACKGROUND           = new Color(0, 51, 0);

    // Headers
    public static final Font   HEADER_1_FONT                   = new Font("Arial", Font.BOLD, 30);
    public static final Color  HEADER_1_COLOR                  = Color.WHITE;

    // Text Fields
    public static final Border INPUT_PADDING                   = BorderFactory.createEmptyBorder(4, 4, 4, 4);
    public static final int    INPUT_PADDING_TOP_BOTTOM        = 5;
    public static final Border INPUT_BORDER                    = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY);
    public static final Border INPUT_FOCUS_BORDER              = BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 153, 255));


    // Buttons
    public static final Border BUTTON_PADDING                  = BorderFactory.createEmptyBorder(3, 3, 3, 3);
    public static final Font   BUTTON_FONT                     = new Font("Arial", Font.PLAIN, 18);

    public static final Color  BUTTON_PRIMARY_BACKGROUND       = new Color(2, 117, 36);
    public static final Color  BUTTON_PRIMARY_FOREGROUND       = Color.WHITE;
    public static final Border BUTTON_PRIMARY_BORDER           = BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(2, 117, 36));

    public static final Color  BUTTON_SECONDARY_BACKGROUND     = Color.WHITE;
    public static final Color  BUTTON_SECONDARY_FOREGROUND     = new Color(2, 117, 36);
    public static final Border BUTTON_SECONDARY_BORDER         = BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(2, 117, 36));

    // Alerts
    public static final Border ALERT_PADDING                   = BorderFactory.createEmptyBorder(10, 10, 10, 10);
    public static final Font   ALERT_TITLE_FONT                = new Font("Arial", Font.BOLD, 14);
    
    public static final Border ALERT_INFO_BORDER               = BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0, 115, 230));
    public static final Color  ALERT_INFO_BACKGROUND           = new Color(179, 217, 255);


    public static final Border ALERT_SUCCESS_BORDER            = BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(45, 134, 45));
    public static final Color  ALERT_SUCCESS_BACKGROUND        = new Color(179, 230, 179);

    public static final Border ALERT_ERROR_BORDER              = BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(204, 51, 0));
    public static final Color  ALERT_ERROR_BACKGROUND          = new Color(255, 153, 153);

    
    

    /**
     * Format an input field
     * 
     * Applies a grey border that turns blue when the input is put in focus
     */
    public static void formatInput(JComponent textField) {
        textField.setBorder(BorderFactory.createCompoundBorder(
            INPUT_BORDER,
            INPUT_PADDING
        ));

        //textField.setPreferredSize(new Dimension(textField.getPreferredSize().width, textField.getPreferredSize().height + INPUT_PADDING_TOP_BOTTOM));
        textField.setMaximumSize(new Dimension(Integer.MAX_VALUE, textField.getPreferredSize().height + INPUT_PADDING_TOP_BOTTOM));
        


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
                INPUT_FOCUS_BORDER,
                INPUT_PADDING
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
            button.setBackground(BUTTON_PRIMARY_BACKGROUND);
            button.setForeground(BUTTON_PRIMARY_FOREGROUND);

            button.setBorder(BorderFactory.createCompoundBorder(
                BUTTON_PRIMARY_BORDER,
                BUTTON_PADDING
            ));
            //button.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, new Color(2, 117, 36)));
        } else if (style.equals("secondary")) {
            button.setBackground(BUTTON_SECONDARY_BACKGROUND);
            button.setForeground(BUTTON_SECONDARY_FOREGROUND);

            button.setBorder(BorderFactory.createCompoundBorder(
                BUTTON_SECONDARY_BORDER,
                BUTTON_PADDING
            ));
        }

        button.setFont(BUTTON_FONT);        
    }

    /**
     * Format an alert box
     */
    public static void formatAlert(JAlert alert) {
        // Format based on alert type
        if (alert.getType() == JAlert.TYPE_SUCCESS) {
            alert.setBorder(BorderFactory.createCompoundBorder(
                ALERT_SUCCESS_BORDER,
                ALERT_PADDING
            ));

            alert.setBackground(ALERT_SUCCESS_BACKGROUND);
        } else if (alert.getType() == JAlert.TYPE_ERROR) {
            alert.setBorder(BorderFactory.createCompoundBorder(
                ALERT_ERROR_BORDER,
                ALERT_PADDING
            ));

            alert.setBackground(ALERT_ERROR_BACKGROUND);
        }  else if (alert.getType() == JAlert.TYPE_INFO) {
            alert.setBorder(BorderFactory.createCompoundBorder(
                ALERT_INFO_BORDER,
                ALERT_PADDING
            ));

            alert.setBackground(ALERT_INFO_BACKGROUND);
        }

        alert.titleLabel.setFont(ALERT_TITLE_FONT);
    }

    /**
     * Format the main background colour
     * @param c
     */
    public static void formatMainBackground(Component c) {
        c.setBackground(APP_BACKGROUND);
    }

    /**
     * Format the main header colour
     * @param c
     */
    public static void formatTitleBackgorund(Component c) {
        c.setBackground(APP_HEADER_BACKGROUND);
    }

    /**
     * Format the main footer colour
     * @param c
     */
    public static void formatFooterBackgorund(Component c) {
        c.setBackground(APP_FOOTER_BACKGROUND);
    }

    /**
     * Format a component for a header
     * 
     * @param c
     * @param n The larger the number the larger the header (similar to HTML)
     */
    public static void formatHeader(Component c, int n) {
        if(n == 1) {
            c.setFont(HEADER_1_FONT);
            c.setForeground(HEADER_1_COLOR);
        }   
    }
}

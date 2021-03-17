package gui;

import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * Represents an abstract form
 */
public abstract class Form extends JFrame {    
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Create the form. Override this method in subclasses to draw the form elements.
     * 
     * @param size The size of the form (Use 'Screen.getDefaultSize();')
     */
    public Form(Dimension size) {
        this.setSize(size);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Show/Hide the form.
     *
     * @param visible true to show, false to hide
     */
    public void setVisible(boolean visible) {
        // Reset to center of screen
        if(visible) {
            this.setLocationRelativeTo(null);
        }

        super.setVisible(visible);
    }
}
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

    public Form(Dimension size) {
        this.setSize(size);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setVisible(boolean visible) {
        // Reset to center of screen
        if(visible) {
            this.setLocationRelativeTo(null);
        }

        super.setVisible(visible);
    }
}
package main.gui;

import java.awt.Dimension;

import javax.swing.JFrame;

import icons.IconFetcher;

/**
 * Represents an abstract form
 */
public abstract class Form extends JFrame implements Alertable {    
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Create the form. Override this method in subclasses to draw the form elements.
     * 
     * @param size The size of the form (Use 'Screen.getDefaultSize();')
     * @deprecated As the screen class will now set the default size
     */
    public Form(Dimension size) {
        this();
        this.setSize(size);
    }

    /**
     * Create the form. Override this method in subclasses to draw the form elements.
     */
    public Form() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setIconImage(IconFetcher.getIcon("tempo.png").getImage());
    }

    /**
     * Override this method to show an alert on the form
     * 
     * @param alert The alert to show
     */
    public void showAlert(JAlert alert) {
        // Do Nothing
        return;
    }
}
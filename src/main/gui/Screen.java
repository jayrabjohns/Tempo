package main.gui;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.awt.Dimension;

/**
 * Simulates the screen of a moblie phone
 */
public class Screen {
    private static Map<String, Form> forms = new HashMap<>();
    
    private static Stack<Popup> dialogStack = new Stack<>();

    private static Form activeForm;

    private static Dimension initialSize = new Dimension(500, 800);

    /**
     * Register a form with the screen
     * 
     * @param name The name the form can be referenced width
     * @param form The form object
     */
    public static void registerForm(String name, Form form) {
        Screen.forms.put(name, form);
    }

    /**
     * Show a form on the "screen"
     * 
     * @param form A form object
     */
    public static void showForm(Form form) {

        // Only show the form if there is no dialog present
        if (Screen.dialogStack.empty()) {
            Screen.switchForm(Screen.activeForm, form);        
        }

        Screen.activeForm = form;
    }

    /**
     * Switch the form currently on display
     * 
     * @param form
     */
    private static void switchForm(Form oldForm, Form form) {

        // Check if they are the same form
        if(oldForm == form) {
            return;
        }

        // Set the initial size
        form.setSize(Screen.getDefaultSize());

        // Put form in the middle of the screen
        form.setLocationRelativeTo(null);

        // Hide the old form
        if(oldForm != null) {
            // Overwrite initial size
            form.setSize(oldForm.getSize());

            // Set the location based on the old form rather than center
            form.setLocation(oldForm.getLocation());
        }
        
        form.revalidate();

        // Show the new form
        form.setVisible(true);

        if (oldForm != null) {
            oldForm.setVisible(false);
        }
    }

    /**
     * Show a registered form
     * 
     * @param name The name of the form to show
     * @throws NullPointerException if the name is invalid
     */
    public static void showForm(String name) {
        Screen.showForm(Screen.getForm(name));
    }

    /**
     * Get a registered form
     * 
     * @param name The name of the form to get
     * @throws NullPointerException if the name is invalid
     */
    public static Form getForm(String name) {
        
        // Check the form exists
        if (!Screen.forms.containsKey(name)) {
            throw new ScreenException("Invalid Form Name");
        }

        return Screen.forms.get(name);
    }

    /**
     * Show a dialog 
     * 
     * @param form
     * @param blocking block until dialog is closed
     */
    public static Popup showDialog(Form form) {
        return Screen.showDialog(form, false, 50, 50);
    }

    /**
     * Show a dialog 
     * 
     * @param form
     * @param blocking block until dialog is closed
     */
    public static Popup showDialog(Form form, int horizontalMargin, int verticalMargin) {
        return Screen.showDialog(form, false, horizontalMargin, verticalMargin);
    }

    /**
     * Show a dialog (blocking) with set margins (blocking)
     * 
     * @param form
     */
    public static Popup showDialog(Form form, boolean blocking, int horizontalMargin, int verticalMargin) {
        java.awt.Window parent;

        if(Screen.dialogStack.size() == 0) {
            parent = Screen.activeForm;
        } else {
            parent = Screen.dialogStack.peek();
        }

        Popup popup = Popup.fromForm(form, parent, blocking);


        Form activeForm = Screen.activeForm;

        if (activeForm == null) {
            activeForm = new Form() {};
            // Set the initial size
            form.setSize(Screen.getDefaultSize());

            // Put form in the middle of the screen
            form.setLocationRelativeTo(null);
        }

        popup.setSize(new Dimension(activeForm.getSize().width - (horizontalMargin*2), activeForm.getSize().height - (verticalMargin*2)));
        popup.setLocation(activeForm.getLocation().x + horizontalMargin, activeForm.getLocation().y + verticalMargin);

        Screen.dialogStack.push(popup);

        popup.setVisible(true);

        return popup;
    }

    public static void returnDialog() {
        if(Screen.dialogStack.size() == 0) {
            throw new ScreenException("Dialog Stack Empty");
        } else if(Screen.dialogStack.size() == 1) {
            if(Screen.activeForm == null) {
                throw new ScreenException("No Active Form");
            }
        }

        Popup popup = Screen.dialogStack.pop();

        popup.setVisible(false);

        if(Screen.activeForm != null) {
            Screen.activeForm.setVisible(true);
        }

    }

    /**
     * Gets the default size that forms should apply to
     * 
     * @return The default size
     */
    public static Dimension getDefaultSize() {
        return Screen.initialSize;
    }

    /**
     * Set the inital size of the screen. This will not make any affect once a form has been opened.
     * 
     * @return The default size
     */
    public static void setDefaultSize(Dimension size) {
        Screen.initialSize = size;
    }

    public static void reinitialize() {
        Screen.activeForm = null;
        Screen.dialogStack = new Stack<>();
        Screen.forms = new HashMap<>();
        Screen.initialSize = new Dimension(500, 800);
    }
}


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
    
    private static Stack<Form> dialogStack = new Stack<>();

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

        if (Screen.dialogStack.size() > 0) {
            throw new ScreenException("Can't show a normal form when showing a modal form.");
        }

        Screen.switchForm(Screen.activeForm, form);        

        Screen.activeForm = form;
    }

    /**
     * Switch the form currently on display
     * 
     * @param form
     */
    private static void switchForm(Form oldForm, Form form) {
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
            throw new NullPointerException();
        }

        return Screen.forms.get(name);
    }

    /**
     * Show a form as a dialog
     */
    public static void showDialog(Form form) {

        Form oldForm = Screen.dialogStack.size() > 0 ? Screen.dialogStack.peek() : Screen.activeForm;

        Screen.switchForm(oldForm, form);

        Screen.dialogStack.push(form);
    }

    /**
     * Closes a modal form (if active)
     * 
     */
    public static void returnDialog() {
        if(Screen.dialogStack.size() == 0) {
            throw new ScreenException("Dialog Stack Empty");
        } 

        Form oldForm = Screen.dialogStack.pop();

        Form newForm = Screen.dialogStack.size() > 0 ? Screen.dialogStack.peek() : Screen.activeForm;

        if (newForm == null) {
            throw new ScreenException("No active form");
        }

        Screen.switchForm(oldForm, newForm);
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
}


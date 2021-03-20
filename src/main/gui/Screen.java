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
    
    private static Stack<Form> formStack = new Stack<>();

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
        // Set the initial size
        form.setSize(Screen.getDefaultSize());

        // Put form in the middle of the screen
        form.setLocationRelativeTo(null);

        // Hide the old form
        if(!Screen.formStack.empty()) {
            // Get the old form
            Form oldForm = Screen.formStack.peek();
            
            // Overwrite initial size
            form.setSize(oldForm.getSize());

            // Set the location based on the old form rather than center
            form.setLocation(oldForm.getLocation());
        }
        
        // Show the new form
        form.setVisible(true);

        if(!Screen.formStack.empty()) {
            // Hide the old form and take of the stack
            Screen.formStack.pop().setVisible(false);
        }

        // Add the new one to the stack
        Screen.formStack.push(form);
    }

    /**
     * Show a registered form
     * 
     * @param name The name of the form to show
     * @throws NullPointerException if the name is invalid
     */
    public static void showForm(String name) {
        
        // Check the form exists
        if (!Screen.forms.containsKey(name)) {
            throw new NullPointerException();
        }

        Screen.showForm(Screen.forms.get(name));
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


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
        // Hide the old form
        if(!Screen.formStack.empty()) {
            Screen.formStack.pop().setVisible(false);
        }

        // Show the new one
        Screen.formStack.push(form);
        form.setVisible(true);
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
        return new Dimension(new Dimension(500, 800));
    }
}


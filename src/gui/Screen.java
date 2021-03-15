import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.awt.Dimension;

public class Screen {
    private static Map<String, Form> forms = new HashMap<>();
    
    private static Stack<Form> formStack = new Stack<>();

    public static void registerForm(String name, Form form) {
        Screen.forms.put(name, form);
    }

    public static void showForm(Form form) {
        // Hide the old form
        if(!Screen.formStack.empty()) {
            Screen.formStack.pop().hide();
        }

        // Show the new one
        Screen.formStack.push(form);
        form.show();
    }

    public static void showForm(String name) {
        
        // Check the form exists
        if (!Screen.forms.containsKey(name)) {
            throw new NullPointerException();
        }

        Screen.showForm(Screen.forms.get(name));
    }

    public static Dimension getDefaultSize() {
        return new Dimension(new Dimension(500, 800));
    }
}


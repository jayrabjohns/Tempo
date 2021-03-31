package test.gui;

import static org.junit.jupiter.api.Assertions.*;
import javax.swing.JFrame;
import java.awt.Dimension;
import org.junit.jupiter.api.Test;
import main.gui.*;

public class ScreenTest {
    
    /**
     * Test setting/getting the default size
     */
    @Test
    public void size() {
        Dimension size = new Dimension(400, 400);

        Screen.setDefaultSize(size);

        assertEquals(size, Screen.getDefaultSize());
    }

    /**
     * Test getting a form that doesn't exist
     */
    @Test
    public void getNullForm() {
        // Test getting a form that doesn't exist
        Exception exception = assertThrows(ScreenException.class, () -> {
            Screen.getForm("IDontExist");
        });

        String expected = "Invalid Form Name";

        assertTrue(expected.equals(exception.getMessage()));
    }

    /**
     * Test registering/getting a form
     */
    @Test
    public void getForm() {
        Form form = new MockForm();

        Screen.registerForm("main", form);

        assertEquals(form, Screen.getForm("main"));
    }

    /**
     * Test getting a form that doesn't exist
     */
    @Test
    public void showNullForm() {
        // Test getting a form that doesn't exist
        Exception exception = assertThrows(ScreenException.class, () -> {
            Screen.showForm("IDontExist");
        });

        String expected = "Invalid Form Name";

        assertTrue(expected.equals(exception.getMessage()));
    }

    /**
     * Test form showing
     */
    @Test
    public void showForm() {
        Form formA = new MockForm();
        Form formB = new MockForm();

        Screen.showForm(formA);
        
        assertTrue(formA.isVisible());

        Screen.showForm(formB);
        assertTrue(formB.isVisible());
        assertFalse(formA.isVisible());
    }

    /**
     * Test form showing by name
     */
    @Test
    public void showFormByName() {
        Form formA = new MockForm();
        Form formB = new MockForm();

        Screen.registerForm("formA", formA);
        Screen.registerForm("formB", formB);

        Screen.showForm("formA");
        
        assertTrue(formA.isVisible());

        Screen.showForm("formB");
        assertTrue(formB.isVisible());
        assertFalse(formA.isVisible());
    }

    /**
     * Test returning when a dialog is not being shown
     */
    @Test
    /**
     * Test showing a dialog
     */
    public void returnNullDialog() {
        // Test returning when a dialog is not being shown
        Exception exception = assertThrows(ScreenException.class, () -> {
            Screen.returnDialog();
        });

        String expected = "Dialog Stack Empty";

        assertTrue(expected.equals(exception.getMessage()));
    }

    /**
     * Test showing a dialog
     */
    @Test
    public void showDialog() {
        Form dialogA = new MockForm();
        Form dialogB = new MockForm();

        // Show one dialog
        Screen.showDialog(dialogA);
        assertTrue(dialogA.isVisible());

        // Show one dialog on top of another
        Screen.showDialog(dialogB);
        assertTrue(dialogB.isVisible());
        assertFalse(dialogA.isVisible());

        // Return to the first dialog
        Screen.returnDialog();
        assertTrue(dialogA.isVisible());
        assertFalse(dialogB.isVisible());

        // Test returning with no active form
        Exception exception = assertThrows(ScreenException.class, () -> {
            Screen.returnDialog();
        });

        String expected = "No Active Form";

        assertTrue(expected.equals(exception.getMessage()));

        // Add an active form (should not be visible as dialog currently in view)
        Form form = new MockForm();
        Screen.showForm(form);
        assertFalse(form.isVisible());

        Screen.returnDialog();
        assertFalse(dialogA.isVisible());
        assertFalse(dialogB.isVisible());
        assertTrue(form.isVisible());
    }

    class MockForm extends Form {
        public MockForm() {
            super();
        }
    }
}

package tempo.gui;

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
        Screen.reinitialize();
        Dimension size = new Dimension(400, 400);

        Screen.setDefaultSize(size);

        assertEquals(size, Screen.getDefaultSize());
    }

    /**
     * Test getting a form that doesn't exist
     */
    @Test
    public void getNullForm() {
        Screen.reinitialize();
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
        Screen.reinitialize();
        Form form = new MockForm();

        Screen.registerForm("main", form);

        assertEquals(form, Screen.getForm("main"));
    }

    /**
     * Test getting a form that doesn't exist
     */
    @Test
    public void showNullForm() {
        Screen.reinitialize();
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
        Screen.reinitialize();
        Form formA = new MockForm();
        Form formB = new MockForm();

        Screen.showForm(formA);
        
        assertTrue(formA.isVisible());

        Screen.showForm(formB);
        assertTrue(formB.isVisible());
        assertFalse(formA.isVisible());
    }

    /**
     * Test showing the same form
     */
    @Test
    public void showSameForm() {
        Screen.reinitialize();
        Form formA = new MockForm();

        Screen.showForm(formA);
        Screen.showForm(formA);
        
        assertTrue(formA.isVisible());
    }

    /**
     * Test form showing by name
     */
    @Test
    public void showFormByName() {
        Screen.reinitialize();
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
        Screen.reinitialize();
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
        Screen.reinitialize();
        Form dialogA = new MockForm();
        Form dialogB = new MockForm();

        // Show one dialog
        Popup popupA = Screen.showDialog(dialogA, false, 50, 50);
        assertTrue(popupA.isVisible());

        // Show one dialog on top of another
        Popup popupB = Screen.showDialog(dialogB, false, 50, 50);
        assertTrue(popupB.isVisible());
        assertTrue(popupA.isVisible());

        // Return to the first dialog
        Screen.returnDialog();
        assertTrue(popupA.isVisible());
        assertFalse(popupB.isVisible());

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
        assertFalse(popupA.isVisible());
        assertFalse(popupB.isVisible());
        assertTrue(form.isVisible());
    }

    class MockForm extends Form {
        public MockForm() {
            super();
        }
    }
}

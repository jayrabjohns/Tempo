package test.gui;

import static org.junit.jupiter.api.Assertions.*;
import javax.swing.JFrame;
import java.awt.Dimension;
import org.junit.jupiter.api.Test;
import main.gui.*;


public class FormTest {

    private Dimension size = new Dimension(100, 100);
    
    @Test
    public void test() {
        Form form = new MockForm(this.size);

        JFrame frame = form;

        // Test the form dimensions were set as required
        assertEquals(frame.getWidth(), this.size.getWidth(), "Form width not set");
        assertEquals(frame.getHeight(), this.size.getHeight(), "Form height not set");

        // Test close operation
        assertEquals(frame.getDefaultCloseOperation(), JFrame.EXIT_ON_CLOSE);

        // Test showing
        // This should also test the form positioning
        form.setVisible(true);
        assertTrue(frame.isVisible(), "Form fails to show");

        // Test Hiding
        form.setVisible(false);
        assertTrue(!frame.isVisible(), "Form fails to hide");
        
    }

    public class MockForm extends Form {
        public MockForm(Dimension size) {
            super(size);
        }
    }
}

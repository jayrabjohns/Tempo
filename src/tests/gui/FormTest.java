package tests.gui;

import gui.*;

import static org.junit.jupiter.api.Assertions.*;
import javax.swing.JFrame;
import java.awt.Dimension;
import org.junit.jupiter.api.Test;


public class FormTest {

    private boolean drawn = false;

    private Dimension size = new Dimension(100, 100);
    
    @Test
    public void test() {
        this.drawn = false;
        Form form = new FormTester(this.size);

        // Test draw of child was ran on instantiation
        assertTrue(this.drawn, "The draw method must be called upon instantiation");

        JFrame frame = form.getForm();

        // Test the form dimensions were set as required
        assertEquals(frame.getWidth(), this.size.getWidth(), "Form width not set");
        assertEquals(frame.getHeight(), this.size.getHeight(), "Form height not set");

        // Test close operation
        assertEquals(frame.getDefaultCloseOperation(), JFrame.EXIT_ON_CLOSE);

        // Test showing
        form.show();
        assertTrue(frame.isVisible(), "Form fails to show");

        // Test Hiding
        form.hide();
        assertTrue(!frame.isVisible(), "Form fails to hide");
        
    }

    public class FormTester extends Form {
        public FormTester(Dimension size) {
            super(size);
        }

        public void draw() {
            FormTest.this.drawn = true;
        }
    }
}

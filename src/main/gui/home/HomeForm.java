package main.gui.home;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.LayoutManager;
import java.awt.GridLayout;
import java.awt.Dimension;
import main.gui.AbstractMainForm;
import main.gui.Stylesheet;
import main.gui.JAlert;
import java.awt.Component;

public class HomeForm extends AbstractMainForm {

    private HomeFormController controller;

    public HomeForm(HomeFormController controller) {
        super(controller);

        this.controller = controller;

        getContentPane().add(this.genMain());
    }

    public JPanel genBody() {

        JPanel panel = new JPanel();
		panel.setAutoscrolls(true);
		
		LayoutManager layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(layout);

        panel.add(Box.createVerticalStrut(10));

        
        return panel;
    }

    public void setVisible(boolean visible) {
        this.controller.onFormVisibleChange(visible);

        super.setVisible(visible);
    }

    
}

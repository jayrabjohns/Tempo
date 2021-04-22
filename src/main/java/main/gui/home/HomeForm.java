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

    private JPanel alertPane;

    public HomeForm(HomeFormController controller) {
        super(controller);

        this.controller = controller;

        getContentPane().add(this.genMain());
    }

    public void showAlert(JAlert alert) {
        alertPane.removeAll();
        alertPane.add(alert);
        alertPane.setMaximumSize(new Dimension(Integer.MAX_VALUE, alert.getPreferredSize().height));
        alertPane.revalidate();
    }


    public JPanel genBody() {

        JPanel panel = new JPanel();

        panel.setAutoscrolls(true);

        LayoutManager layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(layout);
        Stylesheet.formatMainBackground(panel);


        panel.add(Box.createVerticalStrut(10));
        JLabel header = new JLabel("Home");
        Stylesheet.formatHeader(header, 4);
        panel.add(header);

        panel.add(Box.createVerticalStrut(10));

        alertPane = new JPanel();
        alertPane.setLayout(new GridLayout());
        alertPane.setAlignmentX(Component.LEFT_ALIGNMENT);
        alertPane.setMaximumSize(new Dimension(Integer.MAX_VALUE, 0));
        controller.bindAlertPane(alertPane);
        panel.add(alertPane);
        
        return panel;
    }

    public void setVisible(boolean visible) {
        this.controller.onFormVisibleChange(visible);

        super.setVisible(visible);
    }

    
}

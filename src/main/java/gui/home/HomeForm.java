package gui.home;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.AbstractMainForm;
import gui.Stylesheet;

public class HomeForm extends AbstractMainForm {

    private HomeFormController controller;

    public HomeForm(HomeFormController controller) {
        super(controller);

        this.controller = controller;

        getContentPane().add(this.genMain());
    }

    public JPanel genBody() {
       JPanel panel = new JPanel();

       panel.add(new JLabel("Home"));

       JButton button = new JButton("Surprise me");
       this.controller.bindSurpriseMe(button);
       Stylesheet.formatButton(button, "secondary");
       panel.add(button);

       return panel;
    }
}

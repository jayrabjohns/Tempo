package main.gui.home;

import javax.swing.JLabel;
import javax.swing.JPanel;

import main.gui.AbstractMainForm;

public class HomeForm extends AbstractMainForm {

    public HomeForm(HomeFormController controller) {
        super(controller);

        getContentPane().add(this.genMain());
    }

    public JPanel genBody() {
       JPanel panel = new JPanel();

       panel.add(new JLabel("Home"));

       return panel;
    }
}

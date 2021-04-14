package gui.home;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import gui.example.Dialog;
import gui.Screen;

import gui.AbstractMainFormController;

public class HomeFormController extends AbstractMainFormController {


    public void bindSurpriseMe(JButton button) {
        button.addActionListener(new SurpriseMeButtonListener());
    }

    private class SurpriseMeButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Screen.showDialog(new Dialog("BOO!", 0));
        }
    }
}

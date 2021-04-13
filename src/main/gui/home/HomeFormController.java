package main.gui.home;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import main.gui.example.Dialog;
import main.gui.Screen;
import main.gui.JAlert;

import main.backend.messages.*;

import main.gui.AbstractMainFormController;

public class HomeFormController extends AbstractMainFormController {

    private MotivationalMessages messages;
    
    public HomeFormController(MotivationalMessages messages) {
        super();

        this.messages = messages;
    }

    public void bindSurpriseMe(JButton button) {
        button.addActionListener(new SurpriseMeButtonListener());
    }

    private class SurpriseMeButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Screen.showDialog(new Dialog("BOO!", 0));
        }
    }

    public void onFormVisibleChange(boolean visible) {
        if(visible) {
            MotivationalMessage message = new MotivationalMessage("");

            try {
                message = new MotivationalMessage(this.messages.chooseAGeneralQuote());
            } catch (Exception e) {

            }
            
           
        }
    }
}

package main.gui.home;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import main.backend.messages.MotivationalMessage;
import main.backend.messages.MotivationalMessages;
import main.gui.example.Dialog;
import main.gui.Screen;
import main.gui.JAlert;

import main.gui.AbstractMainFormController;

public class HomeFormController extends AbstractMainFormController {

    private MotivationalMessages messages;

    JPanel alertPane;
    
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

    public void bindAlertPane(JPanel panel) {
        this.alertPane = panel;
    }

    public void onFormVisibleChange(boolean visible) {
        if(visible) {
            MotivationalMessage message = new MotivationalMessage("");

            try {
                message = new MotivationalMessage(this.messages.chooseAGeneralQuote());
            } catch (Exception e) {
                e.printStackTrace(System.err);
            }
            
            JAlert alert = new JAlert(2, "", "<html>" + message.getQuote() + "<br><br><i>"  + message.getAuthor() + "</i></html>");

            alert.setPreferredSize(new Dimension(alertPane.getPreferredSize().width, alert.getPreferredSize().height+20));

            alertPane.removeAll();
            alertPane.add(alert);
            alertPane.setMaximumSize(new Dimension(Integer.MAX_VALUE, alert.getPreferredSize().height));
            alertPane.revalidate();
        }
    }
}

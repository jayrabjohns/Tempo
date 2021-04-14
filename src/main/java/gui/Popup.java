package gui;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.Dialog;
import java.awt.Window;

public class Popup extends JDialog {

    public Form form;

    public Popup(Window parent, Dialog.ModalityType type) {
        super(parent, type);
    }

    public static Popup fromForm(Form form, Window parent, boolean blocking) {
        Popup result = new Popup(parent, Dialog.ModalityType.APPLICATION_MODAL);
        
        result.setModal(blocking);
        
        result.setUndecorated(true);
        
        result.form = form;
        result.setContentPane(form.getContentPane());

        return result;
    } 
}

//Schwarzbeck, D., 2018. Is there a standard GUI toggle switch in Java?. [online] Stack Overflow.
// Available at: <https://stackoverflow.com/questions/9146683/is-there-a-standard-gui-toggle-switch-in-java>

package main.gui.timer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

@SuppressWarnings("serial")
public class ToggleSwitch extends AbstractButton {
    private boolean activated = false;
    private Color switchColor = new Color(150, 251, 86), buttonColor = new Color(255, 255, 255), borderColor = new Color(50, 50, 50);
    private Color activeSwitch = new Color(0, 141, 76);
    private BufferedImage puffer;
    private int borderRadius = 10;
    private Graphics2D g;
    public ToggleSwitch() {
        super();
        setVisible(true);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent arg0) {

                ActionEvent ae = new ActionEvent(arg0.getSource(), arg0.getID(), arg0.paramString());
                fireActionPerformed(ae);
                activated = !activated;
                repaint();
            }
        });
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setBounds(0, 0, 41, 21);
    }
    @Override
    public void paint(Graphics gr) {
        if(g == null || puffer.getWidth() != getWidth() || puffer.getHeight() != getHeight()) {
            puffer = (BufferedImage) createImage(getWidth(), getHeight());
            g = (Graphics2D)puffer.getGraphics();
            RenderingHints rh = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g.setRenderingHints(rh);
        }
        g.setColor(activated?activeSwitch:switchColor);
        g.fillRoundRect(0, 0, this.getWidth()-1,getHeight()-1, 5, borderRadius);
        g.setColor(borderColor);
        g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 5, borderRadius);
        g.setColor(buttonColor);
        if(activated) {
            g.fillRoundRect(getWidth()/2, 1,  (getWidth()-1)/2 -2, (getHeight()-1) - 2,  borderRadius, borderRadius);
            g.setColor(borderColor);
            g.drawRoundRect((getWidth()-1)/2, 0, (getWidth()-1)/2, (getHeight()-1), borderRadius, borderRadius);
        }
        else {
            g.fillRoundRect(1, 1, (getWidth()-1)/2 -2, (getHeight()-1) - 2,  borderRadius, borderRadius);
            g.setColor(borderColor);
            g.drawRoundRect(0, 0, (getWidth()-1)/2, (getHeight()-1), borderRadius, borderRadius);
        }

        gr.drawImage(puffer, 0, 0, null);
    }
    // true = EXERCISE, false = STUDY
    public boolean isActivated() {
        return activated;
    }
    public void setActivated(boolean activated) {
        this.activated = activated;
    }
    public Color getSwitchColor() {
        return switchColor;
    }
    /**
     * Unactivated Background Color of switch
     */
    public void setSwitchColor(Color switchColor) {
        this.switchColor = switchColor;
    }
    public Color getButtonColor() {
        return buttonColor;
    }
    /**
     * Switch-Button color
     */
    public void setButtonColor(Color buttonColor) {
        this.buttonColor = buttonColor;
    }
    public Color getBorderColor() {
        return borderColor;
    }
    /**
     * Border-color of whole switch and switch-button
     */
    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }
    public Color getActiveSwitch() {
        return activeSwitch;
    }
    public void setActiveSwitch(Color activeSwitch) {
        this.activeSwitch = activeSwitch;
    }
    /**
     * @return the borderRadius
     */
    public int getBorderRadius() {
        return borderRadius;
    }
    /**
     * @param borderRadius the borderRadius to set
     */
    public void setBorderRadius(int borderRadius) {
        this.borderRadius = borderRadius;
    }


}
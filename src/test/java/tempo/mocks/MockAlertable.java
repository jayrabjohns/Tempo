package tempo.mocks;

import main.gui.Alertable;
import main.gui.JAlert;

/**
 * A mock alertable object
 */
public class MockAlertable implements Alertable {

    public JAlert alert;

    public void showAlert(JAlert alert) {
        this.alert = alert;
    }
}

package test.icons;

import static org.junit.jupiter.api.Assertions.*;
import javax.swing.JFrame;
import java.awt.Dimension;
import org.junit.jupiter.api.Test;

import icons.IconFetcher;
import main.gui.*;

public class IconTest {
    public String icons[] = {
        "clock.png",
        "cog.png",
        "hourglass.png",
        "house.png",
        "project.png",
        "tempo_w.png",
        "tempo.png"
    };

    /**
     * Test all the icons needed exist
     */
    @Test
    public void testIcons() {
        for (String file: icons) {
            assertTrue(IconFetcher.getIcon(file) != null);
        }
    }
}

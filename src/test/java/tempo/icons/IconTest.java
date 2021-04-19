package tempo.icons;

import static org.junit.jupiter.api.Assertions.*;

import main.backend.LocalStorage.LocalStorage;
import org.junit.jupiter.api.Test;

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
            assertTrue(LocalStorage.getInstance().getIcon(file) != null);
        }
    }
}

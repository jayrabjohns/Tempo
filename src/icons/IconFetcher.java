package icons;

import java.net.URL;

import javax.swing.ImageIcon;

public class IconFetcher {
    public static ImageIcon getIcon(String name) {

        URL url = IconFetcher.class.getClassLoader().getResource("icons/" + name);
        System.err.println(IconFetcher.class.getClassLoader().getResource("").toString());

        if(url == null) {
            System.err.println("Failed to find icon: " + name);
            System.err.println(IconFetcher.class.getClassLoader().getResource("").toString());
            return null;
        }

        ImageIcon result = new ImageIcon(url);

        return result;
    }
}

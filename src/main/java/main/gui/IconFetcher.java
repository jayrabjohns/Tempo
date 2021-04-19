package main.gui;

import main.backend.LocalStorage.LocalStorage;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.ImageIcon;

public class IconFetcher {
    public static ImageIcon getIcon(String name) {

        Path iconPath = LocalStorage.resourcesPath.resolve(Paths.get("icons", name));
        
        URL url;
        try
        {
            url = iconPath.toUri().toURL();
        }
        catch (MalformedURLException e)
        {
            System.err.println("Failed to find icon: " + name);
            System.err.println(IconFetcher.class.getClassLoader().getResource("").toString());
            return null;
        }

        ImageIcon result = new ImageIcon(url);

        return result;
    }
}

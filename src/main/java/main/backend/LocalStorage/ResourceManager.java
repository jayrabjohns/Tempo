package main.backend.LocalStorage;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Singleton class for loading / saving items from the resources folder.
 */
public class ResourceManager
{
	public static final Path resourcesPath = Paths.get("src", "main", "resources");
	
	private static ResourceManager instance;
	
	private final ObjectWriter objectWriter;
	private final ObjectReader objectReader;
	private final AppSettings appSettings;
	
	/**
	 * Instantiates class, initialises app settings
	 */
	private ResourceManager()
	{
		AppSettings loadedSettings;
		ObjectMapper objectMapper = new ObjectMapper();
		objectWriter = objectMapper.writer(new DefaultPrettyPrinter());
		objectReader = objectMapper.reader();
		
		loadedSettings = tryLoadJsonResource("settings.json", AppSettings.class);
		if (loadedSettings == null)
		{
			loadedSettings = new AppSettings();
		}
		appSettings = loadedSettings;
	}
	
	/**
	 * Use this method when needing this class in a non-static context.
	 *
	 * @return The only instance of this class.
	 */
	public static ResourceManager getInstance()
	{
		if (instance == null)
		{
			instance = new ResourceManager();
		}
		
		return instance;
	}
	
	/**
	 * Saves the current app settings to device.
	 *
	 * @return Whether the settings where successfully saved.
	 */
	public boolean trySaveSettings()
	{
		return trySaveResourceAsJson("settings.json", appSettings);
	}
	
	public boolean trySaveResourceAsJson(Path path, Object resource)
	{
		return trySaveResourceAsJson(path.toString(), resource);
	}
	
	/**
	 * Serialises a given object as JSON and saves it to the resources folder.
	 *
	 * @param relativePath File path relative to the resources folder.
	 * @param resource The object to save.
	 *
	 * @return Whether the object was save successfully.
	 */
	public boolean trySaveResourceAsJson(String relativePath, Object resource)
	{
		boolean success = false;
		
		if (resource != null)
		{
			try
			{
				objectWriter.writeValue(resourcesPath.resolve(relativePath).toFile(), resource);
				success = true;
			}
			catch (IOException e)
			{
				// Nothing to do
			}
		}
		
		return success;
	}
	
	/**
	 * Loads a JSON file from the resources folder and parses it as an object of a specified type.
	 *
	 * @param relativePath File path relative to the resources folder.
	 * @param type What type the file should be parsed as.
	 *
	 * @return An object of type T representing the parsed resource. Returns null if the resource is unable to be read.
	 * @throws IllegalArgumentException if a parameter is null.
	 */
	public <T> T tryLoadJsonResource(String relativePath, Class<T> type) throws IllegalArgumentException
	{
		if (relativePath == null || type == null)
		{
			throw new IllegalArgumentException("parameters cannot be null");
		}
		
		File file = resourcesPath.resolve(relativePath).toFile();
		if (!file.isFile())
		{
			System.err.printf("Could not find file %s.%n", file.getPath());
		}
		
		T resource = null;
		try
		{
			resource = objectReader.readValue(file, type);
		}
		catch (IOException e)
		{
			// Nothing to do
		}
		
		return resource;
	}
	
	/**
	 * Retrieves an icon from the resources\icons folder.
	 *
	 * @param name Name of icon file.
	 * @return The icon with the given name. Returns null if the icon doesn't exist.
	 */
	public ImageIcon getIcon(String name)
	{
		Path iconPath = ResourceManager.resourcesPath.resolve(Paths.get("icons", name));
		
		ImageIcon result = null;
		try
		{
			URL url = iconPath.toUri().toURL();
			result = new ImageIcon(url);
		}
		catch (MalformedURLException e)
		{
			System.err.println("Failed to find icon: " + name);
		}
		
		return result;
	}
}

package main.backend.LocalStorage;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LocalStorage
{
	public static final Path resourcesPath = Paths.get("src", "main", "resources");
	
	private static LocalStorage instance;
	
	private final File settingsFile;
	private final ObjectWriter objectWriter;
	private final AppSettings appSettings;
	
	private LocalStorage()
	{
		ObjectMapper objectMapper = new ObjectMapper();
		objectWriter = objectMapper.writer(new DefaultPrettyPrinter());
		
		settingsFile = resourcesPath.resolve("settings.json").toFile();
		
		// Loading settings for first time
		AppSettings loadedSettings;
		try
		{
			loadedSettings = objectMapper.readValue(settingsFile, AppSettings.class);
		}
		catch (IOException e)
		{
			loadedSettings = new AppSettings();
		}
		appSettings = loadedSettings;
	}
	
	public static LocalStorage getInstance()
	{
		if (instance == null)
		{
			instance = new LocalStorage();
		}
		
		return instance;
	}
	
	public boolean trySaveSettings()
	{
		try
		{
			objectWriter.writeValue(resourcesPath.resolve("settings.json").toFile(), appSettings);
		}
		catch (IOException e)
		{
			return false;
		}
		
		return true;
	}
}

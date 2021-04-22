package main.backend.LocalStorage;

public class AppSettings
{
	private int defaultWorkMins;
	private int defaultRestMins;
	
	public AppSettings()
	{
		setToDefault();
	}
	
	/**
	 * Sets all app settings to default values
	 */
	public void setToDefault()
	{
		defaultWorkMins = 25;
		defaultRestMins = 5;
	}
	
	public int getDefaultWorkMins()
	{
		return defaultWorkMins;
	}
	
	public void setDefaultWorkMins(int val)
	{
		defaultWorkMins = val;
	}
	
	public int getDefaultRestMins()
	{
		return defaultRestMins;
	}
	
	public void setDefaultRestMins(int val)
	{
		defaultRestMins = val;
	}
}

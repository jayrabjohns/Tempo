package main.backend.LocalStorage;

public class AppSettings
{
	private int defaultWorkMins;
	private int defaultRestMins;

	private int defaultExerciseSeconds;
	private int defaultBreakSeconds;
	
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
		defaultExerciseSeconds = 40;
		defaultBreakSeconds = 15;
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

	public void setDefaultExerciseSeconds(int val){ defaultExerciseSeconds = val;}
	public int getDefaultExerciseSeconds(){return defaultExerciseSeconds;}

	public void setDefaultBreakSeconds(int val){ defaultBreakSeconds = val;}
	public int getDefaultBreakSeconds(){return defaultBreakSeconds;}
}

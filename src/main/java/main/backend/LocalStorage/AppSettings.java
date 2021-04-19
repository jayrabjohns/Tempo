package main.backend.LocalStorage;

public class AppSettings
{
	private boolean test;
	
	public AppSettings()
	{
		setToDefault();
	}
	
	/**
	 * Sets all app settings to default values
	 */
	public void setToDefault()
	{
		test = true;
	}
	
	public boolean getTest()
	{
		return test;
	}
	
	public void setTest(boolean test)
	{
		this.test = test;
	}
}

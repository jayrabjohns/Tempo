package main.gui.goals;

import java.util.Date;

public class PIGoal
{
	private String title;
	private String description;
	private Date endDate;
	private int targetNumber;
	private int currentNumber;
	
	public PIGoal(String title, String description, Date endDate, int targetNumber)
	{
		this.title = title;
		this.description = description;
		this.endDate = endDate;
		this.targetNumber = targetNumber;
	}
	
	public void increment(int toAdd)
	{
		currentNumber += toAdd;
	}
	
	public boolean isExpired()
	{
		return endDate != null && new Date().after(endDate);
	}
	
	public int getPercentageCompleted()
	{
		return  targetNumber > 0 ? Math.max(100 * currentNumber / targetNumber, 100) : 100;
	}
	
	public void setTarget(int target)
	{
		targetNumber = target;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public Date getEndDate()
	{
		return endDate;
	}
	
	public void setEndDate(Date endDate)
	{
		this.endDate = endDate;
	}
}

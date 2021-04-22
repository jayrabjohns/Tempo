package main.gui.goals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PIGoal
{
	private String title;
	private String description;
	private Calendar endDate;
	private int goalTarget;
	private int goalProgress;
	
	private final int maxTitleLength = 40;
	private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd:MM");
	
	public PIGoal(String title, String description, Calendar endDate, int goalTarget)
	{
		this.title = title;
		this.description = description;
		this.endDate = endDate;
		this.goalTarget = goalTarget;
	}
	
	public void increment(int toAdd)
	{
		goalProgress += toAdd;
	}
	
	public boolean isExpired()
	{
		return endDate != null && Calendar.getInstance().after(endDate);
	}
	
	public int getPercentageCompleted()
	{
		return  goalTarget > 0 ? Math.min(100 * goalProgress / goalTarget, 100) : 100;
	}
	
	public int getGoalTarget()
	{
		return goalTarget;
	}
	
	public void setGoalTarget(int target)
	{
		goalTarget = target;
	}
	
	public String getTitle()
	{
		return title != null ? title.length() < maxTitleLength ? title : title.substring(0, maxTitleLength) : "";
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public String getDescription()
	{
		return description != null ? description : "";
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public Calendar getEndDate()
	{
		return endDate;
	}
	
	public String getEndDateString()
	{
		return endDate != null ? dateFormat.format(endDate.getTime()) : "";
	}
	
	public void setEndDate(Calendar endDate)
	{
		this.endDate = endDate;
	}
	
	public void setEndDateString(String dateString)
	{
		if (dateString != null)
		{
			endDate = Calendar.getInstance();
			
			try
			{
				endDate.setTime(dateFormat.parse(dateString));
			}
			catch (ParseException e)
			{
				endDate = null;
			}
		}
	}
}

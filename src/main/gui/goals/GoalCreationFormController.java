package main.gui.goals;

public class GoalCreationFormController
{
	private PIGoal goal;
	
	public void bindGoal(PIGoal goal)
	{
		if (goal != null)
		{
			this.goal = goal;
		}
	}
}

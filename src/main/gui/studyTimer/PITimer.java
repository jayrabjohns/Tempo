package main.gui.studyTimer;

enum TimerState
{
    Initialised,
    Work,
    Rest,
    Paused,
}

/**
 * Holds work / rest times, frequency of big breaks.
 */
public class PITimer
{
    private int workSeconds;
    private int restSeconds;
    private int elapsedSeconds;
    private int targetSeconds;
    private TimerState currentState;
    
    public PITimer(int workSeconds, int restSeconds)
    {
        this.workSeconds = workSeconds;
        this.restSeconds = restSeconds;
        targetSeconds = this.workSeconds;
        currentState = TimerState.Initialised;
    }
    
    /**
     * Step the timer by one second.
     */
    public void stepTime()
    {
        if (++elapsedSeconds >= targetSeconds)
        {
            if (currentState == TimerState.Work)
            {
                targetSeconds = restSeconds;
                elapsedSeconds = 0;
                setCurrentState(TimerState.Rest);
            }
            else if (currentState == TimerState.Rest)
            {
                targetSeconds = workSeconds;
                elapsedSeconds = 0;
                setCurrentState(TimerState.Work);
            }
        }
    }
    
    /**
     * Gets the current time remaining as a formatted string.
     *
     * @return The time remaining.
     */
    public String getTimeString()
    {
        int minutes = getSecondsRemaining() / 60;
        int seconds = getSecondsRemaining() - minutes * 60;
        int hours = minutes / 60;
        minutes -= hours * 60;
        
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
    
    /**
     * Gets the time remaining before switching.
     *
     * @return The time remaining.
     */
    public int getSecondsRemaining()
    {
        return targetSeconds - elapsedSeconds;
    }
    
    /**
     * Extends the timer by a given duration.
     *
     * @param seconds The number of seconds to add.
     */
    public void extendWorkDuration(int seconds)
    {
        targetSeconds += seconds;
    }
    
    public int getWorkMins()
    {
        return workSeconds / 60;
    }
    
    public void setWorkSeconds(int workSeconds)
    {
        this.workSeconds = workSeconds;
        
        if (currentState == TimerState.Work && getSecondsRemaining() > workSeconds)
        {
            targetSeconds = workSeconds;
        }
    }
    
    public int getRestMins()
    {
        return restSeconds / 60;
    }
    
    public void setRestSeconds(int restSeconds)
    {
        this.restSeconds = restSeconds;
        
        if (currentState == TimerState.Rest && getSecondsRemaining() > restSeconds)
        {
            targetSeconds = restSeconds;
        }
    }
    
    public TimerState getCurrentState()
    {
        return currentState;
    }
    
    public void setCurrentState(TimerState newState)
    {
        this.currentState = newState;
    }
}

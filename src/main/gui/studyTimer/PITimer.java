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
    private int workDuration;
    private final int restDuration;
    private int totalSeconds;
    private TimerState currentState;
    
    public PITimer(int work, int rest)
    {
        this.workDuration = work;
        this.restDuration = rest;
        totalSeconds = workDuration * 60;
        currentState = TimerState.Initialised;
    }
    
    /**
     * Step the timer by one second.
     */
    public void stepTime()
    {
        totalSeconds--;
        if (totalSeconds <= 0 && currentState == TimerState.Work)
        {
            totalSeconds = restDuration * 60;
            setCurrentState(TimerState.Rest);
        }
        else if (totalSeconds <= 0 && currentState == TimerState.Rest)
        {
            totalSeconds = workDuration * 60;
            setCurrentState(TimerState.Work);
        }
    }
    
    /**
     * Gets the current time remaining as a formatted string.
     *
     * @return The time remaining.
     */
    public String getTimeString()
    {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds - minutes * 60;
        int hours = minutes / 60;
        minutes -= hours * 60;
        
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
    
    /**
     * Extends the timer by a given duration.
     *
     * @param seconds The number of seconds to add.
     */
    public void extendWorkDuration(int seconds)
    {
        totalSeconds += seconds;
        workDuration += seconds;
    }
    
    public int getWorkDuration()
    {
        return workDuration;
    }
    
    public int getRestDuration()
    {
        return restDuration;
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

public class FinishedState extends State
{
	protected int minutesRequiredForState;
	protected int minutesElapsed;
	
	public FinishedState()
	{
		super();
	}
	
	public State timeElapsed(int minutes)
	{
		return null;
	}
	
	public boolean isFinished()
	{
		return true;
	}
}

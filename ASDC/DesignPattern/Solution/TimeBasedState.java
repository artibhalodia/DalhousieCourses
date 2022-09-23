public abstract class TimeBasedState extends State
{
	public TimeBasedState()
	{
		super();
	}
	
	// This is the hook for the template method timeElapsed()
	protected abstract State chooseTransitionState();

	// I've created this class so that I can use the Template Method pattern
	// because all State classes that drain time will duplicate this generic
	// algorithm below. They now simply have to override the chooseTransitionState()
	// hook. timeElapsed() is now a Template Method.
	public State timeElapsed(int minutes)
	{
		minutesElapsed += minutes;
		if (minutesElapsed >= minutesRequiredForState)
		{
			return chooseTransitionState();
		}
		return null;
	}
}

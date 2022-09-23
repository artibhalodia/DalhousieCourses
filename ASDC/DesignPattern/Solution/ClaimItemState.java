public class ClaimItemState extends TimeBasedState
{
	public ClaimItemState()
	{
		super();
		minutesRequiredForState = 1;
	}

	// This is the hook for the template method timeElapsed()
	protected State chooseTransitionState()
	{
		return Simulation.instance().getFactory().createMoveToShelfState();
	}
}
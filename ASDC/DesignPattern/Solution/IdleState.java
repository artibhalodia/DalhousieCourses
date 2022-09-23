public class IdleState extends TimeBasedState
{
	public IdleState()
	{
		super();
		minutesRequiredForState = 0;
	}

	// This is the hook for the template method timeElapsed()
	protected State chooseTransitionState()
	{
		Shelf s = Simulation.instance().getShelf();
		IWarehouseFactory f = Simulation.instance().getFactory();
		if (s.getItemCount() > 0)
		{
			return f.createClaimItemState();
		}
		else
		{
			return f.createFinishedState();
		}
	}
}

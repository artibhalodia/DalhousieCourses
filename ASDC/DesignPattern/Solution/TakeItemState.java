public class TakeItemState extends TimeBasedState
{
	public TakeItemState()
	{
		super();
		minutesRequiredForState = 2;
	}

	// This is the hook for the template method timeElapsed()
	protected State chooseTransitionState()
	{
		Shelf s = Simulation.instance().getShelf();
		s.claimItem();
		IWarehouseFactory f = Simulation.instance().getFactory();
		return f.createMoveToTruckState();
	}
}


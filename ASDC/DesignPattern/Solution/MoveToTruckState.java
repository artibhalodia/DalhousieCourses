public class MoveToTruckState extends TimeBasedState
{
	public MoveToTruckState()
	{
		super();
		minutesRequiredForState = 4;
	}

	// This is the hook for the template method timeElapsed()
	protected State chooseTransitionState()
	{
		IWarehouseFactory f = Simulation.instance().getFactory();
		return f.createLoadTruckState();
	}
}


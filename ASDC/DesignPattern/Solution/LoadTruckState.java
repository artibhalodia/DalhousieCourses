public class LoadTruckState extends TimeBasedState
{
	public LoadTruckState()
	{
		super();
		minutesRequiredForState = 5;
	}

	// This is the hook for the template method timeElapsed()
	protected State chooseTransitionState()
	{
		IWarehouseFactory f = Simulation.instance().getFactory();
		return f.createIdleState();
	}
}

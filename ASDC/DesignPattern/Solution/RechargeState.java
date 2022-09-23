public class RechargeState extends State
{
	private State stateToReturnTo;
	private IBattery batteryToRecharge;
	public RechargeState(State fromState, IBattery batteryToRecharge)
	{
		super();
		minutesRequiredForState = 0;
		this.batteryToRecharge = batteryToRecharge;
		stateToReturnTo = fromState;
	}
	
	public State timeElapsed(int minutes)
	{
		batteryToRecharge.recharge(minutes);
		if (batteryToRecharge.isFullyCharged())
		{
			return stateToReturnTo;
		}
		return null;
	}
}

public class BatteryPack implements IBattery
{
	private IBattery myBattery;
	private IBattery decoratedBattery;
	
	public BatteryPack(int capacityMinutes, IBattery decoratedBattery)
	{
		this.decoratedBattery = decoratedBattery;
		myBattery = Simulation.instance().getFactory().createBattery(capacityMinutes);
	}
	
	public boolean hasEnoughPowerForMinutes(int minutes)
	{
		return (myBattery.hasEnoughPowerForMinutes(minutes) || decoratedBattery.hasEnoughPowerForMinutes(minutes));
	}
	
	public boolean isFullyCharged()
	{
		return myBattery.isFullyCharged() && decoratedBattery.isFullyCharged();
	}
	
	public void drain(int minutes)
	{
		if (myBattery.hasEnoughPowerForMinutes(minutes))
		{
			myBattery.drain(minutes);
		}
		else
		{
			decoratedBattery.drain(minutes);
		}
	}
	
	public void recharge(int minutes)
	{
		if (myBattery.isFullyCharged())
		{
			decoratedBattery.recharge(minutes);
		}
		else
		{
			myBattery.recharge(minutes);
		}
	}
}
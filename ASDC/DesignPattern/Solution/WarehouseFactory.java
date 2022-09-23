
public class WarehouseFactory implements IWarehouseFactory
{
	@Override
	public IBattery createBattery(int capacity)
	{
		return new Battery(capacity);
	}

	@Override
	public IRobot createRobot(int batteryCapacity)
	{
		IBattery battery = createBattery(batteryCapacity);
		State startState = createIdleState();
		return new Robot(battery, startState);
	}
	
	public IRobot createRobotWithBatteryPack(int batteryCapacity, int packCapacity)
	{
		IBattery battery = createBattery(batteryCapacity);
		IBattery batteryPack = new BatteryPack(packCapacity, battery);
		State startState = createIdleState();
		return new Robot(batteryPack, startState);
	}

	public State createClaimItemState()
	{
		return new ClaimItemState();
	}

	public State createFinishedState()
	{
		return new FinishedState();
	}

	public State createIdleState()
	{
		return new IdleState();
	}

	public State createLoadTruckState()
	{
		return new LoadTruckState();
	}

	public State createMoveToShelfState()
	{
		return new MoveToShelfState();
	}

	public State createMoveToTruckState()
	{
		return new MoveToTruckState();
	}

	public State createRechargeState(State fromState, IBattery batteryToRecharge)
	{
		return new RechargeState(fromState, batteryToRecharge);
	}

	public State createTakeItemState()
	{
		return new TakeItemState();
	}
}

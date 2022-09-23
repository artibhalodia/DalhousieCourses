public interface IWarehouseFactory
{
	// Robots and batteries
	public IBattery createBattery(int capacity);
	public IRobot createRobot(int batteryCapacity);
	public IRobot createRobotWithBatteryPack(int batteryCapacity, int packCapacity);
	// States
	public State createClaimItemState();
	public State createFinishedState();
	public State createIdleState();
	public State createLoadTruckState();
	public State createMoveToShelfState();
	public State createMoveToTruckState();
	public State createRechargeState(State fromState, IBattery batteryToRecharge);
	public State createTakeItemState();
}

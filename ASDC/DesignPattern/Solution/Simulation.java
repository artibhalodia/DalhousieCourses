import java.util.*;

public class Simulation
{
	private static Simulation theOneInstance = null;
	private IWarehouseFactory factory;
	private List<Object> robots;
	private int minutesToCompleteSimulation;
	private Shelf shelf;
	
	public Simulation()
	{
		robots = new ArrayList<Object>();
		minutesToCompleteSimulation = 0;
		shelf = new Shelf();
	}
	
	public static Simulation instance()
	{
		if (null == theOneInstance)
		{
			theOneInstance = new Simulation();
		}
		return theOneInstance;
	}
	
	public IWarehouseFactory getFactory()
	{
		return factory;
	}
	
	public Shelf getShelf()
	{
		return shelf;
	}
	
	public void build(Arguments args, IWarehouseFactory factory)
	{
		this.factory = factory;
		shelf.setItemCount(args.getShelfCount());
		
		TimerSubject s = TimerSubject.instance();
		int numRobotsLeftToBuild = args.getNumRobots() - args.getNumBatteryPacks();

		// First build battery pack carrying robots.
		for (int i = 0; i < args.getNumBatteryPacks(); i++)
		{
			Robot r = (Robot)factory.createRobotWithBatteryPack(args.getDefaultBatteryCapacity(), args.getBatteryPackCapacity());
			s.attach(r);
			robots.add(r);
		}

		// Build the rest of the robots.
		for (int i = 0; i < numRobotsLeftToBuild; i++)
		{
			Robot r = (Robot)factory.createRobot(args.getDefaultBatteryCapacity());
			s.attach(r);
			robots.add(r);
		}
	}
	
	public int run()
	{
		System.out.println("Simulation begun!");
		boolean robotsStillWorking = true;
		while (robotsStillWorking)
		{
			TimerSubject.instance().notifyObservers(1);
			minutesToCompleteSimulation += 1;
			// Check all robots to see whether they are finished.
			robotsStillWorking = false;
			ListIterator<Object> iter = robots.listIterator();
			while (iter.hasNext())
			{
				IRobot robot = (IRobot)iter.next();
				if (robot.isWorking())
				{
					robotsStillWorking = true;
					break;
				}
			}
		}
		System.out.println("Simulation complete!");
		return minutesToCompleteSimulation;
	}
}


















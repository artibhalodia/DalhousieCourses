import java.util.ArrayList;
import java.util.Iterator;

public abstract class Subject
{
	private ArrayList<ITimerObserver> observers;

	public Subject()
	{
		observers = new ArrayList<ITimerObserver>();
	}

	public void notifyObservers(int timeElapsed)
	{
		Iterator<ITimerObserver> iter = observers.iterator();
		while (iter.hasNext())
		{
			ITimerObserver o = iter.next();
			o.timeElapsed(timeElapsed);
		}
	}

	public void attach(ITimerObserver o)
	{
		observers.add(o);
	}

	public void detach(ITimerObserver o)
	{
		observers.remove(o);
	}
}
public class TimerSubject extends Subject
{
	private static TimerSubject uniqueInstance = null;

	private TimerSubject()
	{
		super();
	}

	public static TimerSubject instance()
	{
		if (null == uniqueInstance)
		{
			uniqueInstance = new TimerSubject();
		}
		return uniqueInstance;
	}
}
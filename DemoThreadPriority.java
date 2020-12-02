/*Thread scheduling in Java*/

class TestThreadPriority extends Thread
{
	public void run()
	{
		int index;
		for(index=1;index<=10;index++)
		{
			System.out.println(index+" Value of "+Thread.currentThread().getId());
			try
			{
				Thread.sleep(400);
			}
			catch(Exception ob)
			{
				System.out.println(ob);
			}
		}
	}
}
class DemoThreadPriority
{
	public static void main(String args[])
	{
		TestThreadPriority ob1 = new TestThreadPriority();
		TestThreadPriority ob2 = new TestThreadPriority();
		TestThreadPriority ob3 = new TestThreadPriority();
		ob1.start();
		ob2.start();
		ob3.start();
		System.out.println("Priority of ob1 before modification "+ob1.getPriority());
		System.out.println("Priority of ob2 before modification "+ob2.getPriority());
		System.out.println("Priority of ob3 before modification "+ob3.getPriority());
		ob1.setPriority(2);
		ob2.setPriority(8);
		ob3.setPriority(6);
		System.out.println("Priority of ob1 after modification "+ob1.getPriority());
		System.out.println("Priority of ob2 after modification "+ob2.getPriority());
		System.out.println("Priority of ob3 after modification "+ob3.getPriority());
		ob1.setPriority(Thread.MIN_PRIORITY);
		ob2.setPriority(Thread.NORM_PRIORITY);
		ob3.setPriority(Thread.MAX_PRIORITY);
		System.out.println("Priority of ob1 after modification again "+ob1.getPriority());
		System.out.println("Priority of ob2 after modification again "+ob2.getPriority());
		System.out.println("Priority of ob3 after modification again "+ob3.getPriority());
	}
}
/*use of synchronized method in java*/

class TestSynch1
{
	synchronized static void printResult()//static Synchronized method
	{
		int index;
		for(index=1;index<=10;index++)
		{
			System.out.println("Thread number - "+Thread.currentThread().getId()+" value = "+index);
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
class Thread1 extends Thread
{
	public void run()
	{
		TestSynch1.printResult();
	}
}
class Thread2 extends Thread
{
	public void run()
	{
		TestSynch1.printResult();
	}
}
class Thread3 extends Thread
{
	public void run()
	{
		TestSynch1.printResult();
	}
}
class Thread4 extends Thread
{
	public void run()
	{
		TestSynch1.printResult();
	}
}
class DemoSynchstaticMethod
{
	public static void main(String args[])
	{
		Thread1 ob1 = new Thread1();
		Thread2 ob2 = new Thread2();
		Thread3 ob3 = new Thread3();
		Thread4 ob4 = new Thread4();
		ob1.start();
		ob2.start();
		ob3.start();
		ob4.start();
	}
}
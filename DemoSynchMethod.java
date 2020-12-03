/*use of synchronized method in java*/

class TestSynch
{
	synchronized void printResult()//Synchronized method
	{
		int index;
		for(index=1;index<=10;index++)
		{
			System.out.println(index);
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
	TestSynch ob3;
	Thread1(TestSynch ob)
	{
		ob3 = ob;
	}
	public void run()
	{
		ob3.printResult();
	}
}
class Thread2 extends Thread
{
	TestSynch ob4;
	Thread2(TestSynch ob)
	{
		ob4 = ob;
	}
	public void run()
	{
		ob4.printResult();
	}
}
class DemoSynchMethod
{
	public static void main(String args[])
	{
		TestSynch ob = new TestSynch();//Resource ob
		Thread1 ob1 = new Thread1(ob);
		Thread2 ob2 = new Thread2(ob);
		ob1.start();
		ob2.start();
	}
}
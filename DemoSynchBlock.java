/*use of synchronized method in java*/

class TestSynchBlock
{
	void printResult()
	{
		int index;
		System.out.println("Welcome");
		System.out.println("Good");
		synchronized(this)//synchronized block
		{
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
		System.out.println("Over execution");
	}
}
class Thread1 extends Thread
{
	TestSynchBlock ob3;
	Thread1(TestSynchBlock ob)
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
	TestSynchBlock ob4;
	Thread2(TestSynchBlock ob)
	{
		ob4 = ob;
	}
	public void run()
	{
		ob4.printResult();
	}
}
class DemoSynchBlock
{
	public static void main(String args[])
	{
		TestSynchBlock ob = new TestSynchBlock();//Resource ob
		Thread1 ob1 = new Thread1(ob);
		Thread2 ob2 = new Thread2(ob);
		ob1.start();
		ob2.start();
	}
}
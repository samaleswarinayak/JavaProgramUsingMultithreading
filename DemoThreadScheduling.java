/*Thread scheduling in Java*/

class TestThreadScheduling extends Thread
{
	public void run()
	{
		int index;
		for(index=1;index<=100;index++)
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
class DemoThreadScheduling
{
	public static void main(String args[])
	{
		TestThreadScheduling ob1 = new TestThreadScheduling();//Id-13
		TestThreadScheduling ob2 = new TestThreadScheduling();//Id-14
		TestThreadScheduling ob3 = new TestThreadScheduling();
		System.out.println("Id of ob1 "+ob1.getId());
		System.out.println("Id of ob2 "+ob2.getId());
		System.out.println("Name of ob1 "+ob1.getName());
		System.out.println("Name of ob2 "+ob2.getName());
		ob1.setName("Java");
		ob2.setName("Language");
		ob1.start();
		try
		{
			ob1.join();
		}
		catch(Exception ob4)
		{
			System.out.println(ob4);
		}
		ob2.start();
		ob3.start();
		System.out.println("Name of ob1 after modification "+ob1.getName());
		System.out.println("Name of ob2 after modification "+ob2.getName());
	}
}
/* Inter thread communication in Java */

class BankAccount
{
	int balance = 5000;
	synchronized void withdraw(int amount)
	{
		System.out.println("Before withdraw balance is "+balance);
		System.out.println("I want to withdraw");
		if(balance < amount)
		{
			System.out.println("Required amount is more than balance. You have to wait till deposit");
			try
			{
				wait();
			}
			catch(Exception ob)
			{
				System.out.println(ob);
			}
		}
		System.out.println("Ready to withdraw");
		balance = balance - amount;
		System.out.println("Balance after withdraw is "+balance);
	}
	synchronized void deposit(int amount)
	{
		System.out.println("Before deposit the balance is "+balance);
		System.out.println("I am ready to deposit");
		balance = balance + amount;
		System.out.println("Deposit over and now yo can withdraw");
		notify();
	}
}
class Student extends Thread
{
	BankAccount ob3;
	Student(BankAccount ob)
	{
		ob3 = ob;
	}
	public void run()
	{
		ob3.withdraw(25000);
	}
}
class Parents extends Thread
{
	BankAccount ob4;
	Parents(BankAccount ob)
	{
		ob4 = ob;
	}
	public void run()
	{
		ob4.deposit(30000);
	}
}
class TestInterThread
{
	public static void main(String args[])
	{
		BankAccount ob = new BankAccount();
		Student ob1 = new Student(ob);
		Parents ob2 = new Parents(ob);
		ob1.start();
		ob2.start();
	}
}
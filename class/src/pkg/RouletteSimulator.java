package pkg;

import java.util.ArrayList;

public class RouletteSimulator
{
	public static class Wheel
	{
		public Wheel()
		{
			pastRolls = new ArrayList<Integer>();
		}
		
		private ArrayList<Integer> pastRolls;
		
		public int spin()
		{
			int result = (int) Math.floor( (Math.random() * 36) );
			result += 1;
			pastRolls.add(result);
			return result;
		}
	}
	
	public static class Player
	{
		int startCash;
		int cash;
		int bet;
		boolean win;
		
		public Player(int startCash)
		{
			this.startCash = startCash;
			cash = startCash;
			win = true;
		}
		
		public void placeBet()
		{
			if(win)
			{
				win = false;
				bet = 1;
			}
			else 
//				if(bet == 2)
//				bet = 3;
//			else
				bet *= 2;
			
			bet = withdraw(bet);
		}
		
		public int withdraw(int amount)
		{
			if(amount > cash)
				amount = cash;
			cash -= amount;
			return amount;
		}
	}

	public static void main(String[] args) throws InterruptedException
	{
		ArrayList<Integer> tests = new ArrayList<Integer>();
		for(int i = 0; i < 100000; i++)
		{
			Wheel wheel = new Wheel();
			Player nev = new Player(100);
			while(true)
			{
				nev.placeBet();
				int result = wheel.spin();
				
				if(result >= 1 && result <= 18)
				{
					nev.cash += nev.bet*2;
					nev.win = true;
				}
				
				//System.out.println("Result: " + result + ", Bet: " + nev.bet + ", Cash: " + nev.cash);
				//Thread.sleep(500);
				if(nev.cash > 1000 || nev.cash == 0)
					break;
			}
			tests.add(nev.cash);
			//System.out.println(i + " , Cash: " + nev.cash);
		}
		
		System.out.println("Outcome: ");
		
		int sum = 0;
		int wins = 0;
		for(int i : tests)
		{
			if(i != 0)
			{
				sum += i;
				wins++;
			}
		}
		System.out.println("   Profit: " + (sum - 10000000));
		System.out.println("   Win%: " + (((double)wins)/100000.0)*100.0);
		
	}

}

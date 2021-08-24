package pkg;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * @Author Nevin Foster
 * 
 * @Class CSC110: 11384
 * @Title Chapter 7 Practice Problem 7, Tic Tac Toe
 * @Description made to test skills as a programmer
 */
public class TicTacToe_NevinFoster
{
	private static Scanner scanner;
	
	public static void main(String[] args)
	{
		scanner = new Scanner(System.in);
		TicTacToe game = new TicTacToe();
		
		System.out.println(game.RULES);
		
		while(true)
		{
			System.out.println("Would you like to play? ('y' or 'n')");
			String answer = scanner.next();
			if(!answer.toLowerCase().matches("y"))
				break;
			game.start();
		}
		
		scanner.close();
		System.out.println("Thanks for playing.");
	}
	
	static class TicTacToe
	{
		public static final String RULES = 
				  "Tic Tac Toe: \n"
				+ "    Player 1 is always X. \n"
				+ "    Enter number 1-9 to select a square. \n"
				+ "    The squares are as follows: \n"
				+ "        1 | 2 | 3 \n"
				+ "        4 | 5 | 6 \n"
				+ "        7 | 8 | 9 \n"
				+ "    Three in a row and you win! \n";
		/*
		 * for "tiles", values mean:
		 * 		0: empty square.
		 * 		1: player one, X.
		 * 		2: player two, O.
		 */
		private int[] tiles;
		private int[] wins;
		
		private int player;
		
		public TicTacToe()
		{
			player = 1;
			wins = new int[] { 0, 0 };
			tiles = new int[9];
		}
		
		private void start()
		{
			//clear tiles
			for (int i = 0; i < tiles.length; i++)
				tiles[i] = 0;
			
			/*
			 * RUN!
			 */
			printBoard();
			
			while(true)
			{
				System.out.println("It is player " + player + "'s turn.");
				
				int tile;
				try
				{
					tile = scanner.nextInt() - 1;
					if(tile > 8 || tile < 0) throw new InputMismatchException();
					else if(tiles[tile] != 0) throw new InputMismatchException();
				} 
				catch(InputMismatchException e)
				{
					System.out.println("That is an invalid input.");
					continue;
				}
				
				tiles[tile] = player;
				
				printBoard();
				
				if(checkWin())
				{
					System.out.println("Player " + player + " has Won!!");
					if(player == 1)
						wins[0]++;
					else
						wins[1]++;
					System.out.println("Here's the score: ");
					System.out.println("    Player One: " + wins[0] + "\n    Player Two: " + wins[1]);
					
					break;
				}
				
				if(checkTie())
				{
					System.out.println("No one has Won!!");
					
					System.out.println("Here's the score: ");
					System.out.println("    Player One: " + wins[0] + "\n    Player Two: " + wins[1]);
					
					break;
				}
				
				player = (player == 1) ? 2 : 1;
	
			}
		}
		
		private boolean checkTie()
		{
			int spots = 0;
			for(int i : tiles)
				if(i == player)
					spots++;
			if(spots == 5)
				return true;
			return false;
		}

		private boolean checkWin()
		{
			int[] row = new int[] { 0, 0, 0 };
			int[] clm = new int[] { 0, 0, 0 };
			int[] dag = new int[] { 0, 0 };
			
			for (int i = 0; i < tiles.length; i++)
			{
				if(tiles[i] == player)
				{
					row[ i % 3 ]++;
					clm[ Math.floorDiv(i, 3) ]++;
					if(i % 2 == 0)
					{
						if(i % 4 == 0)
							dag[0]++;
						if(i > 0 && i < 8)
							dag[1]++;
					}
				}
			}
			
			for(int[] i : new int[][] { row, clm, dag })
				for(int j : i)
					if(j == 3)
						return true;
			return false;
		}

		private void printBoard()
		{
			System.out.println(
					  "   " + getType(tiles[0]) + " | " + getType(tiles[1]) + " | " + getType(tiles[2]) +
					"\n   " + getType(tiles[3]) + " | " + getType(tiles[4]) + " | " + getType(tiles[5]) +
					"\n   " + getType(tiles[6]) + " | " + getType(tiles[7]) + " | " + getType(tiles[8]) );
		}

		private String getType(int i)
		{
			return ( i == 0 ) ? "_" : (i == 1) ? "X" : "O";
		}
	}
	/*
	Tic Tac Toe: 
	    Player 1 is always X. 
	    Enter number 1-9 to select a square. 
	    The squares are as follows: 
	        1 | 2 | 3 
	        4 | 5 | 6 
	        7 | 8 | 9 
	    Three in a row and you win! 

	Would you like to play? ('y' or 'n')
	y
	   _ | _ | _
	   _ | _ | _
	   _ | _ | _
	It is player 1's turn.
	1
	   X | _ | _
	   _ | _ | _
	   _ | _ | _
	It is player 2's turn.
	2
	   X | O | _
	   _ | _ | _
	   _ | _ | _
	It is player 1's turn.
	3
	   X | O | X
	   _ | _ | _
	   _ | _ | _
	It is player 2's turn.
	5
	   X | O | X
	   _ | O | _
	   _ | _ | _
	It is player 1's turn.
	8
	   X | O | X
	   _ | O | _
	   _ | X | _
	It is player 2's turn.
	6
	   X | O | X
	   _ | O | O
	   _ | X | _
	It is player 1's turn.
	4
	   X | O | X
	   X | O | O
	   _ | X | _
	It is player 2's turn.
	7
	   X | O | X
	   X | O | O
	   O | X | _
	It is player 1's turn.
	9
	   X | O | X
	   X | O | O
	   O | X | X
	No one has Won!!
	Here's the score: 
	    Player One: 0
	    Player Two: 0
	Would you like to play? ('y' or 'n')
	y
	   _ | _ | _
	   _ | _ | _
	   _ | _ | _
	It is player 1's turn.
	1
	   X | _ | _
	   _ | _ | _
	   _ | _ | _
	It is player 2's turn.
	2
	   X | O | _
	   _ | _ | _
	   _ | _ | _
	It is player 1's turn.
	4
	   X | O | _
	   X | _ | _
	   _ | _ | _
	It is player 2's turn.
	5
	   X | O | _
	   X | O | _
	   _ | _ | _
	It is player 1's turn.
	7
	   X | O | _
	   X | O | _
	   X | _ | _
	Player 1 has Won!!
	Here's the score: 
	    Player One: 1
	    Player Two: 0
	Would you like to play? ('y' or 'n')
	n
	Thanks for playing.
	*/
}

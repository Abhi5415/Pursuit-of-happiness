import java.util.*;

public class game {
	
	static int currentPlayerScore = 0;
	
	static int[] scoresArray = new int[3];

	static int[] lastPlayerArray = new int[]{1,0,1,0,1,0,1,0,1,0};
	
	//matrix
	static int CC = 2;
	static int DD = 0;
	static int CD = -1;
	static int DC = 3;

	private static Scanner input;
			
	public static int Reward (int player, int memory) {
		if (player==1 && memory==1) {
			return CC;
		} else if (player == 0 && memory == 0){
			return DD;
		} else if ( player == 0 && memory == 1) {
			return DC;
		} else if ( memory == 0 && player == 1) {
			return CD; 
		} else {
			return 0;
		}
	}
	
	public static void Check (int a) {
		if (a == 0) {
			System.out.println("The opponent decieved you");	
		} else if (a == 1){
			System.out.println("The opponent cooperated with you");
		}
	}

	public static int checkinput() {

		int result = -1;
		
		do {
			try {
				String inputString = input.nextLine();
				result = Integer.parseInt(inputString);
				if (result != 0 || result != 1) {
					throw new Exception ();
				}
			} catch (Exception e) {
				System.out.println("Enter a valid number - 0 or 1");
			}
		} while (result < 0 || result > 1) ;

		//System.out.println("returning " + result);
		return result;
	};

	public static void main(String[] args) {
	
		System.out.println("Welcome to the Pursuit of Happiness.");	
		System.out.println("Your goal is to score as many happiness points as possible.");
		System.out.println("Press 1 to cooperate, press 0 to decieve");
		System.out.println("It is Player 1's turn. Ready? Go!");
	
		input = new Scanner(System.in);
		
		for (int x = 0; x < scoresArray.length; x++) {
			for (int i = 0; i < 10;) {
				System.out.println("What would you like to do? (Round: " + (i+1) + ")");	

				int decision = checkinput();
				
				//if(input.hasNextInt() == true) {
					if (decision == 1) {
						System.out.println("You cooperated");
						currentPlayerScore += Reward(decision, lastPlayerArray[i]);
						Check(lastPlayerArray[i]);
						System.out.println("You recieved: " + Reward(decision, lastPlayerArray[i]) + " points");
		
						lastPlayerArray[i]= 1;
						i++;
					} else if (decision == 0){
						System.out.println("You decieved");
						currentPlayerScore += Reward(decision, lastPlayerArray[i]);
						Check(lastPlayerArray[i]);
						System.out.println("You recieved: " + Reward(decision, lastPlayerArray[i]) + " points");
		
						
						lastPlayerArray[i]= 0;
						i++;
					} else {
						System.out.println("choose a valid number");
						
					}
				//} else {
				//	System.out.println("choose a valid input");
				//}	
			}
			System.out.println("Player " + (x+1)+ " scored: " + currentPlayerScore + " points.");	
			scoresArray[x] = currentPlayerScore;
			System.out.println("Score recorded");	
			if (x+1 == scoresArray.length) {
				System.out.println("Good Game");

			} else {
				System.out.println("Player " + (x+2) + " ready?");

			}


		} 
		
		int sumArray = 0;
		for (int i = 0; i < scoresArray.length; i++) {
			sumArray += scoresArray[i];
		}
		
		System.out.println("Your Civilization Recieved: " + sumArray + " points.");	
		input.close();
		
	}
	
}

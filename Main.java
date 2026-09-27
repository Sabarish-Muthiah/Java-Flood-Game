package code;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int userChoice;
		int dimension = 20;
		FloodLinkedGrid LG = new FloodLinkedGrid(dimension);
		LG.display();
		boolean win;
		Scanner input = new Scanner(System.in);
		int triesLeft = 25;
		
		do {
			System.out.print("Enter your choice: ");
			userChoice = input.nextInt();
			LG.passInput(userChoice);
			triesLeft--;
			LG.display();
			win = LG.checkWin(dimension);
			System.out.println("Tries Left: " + triesLeft);
		} while(win != true && triesLeft > 0);
		
		if(win == true) {
			System.out.println("Congrats!!! You have won.");
		}
		else if(triesLeft == 0) {
			System.out.println("Oh No! You have lost all your attempts.");
		}
		
		input.close();
	}

}

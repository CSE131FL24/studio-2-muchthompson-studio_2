package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in1 = new Scanner(System.in);
		System.out.print("Enter the start amount: ");
		double startAmount = (in1.nextDouble());
		
		Scanner in2 = new Scanner(System.in);
		System.out.print("Enter the probability of winning: ");
		double winChance = (in2.nextDouble());
		
		Scanner in3 = new Scanner(System.in);
		System.out.print("Enter the win limit: ");
		double winLimit = (in3.nextDouble());
		
		Scanner in4 = new Scanner(System.in);
		System.out.print("Enter the number of simulations: ");
		int totalSimulations = (in4.nextInt());
		
		for(int i=0; i<totalSimulations; i++) {
			double curr = startAmount;
			int countWin = 0;
			int countLose = 0;
			
			while (curr > winLimit || curr == 0) {
				double num = Math.random();
				if (num <= winChance) {
					curr++;
					countWin++;
				}
				if (num > winChance) {
					curr--;
					countLose++;
			
				}
			}
			String eod;
			if (curr == 0) {
				eod = "Lose";
			
			}else {
				eod = "Win";
			}
			System.out.println("Stimulation: "+ (i+1)+ eod);
		}
	double a = (1-winChance) / winChance;
	double expectedRuin;
	if (winChance == 0.5) {
		expectedRuin = 1 - (startAmount / winLimit);
	}else {
		expectedRuin = ((Math.pow(a, startAmount) - (Math.pow(a, winLimit)) / (1-(Math.pow(a, winLimit)))));
	}
	System.out.println("Expected Ruin: "+expectedRuin);
	}
	
}

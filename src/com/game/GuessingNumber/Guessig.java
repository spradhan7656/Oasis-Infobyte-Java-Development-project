

import java.util.Random;
import java.util.Scanner;
public class Guessig
{
    private static final int min_range = 1;
	private static final int max_range = 100;
	private static final int total_Attempts = 15;
	private static final int total_round = 5;
    
    public static void main(String []args)
    {
        Random random = new Random();
	        Scanner scanner = new Scanner(System.in);
	        int totalScore = 0;

	        System.out.println("NUMBER GUESSING GAME");
	        System.out.println("Total Number Of Rounds : 5");
	        System.out.println("Attempts To Guess Number In Each Round : 15\n");
	        for (int i = 1; i <= total_round; i++) {
	            int number = random.nextInt(max_range) + min_range;
	            int attempts = 0;

	            System.out.printf("Round %d: Guess the number between %d and %d in %d attempts.\n", i, min_range, max_range,
	                    total_Attempts);
	            while (attempts < total_Attempts) {
	                System.out.println("Enter your guess : ");
	                int guess_number = scanner.nextInt();
	                attempts = attempts + 1;

	                if (guess_number == number) {
	                    int score = total_Attempts - attempts;
	                    totalScore = totalScore + score;
	                    System.out.printf("Hurray! Number Guessed Successfully. Attempts = %d. Round Score = %d\n",
	                            attempts, score);
	                    break;
	                }

	                else if (guess_number < number) {
	                    System.out.printf("The number is greater than %d. Attempts Left = %d.\n", guess_number,
	                            total_Attempts - attempts);
	                }

	                else if (guess_number > number) {
	                    System.out.printf("The number is less than %d. Attempts Left = %d.\n", guess_number,
	                            total_Attempts - attempts);
	                }

	            }

	            if (attempts == total_Attempts) {
	                System.out.printf("\nRound = %d\n", i);
	                System.out.println("Attempts = 0");
	                System.out.printf("The Random Number Is : %d\n\n", number);
	            }
	        }
	        System.out.printf("Game Over. Total Score = %d\n", totalScore);
    }
}

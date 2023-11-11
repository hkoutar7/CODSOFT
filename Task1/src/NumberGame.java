import java.util.Scanner;

public class NumberGame {

    final static byte MAX_NUMBER = 101;
    static int score = 0;
    static  int rounds = 0;
    public static int generateRandomNumber(){
        int randomNumber = (int)(Math.random() * MAX_NUMBER);
        return randomNumber;
    }

    public static int useInput (){
        Scanner scanner = new Scanner(System.in);
        System.out.print("please enter your guess : ");
        int guessNumber = scanner.nextInt();
        return guessNumber;
    }

    public static boolean checkGuess(int randomNumber, int guessNumber){
        boolean isEnded = false;

        if (randomNumber == guessNumber){
            System.out.println("Congrats ,your guess is correct it was "+ guessNumber);
            isEnded = true;
        }
        else if (randomNumber > guessNumber)
            System.out.println("The number is too high than "+ guessNumber);
        else
            System.out.println("The number is too low than "+ guessNumber);
        return isEnded;
    }

    public static void userRounds(int roundNumber){
        int randomNumber = generateRandomNumber();
        int userGuess = 0;
        boolean isEnded = false;
        NumberGame.rounds++;

        int i = 0;
        while (i++ < roundNumber){
            userGuess = useInput();
            if (checkGuess(randomNumber, userGuess)){
                NumberGame.score++;
                break;
            }
        }

        if (!isEnded && i > roundNumber)
         System.out.println("You have failed in this round ,the number was "+ roundNumber);

    }

    public static boolean anotherRound() {
        Scanner scanner = new Scanner(System.in);
        String response = "";

        do {
            System.out.print("Do you want another round (yes/ no) : ");
            response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("yes") && !response.equals("no"))
                System.out.println("Invalid Input please type wheter true or false ");
        }while (!response.equals("yes") && !response.equals("no"));

        return  (response.equals("yes"));
    }

    public  static void disPlayScore(){
        System.out.println("Your score is "+ NumberGame.score +" / "+ NumberGame.rounds);
    }

}
public class Main {

    public static void main(String[] argv) {

        final byte NUMBER_OF_ATTEMPTS = 4;
        boolean isAnotherRound = true;

        while (isAnotherRound) {
            NumberGame.userRounds(NUMBER_OF_ATTEMPTS);
            isAnotherRound = NumberGame.anotherRound();
        }
        NumberGame.disPlayScore();
    }

}
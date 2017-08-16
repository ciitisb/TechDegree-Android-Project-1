import java.io.Console;
import java.util.Scanner;

public class Prompter {
    private Jar mJar;

    Console console = System.console();

    public Prompter(Jar jar) {
        this.mJar = jar;
    }

    public void play() {
        console.printf("The possible fill amount is between 1 and %d\n", mJar.getAnswer());
        while (!mJar.isSolved()) {

            promptForGuess();
        }
        if (mJar.isSolved()) {
            String attempt;
            if (mJar.getTries() > 1) {
                attempt = "attempts";
            } else {
                attempt = "attempt";
            }
            System.out.printf("%d %s\n", mJar.getTries(), attempt);
        }
    }

    public void displayProgress() {
        System.out.printf("This is attempt #%d \n",
                mJar.getTries());
    }

    public boolean promptForGuess() {
        Scanner scanner = new Scanner(System.in);

        boolean isHit = false;
        boolean isValidGuess = false;

        while (!isValidGuess) {
            try {
                String guessAsString = console.readLine("How many %s? ", GuessingGame.getTypeOfItem());
                int guessAsInt = Integer.parseInt(guessAsString);
                try {
                    isHit = mJar.applyGuess(guessAsInt);
                    isValidGuess = true;
                } catch (IllegalArgumentException iae) {
                    console.printf("%s Please try again.\n", iae.getMessage());
                }
            } catch (NumberFormatException iae) {
                console.printf("A number must be entered.\n");
            }
        }
        return isHit;
    }
}

import java.util.Random;
/*This class extends NumberGuessingGame and adds more features, such as a limit on the number of attempts,basically just adding more features
inheritance helps to allow the code to look neater insteasd of having one large code but also helps making the code more reusable  */
class AdvancedNumberGuessingGame extends NumberGuessingGame {
    private int maxAttempts; // Maximum number of attempts allowed

    // Constructor to initialize the advanced game with range and max attempts
    public AdvancedNumberGuessingGame(int range, int maxAttempts) {
        super(range); // Call the constructor of the base class
        this.maxAttempts = maxAttempts; // Set the maximum number of attempts
    }

    // Overridden method to start the advanced game with attempt limits
    @Override
    public void startGame() {
        System.out.println("Welcome to the Advanced Number Guessing Game!");
        System.out.println("You have " + maxAttempts + " attempts to guess the number.");
        boolean guessedCorrectly = false; // Flag to track if the user guessed correctly
        int attempts = 0; // Counter for the number of attempts
        while (!guessedCorrectly && attempts < maxAttempts) { // Loop until the user guesses correctly or uses up all attempts
            System.out.print("Guess a number: ");
            int guess = scanner.nextInt(); // Read the user's guess
            attempts++; // Increment the attempts counter
            if (guess == targetNumber) { // Check if the guess is correct
                guessedCorrectly = true; // Set the flag to true
                System.out.println("Congratulations! You've guessed the number in " + attempts + " attempts.");
            } else if (guess < targetNumber) { // Provide hints if the guess is too low
                System.out.println("The number is higher. Try again.");
            } else { // Provide hints if the guess is too high
                System.out.println("The number is lower. Try again.");
            }
            System.out.println("Attempts left: " + (maxAttempts - attempts)); // Display remaining attempts
        }
        if (!guessedCorrectly) { // Check if the user failed to guess within the allowed attempts
            System.out.println("Sorry, you've used all your attempts. The number was " + targetNumber + ".");
        }
    }
}

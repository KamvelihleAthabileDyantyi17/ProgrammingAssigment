import java.util.Scanner;
//I callled this the base class to help me remmber that this is where the main content and logic of the code is
class NumberGuessingGame {
    protected int[] numbers; // Array to store possible numbers for guessing
    protected int targetNumber; // The number the user needs to guess
    protected Scanner scanner; // Scanner object to read user input

    // Constructor to initialize the game with a range of numbers
    public NumberGuessingGame(int range) {
        numbers = new int[range]; // Initialize the array with the given range
        for (int i = 0; i < range; i++) {
            numbers[i] = i + 1; // Fill the array with numbers from 1 to range
        }
        scanner = new Scanner(System.in); // Initialize the scanner for user input
        targetNumber = generateRandomNumber(); // Generate a random target number
    }

    // Method to generate a random number from the numbers array
    private int generateRandomNumber() {
        int randomIndex = (int) (Math.random() * numbers.length); // Generate a random index
        return numbers[randomIndex]; // Return the number at the random index
    }

    // Method to start the game and handle user guesses
    public void startGame() {
        System.out.println("Welcome to the Number Guessing Game!");
        boolean guessedCorrectly = false; // Flag to track if the user guessed correctly
        while (!guessedCorrectly) { // Loop until the user guesses correctly
            System.out.print("Guess a number: ");
            int guess = scanner.nextInt(); // Read the user's guess
            if (guess == targetNumber) { // Check if the guess is correct
                guessedCorrectly = true; // Set the flag to true
                System.out.println("Congratulations! You've guessed the number.");
            } else {
                System.out.println("Incorrect guess. Try again."); // Prompt the user to try again
            }
        }
    }
}

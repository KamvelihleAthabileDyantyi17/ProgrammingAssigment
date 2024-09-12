public class Question2 {
    //This basically allows the whole game/code to run
        public static void main(String[] args) {
            int range = 100; // Set the range of numbers (1 to 100)
            int maxAttempts = 5; // Set the maximum number of attempts allowed

            // Create an instance of AdvancedNumberGuessingGame with the specified range and attempts
            AdvancedNumberGuessingGame game = new AdvancedNumberGuessingGame(range, maxAttempts);
            game.startGame(); // Start the game
        }
    }



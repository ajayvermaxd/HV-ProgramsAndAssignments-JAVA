
import java.util.Random;
import java.util.Scanner;

public class hangman {

    public static void main(String[] args) {
        // Task: Create an array of words to use as the word bank.
        String[] wordBank = { "apple", "banana", "orange", "grape", "mango" };

        // Task: Randomly select a word from the word bank.
        Random random = new Random();
        String selectedWord = wordBank[random.nextInt(wordBank.length)];
        int randomNumber = random.nextInt(wordBank.length);
        char randomWordToGuess[] = wordBank[randomNumber].toCharArray(); 
        

        // Task: Initialize variables to keep track of the player's guessed letters and
        // incorrect guesses count.
        int allowedIncorrectGuesses = 6;
        int incorrectGuesses = 0;

        int ammountOfGuesses = randomWordToGuess.length;
        char playerGuess[] = new char[ammountOfGuesses];
        for (int i = 0; i < playerGuess.length; i++) { // Assign empty dashes at start "_ _ _ _ _ _ _ _"
                playerGuess[i] = '_';
            }
        // StringBuilder guessedLetters = new StringBuilder();

        // Task: Display a welcome message to the player.
        System.out.println("Welcome to Word Guessing Game!");

        // Task: Implement the game loop, which continues until the player wins or
        // loses.
        while (incorrectGuesses < allowedIncorrectGuesses) {
            // Task: Display the partially guessed word, showing underscores (_) for
            // unguessed letters.
            // Hint: Use a loop to iterate through the selectedWord characters and check if
            // the character is guessed or not.

            // Task: Display the number of incorrect guesses and the hangman figure.
            // Hint: You can use a switch statement to draw the hangman figure based on the
            // incorrect guesses count.

            // Task: Display the guessed letters.
            // Hint: Use guessedLetters.toString() to convert StringBuilder to String.

            // Task: Prompt the player to enter a letter.
            // Hint: Use Scanner class to read player input.

            // Task: Check if the letter is present in the selected word.
            // - If yes, reveal the letter in the word and update the partially guessed word
            // accordingly.
            // - If no, increase the incorrect guesses count and add the guessed letter to
            // the guessed letters list.

            // Task: Check if the player has correctly guessed the entire word.
            // - If yes, display a victory message and break the game loop.
            // - If no, continue to the next iteration of the game loop.
        }

        // Task: Display a victory or defeat message based on the game outcome.
        // Hint: Use a conditional statement to check if the player won or lost.

        // Task: Reveal the selected word to the player.
        System.out.println("The word was: " + selectedWord);
    }
}

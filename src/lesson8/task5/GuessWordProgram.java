package lesson8.task5;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessWordProgram {

    private static final Random RANDOM = new Random();
    private static final Scanner SCANNER = new Scanner(System.in);

    private String[] wordsToGuess = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
            "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
            "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

    /**
     * Method starts programs run, call a method which guessed a word
     * and then starts a process of user's guessing by calling another method.
     */
    public void start() {
        String guessedWord = makeUpWord();
        System.out.println("Guess which of the following words I have guessed: \n" + Arrays.toString(wordsToGuess));
        guessingProcess(guessedWord);
    }

    /**
     * Method receives user attempt. If the attempt is successful and the answer is right the program is over.
     * If it is not successful, the program print some motivation phrase, shows guessed letters of the word
     * and provides an opportunity to guess one more time until user succeeds.
     *
     * @param wordToGuess the word that user should guess
     */
    private void guessingProcess(String wordToGuess) {
        String userAnswer = userAnswer();
        if (checkIfUserIsRight(wordToGuess, userAnswer)) {
            System.out.println("Congrats! You win!");
            return;
        } else {
            System.out.println(randomMotivationMessage());
            printGuessedLetters(wordToGuess, userAnswer);
        }
        guessingProcess(wordToGuess);
    }

    /**
     * Method compares the guessed word and user's answer in order to print a hint
     * if user's answer contains some of the right letters on their exact place in guessed word.
     *
     * @param wordToGuess the word that user should guess
     * @param userAnswer  user's attempt to find out guessed word.
     */
    private void printGuessedLetters(String wordToGuess, String userAnswer) {
        char[] wordCharArray = wordToGuess.toCharArray();
        char[] userAnswerCharArray = userAnswer.toCharArray();
        char[] result = new char[15];
        if (wordCharArray.length > userAnswerCharArray.length) {
            for (int i = 0; i < userAnswerCharArray.length; i++) {
                if (wordCharArray[i] == userAnswerCharArray[i]) {
                    result[i] = wordCharArray[i];
                }
            }
        } else {
            for (int i = 0; i < wordCharArray.length; i++) {
                if (wordCharArray[i] == userAnswerCharArray[i]) {
                    result[i] = wordCharArray[i];
                }
            }
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] == '\u0000') {
                result[i] = '#';
            }
        }
        System.out.println(Arrays.toString(result));
    }

    /**
     * Method compares user's answer with guessed word.
     *
     * @param wordToGuess the word which user need to guess
     * @param userAnswer  user's attempt to find out guessed word.
     * @return boolean if user is right
     */
    private boolean checkIfUserIsRight(String wordToGuess, String userAnswer) {
        if (wordToGuess.length() != userAnswer.length()) {
            return false;
        }
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) != userAnswer.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method reads from scanner user's attempt to guess the word.
     *
     * @return string user answer
     */
    private String userAnswer() {
        System.out.println("Type the word -> ");
        return SCANNER.nextLine();
    }

    /**
     * Method choose randomly a word to guess from array of such words.
     *
     * @return guessed word
     */
    private String makeUpWord() {
        int i = RANDOM.nextInt(wordsToGuess.length);
        return wordsToGuess[i];
    }

    /**
     * Method returns random motivation string if user failed to guess a word.
     *
     * @return random string from array of motivation phrases.
     */
    private String randomMotivationMessage() {
        String[] messages = {
                "Nice try! Don’t give up!",
                "Try again!",
                "Keep going!",
                "Almost there!"
        };
        int i = RANDOM.nextInt(messages.length);
        return messages[i];
    }

}

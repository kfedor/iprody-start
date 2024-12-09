package lesson8;

import lesson8.task5.GuessWordProgram;

public class ApplicationRunner {
    public static void main(String[] args) {
        //check findSymbolOccurance
        String source = "abracadabra";
        char charTarget = 'a';
        Lesson8 lesson8 = new Lesson8();
        int count = lesson8.findSymbolOccurance(source, charTarget);
        System.out.println(count);

        //check findWordPosition
        String target = "cadabra";
        System.out.println(lesson8.findWordPosition(source, target));

        //check stringReverse
        String resultReverse = lesson8.stringReverse(source);
        System.out.println(resultReverse);

        //check isPalindrome
        System.out.println(lesson8.isPalindrome(source));

        //check guessWordProgram
        GuessWordProgram guessWordProgram = new GuessWordProgram();
        guessWordProgram.start();

    }
}

import java.util.Random;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static final String[] WORDS = {"brother", "mission", "g-wagon", "esethu", "ferrari", "lamborghini"};
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        String word;
        boolean isCorrect = false;
        int score = 0;
        int lives = 3;
        while (lives > 0) {
            Random random = new Random();
            String orgWords = WORDS[random.nextInt(WORDS.length)];
            String mixedWords = mixedWords(orgWords);
            System.out.println("Guess the word: " + mixedWords);
            System.out.print("Enter word: ");
            word = scanner.nextLine();

            if (word.equalsIgnoreCase(orgWords)) {
                System.out.println("Correct!! Good work");
                System.out.print("lives: " + lives + "   ");
                isCorrect = true;
                score += 1;
                System.out.println("score: " + score);
                System.out.println("");
            } else {
                System.out.println("Wrong! Correct answer: " + orgWords);
                lives -= 1;
                System.out.print("lives: " + lives + "   ");
                System.out.println("score: " + score);
                System.out.println("");
            }
        }

        System.out.println("Game Over!!");

        scanner.close();
    }

    public static String mixedWords(String word){
        char[] letters = word.toCharArray();
        Random random = new Random();

        for (int i = 0; i < letters.length; i++){
            int index = random.nextInt(letters.length);
            char temp = letters[i];
            letters[i] = letters[index];
            letters[index] = temp;
        }
        return new String(letters);
    }
}
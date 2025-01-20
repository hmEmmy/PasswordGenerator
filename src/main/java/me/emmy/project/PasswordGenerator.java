package me.emmy.project;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Emmy
 * @project PasswordGenerator
 * @date 20/01/2025 - 21:17
 */
public class PasswordGenerator {
    /**
     * This is a simple password generator that takes in a word or combined words and generates a password
     * by mixing the characters of the words and adding random numbers and special characters.
     * The password is generated in a loop until the user types 'exit' or 'quit'.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        Scanner scanner = new Scanner(System.in);

        Arrays.asList(
                "",
                "🌟 PasswordGenerator made by Emmy 🌟",
                ""
        ).forEach(System.out::println);

        while (true) {
            Arrays.asList(
                    "💡 [Type 'exit' to stop the program]",
                    "📝 Enter anything to generate a password based on the input",
                    "",
                    "Your input: "
            ).forEach(System.out::println);

            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the password generator. Goodbye!");
                break;
            }

            String[] words = input.split(" ");

            List<String> wordList = Arrays.asList(words);
            Collections.shuffle(wordList);

            StringBuilder password = new StringBuilder();

            for (String word : wordList) {
                StringBuilder mixedWord = new StringBuilder();
                for (char c : word.toCharArray()) {
                    if (random.nextBoolean()) {
                        mixedWord.append(Character.toUpperCase(c));
                    } else {
                        mixedWord.append(Character.toLowerCase(c));
                    }
                }

                password.append(mixedWord);
                password.append(random.nextInt(10));
                password.append(getChars()[random.nextInt(getChars().length)]);
            }

            Arrays.asList(
                    "====================================",
                    "🔑 Generated Password: " + password,
                    "===================================="
            ).forEach(System.out::println);
        }
    }

    /**
     * Returns an array of special characters.
     *
     * @return an array of special characters
     */
    private static char[] getChars() {
        return new char[]{'!', '@', '-', '_'};
    }
}
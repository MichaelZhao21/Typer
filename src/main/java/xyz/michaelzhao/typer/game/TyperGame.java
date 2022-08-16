package xyz.michaelzhao.typer.game;

import xyz.michaelzhao.typer.MainApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class TyperGame {
    private int score;
    private Set<String> currentWords;
    private List<String> dictionary;

    private Random rand;

    public TyperGame() {
        // Read words from text file
        URL file = MainApplication.class.getResource("words.txt");
        if (file == null) {
            System.err.println("Words file cannot be located with getResource");
            System.exit(1);
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.openStream(), StandardCharsets.UTF_8))) {
            String line;
            dictionary = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                dictionary.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        // Initialize other instance variables
        score = 0;
        currentWords = new HashSet<>();
        rand = new Random(System.currentTimeMillis());
    }

    public int getScore() {
        return score;
    }

    /**
     * Generate a new word from the dictionary
     * @return Valid word
     */
    public String newWord() {
        String word;
        do {
            int num = rand.nextInt(dictionary.size());
            word = dictionary.get(num);
        } while (currentWords.contains(word));
        currentWords.add(word);
        return word;
    }

    /**
     * Makes an attempt to the type a word on the screen
     * @param text The guess made
     * @return Either correct, invalid word, or wrong
     */
    public GuessStatus guess(String text) {
        if (currentWords.contains(text)) {
            // If the guess is correct, increment the score and remove that word
            score++;
            currentWords.remove(text);
            return GuessStatus.CORRECT;
        } else if (dictionary.contains(text)) {
            // Otherwise, check if the word is in the dictionary
            return GuessStatus.WRONG;
        }
        // If not in the dictionary, return an "invalid word" response
        return GuessStatus.INVALID_WORD;
    }
}

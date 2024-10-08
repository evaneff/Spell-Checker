package services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SuggestedWords {

    public SuggestedWords() {
    }

    //Levenshtein Distance https://www.baeldung.com/java-levenshtein-distance

    public static int costOfSubstitution(char a, char b) {
        return a == b ? 0 : 1;
    }

    public static int min(int... numbers) {
        return Arrays.stream(numbers)
                .min().orElse(Integer.MAX_VALUE);
    }
    static int calculate(String x, String y) {
        int[][] dp = new int[x.length() + 1][y.length() + 1];

        for (int i = 0; i <= x.length(); i++) {
            for (int j = 0; j <= y.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                }
                else if (j == 0) {
                    dp[i][j] = i;
                }
                else {
                    dp[i][j] = min(dp[i - 1][j - 1]
                                    + costOfSubstitution(x.charAt(i - 1), y.charAt(j - 1)),
                            dp[i - 1][j] + 1,
                            dp[i][j - 1] + 1);
                }
            }
        }

        return dp[x.length()][y.length()];
    }

    public List<String> suggestWords(File file, String word) {

        List<String> list = new ArrayList<>();
        String result = "";

        //find closest spelled words in dictionary
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                String dictionaryWord = sc.next();

                int numOfEdits = calculate(word, dictionaryWord);

                if (numOfEdits < 2) {
                    list.add(dictionaryWord);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        return list;
    }
}

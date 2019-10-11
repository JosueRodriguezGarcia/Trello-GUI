/*
 * Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package core.selenium.util;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * WordsToNumbers class.
 *
 * @author Josue Rodriguez.
 * @version 0.0.1
 */
public final class WordsToNumbers {

    private static final List<String> ALLOWED_STRINGS = Arrays.asList("and", "zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
            "sixteen", "seventeen", "eighteen", "nineteen", "twenty", "thirty", "forty", "fifty", "sixty", "seventy",
            "eighty", "ninety", "hundred", "thousand", "million", "billion", "trillion");
    public static final int INTERMEDIATE_RESULT = 3;
    public static final int INTERMEDIATE_RESULT1 = 4;
    public static final int INTERMEDIATE_RESULT2 = 5;
    public static final int INTERMEDIATE_RESULT3 = 6;
    public static final int INTERMEDIATE_RESULT4 = 7;
    public static final int INTERMEDIATE_RESULT5 = 8;
    public static final int INTERMEDIATE_RESULT6 = 9;
    public static final int INTERMEDIATE_RESULT7 = 10;
    public static final int INTERMEDIATE_RESULT8 = 11;
    public static final int INTERMEDIATE_RESULT9 = 12;
    public static final int INTERMEDIATE_RESULT10 = 13;
    public static final int INTERMEDIATE_RESULT11 = 14;
    public static final int INTERMEDIATE_RESULT12 = 15;
    public static final int INTERMEDIATE_RESULT13 = 16;
    public static final int INTERMEDIATE_RESULT14 = 17;
    public static final int INTERMEDIATE_RESULT15 = 18;
    public static final int INTERMEDIATE_RESULT16 = 19;
    public static final int INTERMEDIATE_RESULT17 = 20;
    public static final int INTERMEDIATE_RESULT18 = 30;
    public static final int INTERMEDIATE_RESULT19 = 40;
    public static final int INTERMEDIATE_RESULT20 = 50;
    public static final int INTERMEDIATE_RESULT21 = 60;
    public static final int INTERMEDIATE_RESULT22 = 70;
    public static final int INTERMEDIATE_RESULT23 = 80;
    public static final int INTERMEDIATE_RESULT24 = 90;
    public static final int INTERMEDIATE_RESULT25 = 100;
    public static final int INTERMEDIATE_RESULT26 = 1000;
    public static final int INTERMEDIATE_RESULT27 = 1000000;
    public static final int INTERMEDIATE_RESULT28 = 1000000000;
    public static final long INTERMEDIATE_RESULT29 = 1000000000000L;


    /**
     * Private constructor requested by checkstyle.
     */
    private WordsToNumbers() {

    }

    /**
     * Main driver method. Converts textual numbers (e.g. twenty five) to
     * integers (e.g. 25)
     *
     * Does not currently cater for decimal points. e.g. "five point two"
     *
     * @param inputText a string.
     * @return a string.
     */
    public static String convert(final String inputText) {

        List<String> words = new LinkedList<String>(cleanAndTokenizeText(inputText));

        words = replaceTextualNumbers(words);

        return wordListToString(words);
    }

    /**
     * Does the replacement of textual numbers, processing each word at a time
     * and grouping them before doing the conversion.
     *
     * @param words defines a list.
     * @return a list.
     */
    private static List<String> replaceTextualNumbers(final List<String> words) {

        List<String> processingList = new LinkedList<String>();

        int i = 0;
        while (i < words.size() || !processingList.isEmpty()) {
            String word = "";
            if (i < words.size()) {
                word = words.get(i);
            }

            String wordStripped = word.replaceAll("[^a-zA-Z\\s]", "").toLowerCase();
            if (ALLOWED_STRINGS.contains(wordStripped) && !(processingList.size() == 0 && wordStripped.equals("and"))) {
                words.remove(i);
                processingList.add(word);
            } else if (processingList.size() > 0) {
                String lastProcessedWord = processingList.get(processingList.size() - 1);
                if (lastProcessedWord.equals("and")) {
                    words.add(i, "and");
                    processingList.remove(processingList.size() - 1);
                }
                String wordAsDigits = String.valueOf(convertWordsToNum(processingList));

                wordAsDigits = retainPunctuation(processingList, wordAsDigits);
                words.add(i, String.valueOf(wordAsDigits));

                processingList.clear();
                i += 2;
            } else {
                i++;
            }
        }

        return words;
    }

    /**
     * Retain punctuation at the start and end of a textual number.
     *
     * e.g. (seventy two) -> (72)
     *
     * @param processingList defines a list.
     * @param wordAsDigits defines a string
     * @return a string.
     */
    private static String retainPunctuation(final List<String> processingList, final String wordAsDigits) {
        String aux = wordAsDigits;

        String lastWord = processingList.get(processingList.size() - 1);
        char lastChar = lastWord.trim().charAt(lastWord.length() - 1);
        if (!Character.isLetter(lastChar)) {
            aux += lastChar;
        }

        String firstWord = processingList.get(0);
        char firstChar = firstWord.trim().charAt(0);
        if (!Character.isLetter(firstChar)) {
            aux = firstChar + wordAsDigits;
        }

        return wordAsDigits;
    }

    /**
     * Splits up hyphenated textual words. e.g. twenty-two -> twenty two
     *
     * @param sentence defines a string.
     * @return a list.
     */
    private static List<String> cleanAndTokenizeText(final String sentence) {
        List<String> words = new LinkedList<String>(Arrays.asList(sentence.split(" ")));

        // remove hyphenated textual numbers
        for (int i = 0; i < words.size(); i++) {
            String str = words.get(i);
            if (str.contains("-")) {
                List<String> splitWords = Arrays.asList(str.split("-"));

                // just check the first word is a textual number. Caters for
                // "twenty-five," without having to strip the comma
                if (splitWords.size() > 1 && ALLOWED_STRINGS.contains(splitWords.get(0))) {
                    words.remove(i);
                    words.addAll(i, splitWords);
                }
            }

        }

        return words;
    }

    /**
     * Creates string including spaces from a list of words.
     *
     * @param list defines a list.
     * @return a string.
     */
    private static String wordListToString(final List<String> list) {
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if (i == 0 && str != null) {
                result.append(list.get(i));
            } else if (str != null) {
                result.append(" " + list.get(i));
            }
        }

        return result.toString();
    }

    /**
     * Logic for taking a textual number string and converting it into a number
     * e.g. twenty five -> 25
     * <p>
     * This relies on there only being one textual number being processed. Steps
     * prior to this deal with breaking a paragraph down into individual textual
     * numbers, which could consist of a number of words.
     *
     * @param words defines a list.
     * @return a long.
     */
    private static long convertWordsToNum(final List<String> words) {
        long finalResult = 0;
        long intermediateResult = 0;
        for (String str : words) {
            // clean up string for easier processing
            str = str.toLowerCase().replaceAll("[^a-zA-Z\\s]", "");
            if (str.equalsIgnoreCase("zero")) {
                intermediateResult += 0;
            } else if (str.equalsIgnoreCase("one")) {
                intermediateResult += 1;
            } else if (str.equalsIgnoreCase("two")) {
                intermediateResult += 2;
            } else if (str.equalsIgnoreCase("three")) {
                intermediateResult += INTERMEDIATE_RESULT;
            } else if (str.equalsIgnoreCase("four")) {
                intermediateResult += INTERMEDIATE_RESULT1;
            } else if (str.equalsIgnoreCase("five")) {
                intermediateResult += INTERMEDIATE_RESULT2;
            } else if (str.equalsIgnoreCase("six")) {
                intermediateResult += INTERMEDIATE_RESULT3;
            } else if (str.equalsIgnoreCase("seven")) {
                intermediateResult += INTERMEDIATE_RESULT4;
            } else if (str.equalsIgnoreCase("eight")) {
                intermediateResult += INTERMEDIATE_RESULT5;
            } else if (str.equalsIgnoreCase("nine")) {
                intermediateResult += INTERMEDIATE_RESULT6;
            } else if (str.equalsIgnoreCase("ten")) {
                intermediateResult += INTERMEDIATE_RESULT7;
            } else if (str.equalsIgnoreCase("eleven")) {
                intermediateResult += INTERMEDIATE_RESULT8;
            } else if (str.equalsIgnoreCase("twelve")) {
                intermediateResult += INTERMEDIATE_RESULT9;
            } else if (str.equalsIgnoreCase("thirteen")) {
                intermediateResult += INTERMEDIATE_RESULT10;
            } else if (str.equalsIgnoreCase("fourteen")) {
                intermediateResult += INTERMEDIATE_RESULT11;
            } else if (str.equalsIgnoreCase("fifteen")) {
                intermediateResult += INTERMEDIATE_RESULT12;
            } else if (str.equalsIgnoreCase("sixteen")) {
                intermediateResult += INTERMEDIATE_RESULT13;
            } else if (str.equalsIgnoreCase("seventeen")) {
                intermediateResult += INTERMEDIATE_RESULT14;
            } else if (str.equalsIgnoreCase("eighteen")) {
                intermediateResult += INTERMEDIATE_RESULT15;
            } else if (str.equalsIgnoreCase("nineteen")) {
                intermediateResult += INTERMEDIATE_RESULT16;
            } else if (str.equalsIgnoreCase("twenty")) {
                intermediateResult += INTERMEDIATE_RESULT17;
            } else if (str.equalsIgnoreCase("thirty")) {
                intermediateResult += INTERMEDIATE_RESULT18;
            } else if (str.equalsIgnoreCase("forty")) {
                intermediateResult += INTERMEDIATE_RESULT19;
            } else if (str.equalsIgnoreCase("fifty")) {
                intermediateResult += INTERMEDIATE_RESULT20;
            } else if (str.equalsIgnoreCase("sixty")) {
                intermediateResult += INTERMEDIATE_RESULT21;
            } else if (str.equalsIgnoreCase("seventy")) {
                intermediateResult += INTERMEDIATE_RESULT22;
            } else if (str.equalsIgnoreCase("eighty")) {
                intermediateResult += INTERMEDIATE_RESULT23;
            } else if (str.equalsIgnoreCase("ninety")) {
                intermediateResult += INTERMEDIATE_RESULT24;
            } else if (str.equalsIgnoreCase("hundred")) {
                intermediateResult *= INTERMEDIATE_RESULT25;
            } else if (str.equalsIgnoreCase("thousand")) {
                intermediateResult *= INTERMEDIATE_RESULT26;
                finalResult += intermediateResult;
                intermediateResult = 0;
            } else if (str.equalsIgnoreCase("million")) {
                intermediateResult *= INTERMEDIATE_RESULT27;
                finalResult += intermediateResult;
                intermediateResult = 0;
            } else if (str.equalsIgnoreCase("billion")) {
                intermediateResult *= INTERMEDIATE_RESULT28;
                finalResult += intermediateResult;
                intermediateResult = 0;
            } else if (str.equalsIgnoreCase("trillion")) {
                intermediateResult *= INTERMEDIATE_RESULT29;
                finalResult += intermediateResult;
                intermediateResult = 0;
            }
        }

        finalResult += intermediateResult;
        intermediateResult = 0;
        return finalResult;
    }
}

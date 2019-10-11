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
public class WordsToNumbers {

    private final static List<String> allowedStrings = Arrays.asList("and", "zero", "one", "two", "three", "four", "five",
            "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
            "seventeen", "eighteen", "nineteen", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty",
            "ninety", "hundred", "thousand", "million", "billion", "trillion");

    /**
     * Main driver method. Converts textual numbers (e.g. twenty five) to
     * integers (e.g. 25)
     *
     * Does not currently cater for decimal points. e.g. "five point two"
     *
     * @param inputText
     */
    public static String convert(String inputText) {

        List<String> words = new LinkedList<String>(cleanAndTokenizeText(inputText));

        words = replaceTextualNumbers(words);

        return wordListToString(words);
    }

    /**
     * Does the replacement of textual numbers, processing each word at a time
     * and grouping them before doing the conversion
     *
     * @param words
     * @return
     */
    private static List<String> replaceTextualNumbers(List<String> words) {

        List<String> processingList = new LinkedList<String>();

        int i = 0;
        while (i < words.size() || !processingList.isEmpty()) {
            String word = "";
            if (i < words.size()) {
                word = words.get(i);
            }

            String wordStripped = word.replaceAll("[^a-zA-Z\\s]", "").toLowerCase();
            if (allowedStrings.contains(wordStripped) && !(processingList.size() == 0 && wordStripped.equals("and"))) {
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
     * @param processingList
     * @param wordAsDigits
     * @return
     */
    private static String retainPunctuation(List<String> processingList, String wordAsDigits) {

        String lastWord = processingList.get(processingList.size() - 1);
        char lastChar = lastWord.trim().charAt(lastWord.length() - 1);
        if (!Character.isLetter(lastChar)) {
            wordAsDigits += lastChar;
        }

        String firstWord = processingList.get(0);
        char firstChar = firstWord.trim().charAt(0);
        if (!Character.isLetter(firstChar)) {
            wordAsDigits = firstChar + wordAsDigits;
        }

        return wordAsDigits;
    }

    /**
     * Splits up hyphenated textual words. e.g. twenty-two -> twenty two
     *
     * @param sentence
     * @return
     */
    private static List<String> cleanAndTokenizeText(String sentence) {
        List<String> words = new LinkedList<String>(Arrays.asList(sentence.split(" ")));

        // remove hyphenated textual numbers
        for (int i = 0; i < words.size(); i++) {
            String str = words.get(i);
            if (str.contains("-")) {
                List<String> splitWords = Arrays.asList(str.split("-"));

                // just check the first word is a textual number. Caters for
                // "twenty-five," without having to strip the comma
                if (splitWords.size() > 1 && allowedStrings.contains(splitWords.get(0))) {
                    words.remove(i);
                    words.addAll(i, splitWords);
                }
            }

        }

        return words;
    }

    /**
     * Creates string including spaces from a list of words
     *
     * @param list
     * @return
     */
    private static String wordListToString(List<String> list) {
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
     *
     * This relies on there only being one textual number being processed. Steps
     * prior to this deal with breaking a paragraph down into individual textual
     * numbers, which could consist of a number of words.
     *
     * @param words
     * @return
     */
    private static long convertWordsToNum(List<String> words) {
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
                intermediateResult += 3;
            } else if (str.equalsIgnoreCase("four")) {
                intermediateResult += 4;
            } else if (str.equalsIgnoreCase("five")) {
                intermediateResult += 5;
            } else if (str.equalsIgnoreCase("six")) {
                intermediateResult += 6;
            } else if (str.equalsIgnoreCase("seven")) {
                intermediateResult += 7;
            } else if (str.equalsIgnoreCase("eight")) {
                intermediateResult += 8;
            } else if (str.equalsIgnoreCase("nine")) {
                intermediateResult += 9;
            } else if (str.equalsIgnoreCase("ten")) {
                intermediateResult += 10;
            } else if (str.equalsIgnoreCase("eleven")) {
                intermediateResult += 11;
            } else if (str.equalsIgnoreCase("twelve")) {
                intermediateResult += 12;
            } else if (str.equalsIgnoreCase("thirteen")) {
                intermediateResult += 13;
            } else if (str.equalsIgnoreCase("fourteen")) {
                intermediateResult += 14;
            } else if (str.equalsIgnoreCase("fifteen")) {
                intermediateResult += 15;
            } else if (str.equalsIgnoreCase("sixteen")) {
                intermediateResult += 16;
            } else if (str.equalsIgnoreCase("seventeen")) {
                intermediateResult += 17;
            } else if (str.equalsIgnoreCase("eighteen")) {
                intermediateResult += 18;
            } else if (str.equalsIgnoreCase("nineteen")) {
                intermediateResult += 19;
            } else if (str.equalsIgnoreCase("twenty")) {
                intermediateResult += 20;
            } else if (str.equalsIgnoreCase("thirty")) {
                intermediateResult += 30;
            } else if (str.equalsIgnoreCase("forty")) {
                intermediateResult += 40;
            } else if (str.equalsIgnoreCase("fifty")) {
                intermediateResult += 50;
            } else if (str.equalsIgnoreCase("sixty")) {
                intermediateResult += 60;
            } else if (str.equalsIgnoreCase("seventy")) {
                intermediateResult += 70;
            } else if (str.equalsIgnoreCase("eighty")) {
                intermediateResult += 80;
            } else if (str.equalsIgnoreCase("ninety")) {
                intermediateResult += 90;
            } else if (str.equalsIgnoreCase("hundred")) {
                intermediateResult *= 100;
            } else if (str.equalsIgnoreCase("thousand")) {
                intermediateResult *= 1000;
                finalResult += intermediateResult;
                intermediateResult = 0;
            } else if (str.equalsIgnoreCase("million")) {
                intermediateResult *= 1000000;
                finalResult += intermediateResult;
                intermediateResult = 0;
            } else if (str.equalsIgnoreCase("billion")) {
                intermediateResult *= 1000000000;
                finalResult += intermediateResult;
                intermediateResult = 0;
            } else if (str.equalsIgnoreCase("trillion")) {
                intermediateResult *= 1000000000000L;
                finalResult += intermediateResult;
                intermediateResult = 0;
            }
        }

        finalResult += intermediateResult;
        intermediateResult = 0;
        return finalResult;
    }
}

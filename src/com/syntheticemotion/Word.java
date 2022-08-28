package com.syntheticemotion;

import java.util.Locale;

public class Word {
    private String word;

    public Word(String word) {
        this.word = word;
    }

    public String getContent() {
        return word;
    }

    public int getLength() {
        return word.length();
    }

    public boolean schBetweenConsonants() {
        int sch_index = word.indexOf("sch");

        if(sch_index > 0) {
            if(isConsonant(word.charAt(sch_index - 1)) && (sch_index + "sch".length()) < word.length() &&
                    isConsonant(word.charAt(sch_index + "sch".length()))) {
                return true;
            }
        }

        return false;
    }

    public boolean hasMaxVowel(int max) {
        int vowelCount = 0;

        for(int i = 0; i < word.length(); i++) {
            char c = word.toLowerCase(Locale.ROOT).charAt(i);

            if(isVowel(c)) {
                vowelCount++;
            }
        }

        return vowelCount == max;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'o' || c == 'u' || c == 'i' || c == 'e' || c == 'ä' || c == 'ö' || c == 'ü' || c == 'y'
                || c == 'é' || c == 'í' || c == 'ì';
    }

    private boolean isConsonant(char c) {
        return !isVowel(c);
    }

    @Override
    public String toString() {
        return "Word[content=" + word + ",length=" + word.length() + "]";
    }
}

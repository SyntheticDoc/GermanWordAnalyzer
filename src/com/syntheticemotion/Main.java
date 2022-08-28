package com.syntheticemotion;

import java.util.ArrayList;

/*
    Word list used:
    https://gist.github.com/MarvinJWendt/2f4f4154b8ae218600eb091a5706b5f4
 */

public class Main {

    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();
        ArrayList<Word> list = fileHandler.getList();

        //getOneVowelOnlyLongest(list);
        fileHandler.saveToText(getSchBetweenConsonantWords(list));
    }

    public static void getOneVowelOnlyLongest(ArrayList<Word> list) {
        Word longest = new Word("");
        long counter = 0;

        System.out.println("Total words to analyze: " + list.size());

        for(Word w : list) {
            if(counter % 100000 == 0) {
                System.out.println("Scanning words... " + counter);
            }

            if(w.hasMaxVowel(1) && w.getLength() > longest.getLength()) {
                longest = w;
            }

            counter++;
        }

        System.out.println("\nLongest word in list with exactly one vowels: " + longest);
    }

    public static ArrayList<Word> getSchBetweenConsonantWords(ArrayList<Word> list) {
        long counter = 0;
        long foundWordCounter = 0;
        System.out.println("Total words to analyze: " + list.size());
        ArrayList<Word> result = new ArrayList<>();
        Word longest = new Word("");

        for(Word w : list) {
            if(counter % 100000 == 0) {
                System.out.println("Scanning words... " + counter);
            }

            if(w.schBetweenConsonants()) {
                result.add(w);
                foundWordCounter++;

                if(w.getLength() > longest.getLength()) {
                    longest = w;
                }
            }

            counter++;
        }

        System.out.println("Longest word with \"sch\" between consonants: " + longest);
        System.out.println("Total found words: " + foundWordCounter);

        return result;
    }
}

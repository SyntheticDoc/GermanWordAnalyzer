package com.syntheticemotion;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    String fileName = "wordlist-german.txt";

    public ArrayList<Word> getList() {
        ArrayList<Word> list = new ArrayList<>();

        try {
            File myObj = new File(fileName);
            Scanner sc = new Scanner(myObj, StandardCharsets.UTF_8);

            while(sc.hasNextLine()) {
                Word w = new Word(sc.nextLine());
                list.add(w);
            }

            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Wordlist loaded, total words: " + list.size());
        return list;
    }

    public void saveToText(ArrayList<Word> list) {
        try {
            FileWriter myWriter = new FileWriter("sch_words.txt");

            for(Word w : list) {
                myWriter.write(w.toString() + "\n");
            }

            myWriter.close();
            System.out.println("Successfully wrote to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

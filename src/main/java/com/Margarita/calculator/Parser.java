package com.Margarita.calculator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by Batman on 27.11.2018.
 */
public class Parser {

    private List<String> stringToArray(String str) {
        return Arrays.asList(str.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)"));
    }

    public List<List<String>> readFromFile(String filename) {

        List<List<String>> stringsFromFile = new ArrayList<>();
        try (BufferedReader readFromFile = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = readFromFile.readLine()) != null) {
                stringsFromFile.add(stringToArray(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringsFromFile;
    }

    public static void main(String Args[]) {
        String str = "12+2)+3*(1+9)";
        System.out.println(Arrays.asList(str.split("([+\\-*/\\d\\(\\)=])")));
    }
}

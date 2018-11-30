package com.Margarita.calculator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by Batman on 27.11.2018.
 */
public class Parser {

    private String line;

    private List<String> stringToArray(String str) {
        return Arrays.asList(str.split(" "));
    }

    public List<String> readFromFile(String filename) {
        List<String> stringsFromFile = new ArrayList<String>();
        try (BufferedReader readFromFile = new BufferedReader(new FileReader(filename))) {

            while ((line = readFromFile.readLine()) != null) {
                stringsFromFile.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringToArray(stringsFromFile.get(stringsFromFile.size() - 1));
    }
}

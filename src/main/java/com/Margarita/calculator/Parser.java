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
        return Arrays.asList(str.split(" "));
    }



    public List<List<String>> readFromFile(String filename) {

        List<List<String>> stringsFromFile = new ArrayList<>();
        //ArrayList<String> stringsFromFile = new ArrayList<String>();
        try (BufferedReader readFromFile = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = readFromFile.readLine()) != null) {
                //stringsFromFile.add(line);
               // listOfStringFromFile.add((ArrayList<String>) stringToArray(stringsFromFile.get(stringsFromFile.size() - 1)));
                stringsFromFile.add(stringToArray(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringsFromFile;
       // return stringToArray(stringsFromFile.get(stringsFromFile.size() - 1));
    }
}

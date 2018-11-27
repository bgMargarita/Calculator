package com.Margarita.calculator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Batman on 27.11.2018.
 */
public class Parser {
    String filename = "file.txt";

    String line;
    List<String> mass = new ArrayList<String>();

    public void reader() {
        BufferedReader readFromFile = null;
        try {
            readFromFile = new BufferedReader(new FileReader("C:\\Users\\Batman\\Downloads\\text.txt"));
            while ((line = readFromFile.readLine()) != null) {
            mass.add(readFromFile.readLine());


            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (readFromFile != null)
                try {
                    readFromFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

}

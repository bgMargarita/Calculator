package com.Margarita.calculator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Batman on 27.11.2018.
 */
public class Parser {
    String line;
    List<String> Array = new ArrayList<String>();

    public void readFromFile() {
        BufferedReader readFromFile = null;
        try {
            readFromFile = new BufferedReader(new FileReader("\\Users\\Batman\\IdeaProjects\\Calculator\\src\\file.txt"));
            while ((line = readFromFile.readLine()) != null) {
                Array.add(line);
                System.out.println("gdfg");
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

    public static void main(String args[]) {
        Parser parser = new Parser();

    }

}

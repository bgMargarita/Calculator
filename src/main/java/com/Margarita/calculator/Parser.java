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
            readFromFile = new BufferedReader(new FileReader("\\Users\\Batman\\IdeaProjects\\Calculator\\src\\file.txt"));
            while ((line = readFromFile.readLine()) != null) {
            mass.add(line);
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
    public static void main(String args[]){
        Parser parser = new Parser();
        parser.reader();
    }

}

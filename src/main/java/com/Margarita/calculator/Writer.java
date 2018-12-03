package com.Margarita.calculator;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Batman on 03.12.2018.
 */
public class Writer {
    public void writeToFile(Double answ) {
        try (FileWriter writer = new FileWriter("Answer.txt", false)) {
            writer.write(answ.toString());
            writer.append('\n');

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

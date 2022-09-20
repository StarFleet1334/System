package com.solvd.app.tasks;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;


public class FileTask {
    private static final Logger LOGGER = LogManager.getLogger(FileTask.class);

    static String content = "He used to get confused between soldiers and shoulders," +
            " but as a military man, he now soldiers responsibility.";

    static String second = "The fish listened intently to what the frogs had to say.";

    static File file = new File("fileTask/task.txt");

    public static void main(String[] args) {
        clean();
        helper(second);
        gettingUniqueWords();
    }

    public static void helper(String message) {
        try {
            FileUtils.writeStringToFile(file,message,true);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    public static void gettingUniqueWords() {
        try {
            String sentence = FileUtils.readFileToString(file, Charset.defaultCharset());
            String[] data = sentence.split("[\\,' '.]");
            helper("\n");
            helper("---------------------------------------");
            helper("\n");
            helper("-------------UNIQUE WORDS--------------");
            helper("\n");
            for (int i = 0; i < data.length; i++) {
                if (StringUtils.countMatches(sentence,data[i]) == 1) {
                    helper( (i + 1) + ". " + data[i] + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    public static void clean() {
        try {
            FileUtils.forceDelete(file);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
}

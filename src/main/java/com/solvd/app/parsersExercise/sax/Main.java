package com.solvd.app.parsersExercise.sax;

import com.solvd.app.tables.Jobs;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Creating Factory to get Parser
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            SaxHandler saxHandler = new SaxHandler();

            // Getting file from resources
            ClassLoader classLoader = Main.class.getClassLoader();
            URL resource = classLoader.getResource("saxXml/vacancies.xml");

            assert resource != null;
            File file = new File(resource.toURI());

            saxParser.parse(file,saxHandler);

            List<Jobs> lst = saxHandler.getLst();

            for (Jobs jobs : lst) {
                System.out.println(jobs);
            }
        } catch (ParserConfigurationException | SAXException | URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }
}

package com.solvd.app.parsersExercise.dom;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, URISyntaxException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        ClassLoader classLoader = com.solvd.app.parsersExercise.sax.Main.class.getClassLoader();
        URL resource = classLoader.getResource("domXml/tech.xml");

        assert resource != null;
        File file = new File(resource.toURI());

        Document document = builder.parse(file);

        DomParser domParser = new DomParser();

        NodeList m = document.getElementsByTagName("Leptop");

        if (document.hasChildNodes()) {
            domParser.read(m);
        }

        System.out.println("Root Element: " + document.getDocumentElement().getNodeName());
    }
}

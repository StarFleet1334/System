package com.solvd.app.parsersExercise.sax;

import com.solvd.app.tables.Jobs;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

public class Main {
    private static final String xml = "saxXml/vacancies.xml";
    private static final String xsd = "saxXml/vacancies.xsd";

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
//
//        if (validate(xsd,xml)) {
//            System.out.println("Succeeded");
//        } else {
//            System.out.println("failure");
//        }
    }

    public static boolean validate(String xsd,String xml) {
        try {
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            ClassLoader classLoader = com.solvd.app.parsersExercise.stax.Main.class.getClassLoader();
            URL xsd_resource = classLoader.getResource(xsd.toString());
            URL xml_resource = classLoader.getResource(xml.toString());


            assert xsd_resource != null;
            Schema schema = factory.newSchema(new File(xsd_resource.toURI()));
            Validator validator = schema.newValidator();
            assert xml_resource != null;
            validator.validate(new StreamSource(new File(xml_resource.toURI())));
        } catch (IOException | SAXException e) {
            System.out.println("Exception : " + e.getMessage());
            return false;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return true;
    }
}

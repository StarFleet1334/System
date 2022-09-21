package com.solvd.app.parsersexercise.dom;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {
    private static final String xsd = "domXml/tech.xsd";
    private static final String xml = "domXml/tech.xml";


    public static void main(String[] args) throws ParserConfigurationException, URISyntaxException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        ClassLoader classLoader = com.solvd.app.parsersexercise.sax.Main.class.getClassLoader();
        URL resource = classLoader.getResource("domXml/tech.xml");

        assert resource != null;
        File file = new File(resource.toURI());

        Document document = builder.parse(file);

        DomParser domParser = new DomParser();

        NodeList m = document.getElementsByTagName("leptop");

        if (document.hasChildNodes()) {
            domParser.read(m);
        }

        System.out.println("Root Element: " + document.getDocumentElement().getNodeName());


//        if (validate(xsd,xml)) {
//            System.out.println("Succeeded");
//        } else {
//            System.out.println("Failure");
//        }
    }

    public static boolean validate(String xsd,String xml) {
        try {
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            ClassLoader classLoader = com.solvd.app.parsersexercise.stax.Main.class.getClassLoader();
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

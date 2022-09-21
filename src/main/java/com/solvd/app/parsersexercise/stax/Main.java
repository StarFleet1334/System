package com.solvd.app.parsersexercise.stax;

import com.solvd.app.tables.Users;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

public class Main {
    private static final String name = "staxXml/person.xml";
    private static final String schema = "staxXml/person.xsd";
    public static void main(String[] args) throws XMLStreamException, FileNotFoundException, URISyntaxException {
        ParseXml parseXml = new ParseXml();
        List<Users> lst = parseXml.parse(name);
        for (Users x : lst) {
            System.out.println(x.getId() + " " + x.getFull_name() + " " +
                    x.getAge());
            System.out.println("Phone: ");
            System.out.println(x.getPhone().getId() + " " + x.getPhone().getFull_name() + " " + x.getPhone().getPhone_number());
        }
//        if (validate(schema,name)) {
//            System.out.println("Success");
//        } else {
//            System.out.println("failure");
//        }
    }


    public static boolean validate(String xsd,String xml) {
        try {
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            ClassLoader classLoader = Main.class.getClassLoader();
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

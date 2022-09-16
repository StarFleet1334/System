package com.solvd.app.parsersExercise.stax;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;

public class ReadXml {
    private static final Logger logger = LogManager.getLogger(ReadXml.class);

    public void printXml(Path path) throws FileNotFoundException, XMLStreamException, URISyntaxException {
        // We create factory to then create event reader,we use Stream reader
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        // Because in stax we read XML File as stream of events

        // Getting file from resources
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(path.toString());

        assert resource != null;
        XMLStreamReader reader = xmlInputFactory.createXMLStreamReader(
                new FileInputStream(new File(resource.toURI()))
        );

        int event_type = reader.getEventType(); // 7 as start_document

        while (reader.hasNext()) {
            event_type = reader.next();

            if (event_type == XMLEvent.START_ELEMENT) {

                switch (reader.getName().getLocalPart()) {

                    case "person":
                        String id = reader.getAttributeValue(null,"id");
                        logger.info("User id : " + id);
                        break;

                    case "name":
                        event_type = reader.next();
                        if (event_type == XMLEvent.CHARACTERS) {
                            logger.info("Name : " + reader.getText());
                        }
                        break;

                    case "age":
                        event_type = reader.next();
                        if (event_type == XMLEvent.CHARACTERS) {
                            logger.info("Age: " + reader.getText());
                        }
                        break;

                    case "phone":
                        String phone_id = reader.getAttributeValue(null,"id");
                        logger.info("User - Phone id : " + phone_id);
                        break;

                    case "nick_name":
                        event_type = reader.next();
                        if (event_type == XMLEvent.CHARACTERS) {
                            logger.info("NickName : " + reader.getText());
                        }
                        break;

                    case "phone_number":
                        event_type = reader.next();
                        if (event_type == XMLEvent.CHARACTERS) {
                            logger.info("PhoneNumber : " + reader.getText());
                        }
                        break;
                }
            }
            if (event_type == XMLEvent.END_ELEMENT) {
                if (reader.getName().getLocalPart().equals("person")) {
                    logger.info("-------------------------");
                }
            }
        }

    }
}

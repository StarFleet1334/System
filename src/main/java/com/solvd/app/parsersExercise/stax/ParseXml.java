package com.solvd.app.parsersExercise.stax;

import com.solvd.app.tables.Phones;
import com.solvd.app.tables.Users;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ParseXml {

    // In this case I am gonna use Database table Users

    public List<Users> parse(String path) throws URISyntaxException, FileNotFoundException, XMLStreamException {
        List<Users> list = new ArrayList<>();

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

        Users user = null;
        Phones phone =null;

        while (reader.hasNext()) {
            event_type = reader.next();

            if (event_type == XMLEvent.START_ELEMENT) {

                switch (reader.getName().getLocalPart()) {

                    case "person":
                        user = new Users();
                        String id = reader.getAttributeValue(null,"id");
                        if (id != null) {
                            user.setId(Integer.parseInt(id));
                        }
                        break;

                    case "name":
                        event_type = reader.next();
                        if (event_type == XMLEvent.CHARACTERS) {
                            if (reader.getText() != null) {
                                assert user != null;
                                user.setFull_name(reader.getText());
                            }
                        }
                        break;

                    case "age":
                        event_type = reader.next();
                        if (event_type == XMLEvent.CHARACTERS) {
                            if (reader.getText() != null) {
                                assert user != null;
                                user.setAge(Integer.parseInt(reader.getText()));
                            }
                        }
                        break;

                    case "phone":
                        phone = new Phones();
                        String phone_id = reader.getAttributeValue(null,"id");
                        phone.setId(Integer.parseInt(phone_id));
                        break;

                    case "nick_name":
                        event_type = reader.next();
                        if (event_type == XMLEvent.CHARACTERS) {
                            if (reader.getText() != null) {
                                assert phone != null;
                                phone.setFull_name(reader.getText());
                            }
                        }
                        break;

                    case "phone_number":
                        event_type = reader.next();
                        if (event_type == XMLEvent.CHARACTERS) {
                            if (reader.getText() != null) {
                                assert phone != null;
                                phone.setPhone_number(reader.getText());
                            }
                        }
                        break;
                }
            }
            if (event_type == XMLEvent.END_ELEMENT) {
                if (reader.getName().getLocalPart().equals("person")) {
                    assert user != null;
                    user.setPhone(phone);
                    list.add(user);
                }
            }
        }
        return list;
    }
}

package com.solvd.app.parsersExercise.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;

public class JAXBHandler {

    public void marshal(Restaurant restaurant) throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(Restaurant.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
        marshaller.marshal(restaurant,new FileOutputStream("./src/main/resources/jaxbXml/restaurant.xml"));

    }

    public Restaurant unmarshal() throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(Restaurant.class);
        return (Restaurant) context.createUnmarshaller().unmarshal(new FileReader("./src/main/resources/jaxbXml/restaurant.xml"));
    }
}

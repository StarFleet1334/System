package com.solvd.app.jackson;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;


import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonHandler {

    public Company jsonToObject() throws IOException, URISyntaxException {

        ObjectMapper objectMapper = new ObjectMapper();

        Company company = objectMapper.readValue(new File("C:\\Users\\latar\\system\\src\\main\\resources\\json\\company.json"),Company.class);

        String answer = objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(company);

//        System.out.println(answer);
        return company;
    }


    public void objectToJson(Company company) throws IOException, URISyntaxException {
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.writeValue(new File("C:\\Users\\latar\\system\\src\\main\\resources\\json\\comp.json"),company);

//        String answer = objectMapper.writerWithDefaultPrettyPrinter()
//                .writeValueAsString(company);
//        System.out.println(answer);
    }

}

package com.solvd.app.parsersexercise.sax;

import com.solvd.app.tables.CodeSalaries;
import com.solvd.app.tables.Jobs;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SaxHandler extends DefaultHandler {
    private List<Jobs> lst = null;
    private Jobs jobs = null;
    private CodeSalaries codeSalaries = null;
    private StringBuilder stringBuilder = null;

    // Fields
    private boolean name = false;
    private boolean description = false;
    private boolean salary = false;

    public List<Jobs> getLst() {
        return lst;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equalsIgnoreCase("job")) {
            String id = attributes.getValue("id");
            jobs = new Jobs();
            jobs.setId(Integer.parseInt(id));
            if (lst == null) {
                lst = new ArrayList<>();
            }
        } else if (qName.equalsIgnoreCase("name")) {
            name = true;
        } else if (qName.equalsIgnoreCase("description")) {
            description = true;
        } else if (qName.equalsIgnoreCase("details")) {
            String id = attributes.getValue("id");
            codeSalaries = new CodeSalaries();
            codeSalaries.setId(Integer.parseInt(id));
        } else if (qName.equalsIgnoreCase("salary")) {
            salary = true;
        }
        stringBuilder = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (name) {
            jobs.setName(stringBuilder.toString());
            name = false;
        } else if (description) {
            jobs.setDescription(stringBuilder.toString());
            description = false;
        } else if (salary) {
            codeSalaries.setSalary(Double.parseDouble(stringBuilder.toString()));
            salary = false;
        }

        if (qName.equalsIgnoreCase("job")) {
            jobs.setCode(codeSalaries);
            lst.add(jobs);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        stringBuilder.append(new String(ch,start,length));
    }
}

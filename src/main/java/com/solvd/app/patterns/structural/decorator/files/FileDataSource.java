package com.solvd.app.patterns.structural.decorator.files;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class FileDataSource implements DataSource{
    private String name;
    private static final Logger LOGGER = LogManager.getLogger(FileDataSource.class);

    public FileDataSource(String name) {
        this.name = name;
    }

    @Override
    public void writeData(String data) {
        File file = new File(name);
        try (OutputStream fos = new FileOutputStream(file)) {
            fos.write(data.getBytes(),0,data.length());
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public String readData() {
        char[] buffer = null;
        File file = new File(name);
        try (FileReader reader = new FileReader(file)) {
            buffer = new char[(int) file.length()];
            reader.read(buffer);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        assert buffer != null;
        return new String(buffer);
    }
}

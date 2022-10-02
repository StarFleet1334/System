package com.solvd.app.patterns.structural.decorator.files;

public interface DataSource {
    void writeData(String data);
    String readData();
}

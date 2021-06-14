package com.loader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.metro.Metro;

public class Loader {
    private Metro metro;

    public Loader() {
        metro = new Metro();
    }

    public Metro loadFile(File file) throws  IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        loadStation(bufferedReader);
        String line = bufferedReader.readLine();
        while (line != null && line.length() > 0) {
            loadConnection(bufferedReader, line);
            line = bufferedReader.readLine();
        }
        return metro;
    }

    private void loadStation(BufferedReader bufferedReader) throws IOException {
        String name = bufferedReader.readLine();
        while (name != null && name.length() > 0) {
            metro.addStations(name);
            name = bufferedReader.readLine();            
        }
    }

    private void loadConnection(BufferedReader bufferedReader, String line) throws IOException {
        String name1 = bufferedReader.readLine();
        String name2 = bufferedReader.readLine();
        while (name2 != null && name2.length() > 0) {
            metro.addConnection(name1, name2, line);
            name1 = name2;
            name2 = bufferedReader.readLine();
        }
    }

}
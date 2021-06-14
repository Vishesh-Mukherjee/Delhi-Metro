package com.metro;

import java.io.File;

import com.loader.Loader;
import com.printer.Printer;

public class App {
    public static void main(String[] args) throws Exception {
        Loader loader = new Loader();
        Metro metro = loader.loadFile(new File("Map.txt"));
        //metro.getStations().forEach(System.out::println);
        //metro.getConnections().forEach(System.out::println);
        //metro.getNetwork().entrySet().forEach(System.out::println);
        Printer printer = new Printer();
        printer.printDirection(metro.getDirection("Shivaji Stadium", "Ashram")); 
    }
}

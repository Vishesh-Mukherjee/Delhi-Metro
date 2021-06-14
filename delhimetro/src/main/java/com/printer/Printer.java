package com.printer;

import java.util.List;

import com.metro.Connection;

public class Printer {
    public void printDirection(List<Connection> direction) {
        System.out.print(direction.get(0).getLine() + ": " + direction.get(0).getStation1() + " -> " + direction.get(0).getStation2());
        for (int i = 1; i < direction.size(); i ++) {
            if (direction.get(i).getLine().equals(direction.get(i-1).getLine())) {
                System.out.print(" -> " + direction.get(i).getStation2());
            } else {
                System.out.print("\n");
                System.out.println("Change Line: " + direction.get(i-1).getLine() + " -> " + direction.get(i).getLine());
                System.out.print(direction.get(i).getLine() + ": " + direction.get(i).getStation1() + " -> " + direction.get(i).getStation2());
            }
        }

    }
}
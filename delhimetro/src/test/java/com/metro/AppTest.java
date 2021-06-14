package com.metro;

import java.io.File;
import java.io.IOException;

import com.loader.Loader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppTest {

    Loader loader;
    Metro metro;

    @BeforeEach
    public void setup() throws IOException {
        loader = new Loader();
        metro = loader.loadFile(new File("Map.txt"));
    }

    @Test
    public void stationsTest() {
        Assertions.assertEquals(256, metro.getStations().size());
    }

    @Test
    public void directionTest() {
        Assertions.assertEquals(1, metro.getDirection("Rithala", "Rohini West").size());
        Assertions.assertThrows(RuntimeException.class, () -> metro.getDirection("Rithala", "ABC"));
        Assertions.assertThrows(RuntimeException.class, () -> metro.getDirection("ABC", "Rohini West"));
        Assertions.assertEquals(9, metro.getDirection("Karol Bagh", "Dillii Haat").size());
    }

}

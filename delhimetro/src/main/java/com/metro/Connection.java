package com.metro;

import java.util.Objects;

public class Connection {
    private Station station1;
    private Station station2;
    private String line;

    public Connection(Station station1, Station station2, String line) {
        this.station1 = station1;
        this.station2 = station2;
        this.line = line;
    }

    public Station getStation1() {
        return station1;
    }

    public Station getStation2() {
        return station2;
    }

    public String getLine() {
        return line;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Connection)) {
            return false;
        }
        Connection connection = (Connection) o;
        return Objects.equals(station1, connection.station1) && 
               Objects.equals(station2, connection.station2) && 
               Objects.equals(line, connection.line);
    }

    @Override
    public int hashCode() {
        return Objects.hash(station1, station2, line);
    }

    @Override
    public String toString() {
        return station1 + " : " + station2 + " : " + line;
    }
}
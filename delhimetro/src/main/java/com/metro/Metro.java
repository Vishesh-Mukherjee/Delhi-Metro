package com.metro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Metro {
    private List<Station> stations;
    private List<Connection> connections;
    private Map<Station, List<Station>> network;

    public Metro() {
        stations = new ArrayList<>();
        connections = new ArrayList<>();
        network = new HashMap<>();
    }

    public void addStations(String name) {
        Station station = new Station(name);
        if (stations.contains(station)) 
            throw new RuntimeException("Station already exist");
        else 
            stations.add(station);
    }

    public void addConnection(String name1, String name2, String line) {
        Station station1 = new Station(name1);
        Station station2 = new Station(name2);
        if (stations.contains(station1) && stations.contains(station2)) {
            connections.add(new Connection(station1, station2, line));
            connections.add(new Connection(station2, station1, line));
            updateNetword(station1, station2);
            updateNetword(station2, station1);
        } else {
            throw new RuntimeException("Station doesn't exist");
        }
    }

    private void updateNetword(Station station1, Station station2) {
        if (network.containsKey(station1)) {
            if (!network.get(station1).contains(station2))
                network.get(station1).add(station2);
        } else {
            List<Station> temp = new ArrayList<>();
            temp.add(station2);
            network.put(station1, temp);
        }
    }

    public List<Connection> getDirection(String origin, String destination) {
        Station startStation = new Station(origin);        
        Station endStation = new Station(destination);

        validateDirection(startStation, endStation);


        List<Station> reachableStations = new ArrayList<>();
        Map<Station, Station> previousStation = new HashMap<>();
        for (Station station: network.get(startStation)) {
            if (station.equals(endStation)) 
                return Arrays.asList(getConnection(startStation, endStation));
            else {
                reachableStations.add(station);
                previousStation.put(station, startStation);
            } 
        }

        List<Station> nextStations = network.get(startStation);
        searchLoop:
        for (int i = 1; i < stations.size();  i++) {
            List<Station> tempNextStations = new ArrayList<>();
            for (Station currentStation : nextStations) {
                reachableStations.add(currentStation);
                for (Station neighborStation: network.get(currentStation)) {
                    if (neighborStation.equals(endStation)) {
                        reachableStations.add(neighborStation);
                        previousStation.put(neighborStation, currentStation);
                        break searchLoop;
                    } else if (!reachableStations.contains(neighborStation)) {
                        reachableStations.add(neighborStation);
                        previousStation.put(neighborStation, currentStation);
                        tempNextStations.add(neighborStation);
                    }
                }
            }
            nextStations = tempNextStations; 
        }
    
        List<Connection> result = new ArrayList<>();
        Station keyStation = endStation;
        Station station;
        while(true) {
            station = previousStation.get(keyStation);
            result.add(0, getConnection(station, keyStation));
            if (startStation.equals(station))
                break;
            keyStation = station;
        }
        return result;
    }

    private void validateDirection(Station station1, Station station2) {
        if (!stations.contains(station1) || !stations.contains(station2))
            throw new RuntimeException("Invalid Path");
    }

    private Connection getConnection(Station station1, Station station2) {
        for (Connection connection: connections) {
            if (connection.getStation1().equals(station1) && connection.getStation2().equals(station2)) 
                return connection;
        }
        return null;
    }

    public List<Station> getStations() {
        return stations;
    }

    public List<Connection> getConnections() {
        return connections;
    }

    public Map<Station, List<Station>> getNetwork() {
        return network;
    }
}
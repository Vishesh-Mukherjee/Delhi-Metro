# Delhi-Metro
A console based application that finds the smallest distance between two stations. It uses Dijkstra's algorithm. All the stations can be represented as nodes(or vertices) and lines can be represented as edges(or links). The graph is begin created by reading the content from a txt file. The content of the txt file is begin converted into stations, lines and a network. The Structure of txt file is as followed. </br>
</br>
Structure of txt file: </br>
StationA</br>
StationB</br>
StationC</br> 
StationD</br>
StationE</br>
StationF</br>
</br>
LineA</br>
StationA</br>
StationB</br>
StationC</br>
StationA</br>
</br>
LineB</br>
StationB</br>
StationD</br>
StationE</br>
StationB</br>
</br>
LineC</br>
StationC</br>
StationF</br>
StationC</br>
</br>
Note: It is assumed that all the lines are forming a closed-shape.</br>
</br>
Simple testing is done using JUnit. Use-case and class diagram is also provided. Txt File contains all the stations and lines of Delhi-Metro.
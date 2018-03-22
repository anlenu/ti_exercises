import org.jgrapht.Graph;
import org.jgrapht.graph.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class jgTest {
    public static void main(String[] args) throws Exception{

        File fileDir = new File("C:/FH/ti_exercises/src/main/resources/graphen/Dijkstra.txt");

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(fileDir), "UTF8"));

        SimpleDirectedWeightedGraph<String, DefaultWeightedEdge>  graph =
                new SimpleDirectedWeightedGraph<String, DefaultWeightedEdge>
                        (DefaultWeightedEdge.class);


        String text ="";
        String line = reader.readLine();
        while (line!=null){

            List<String> items = Arrays.asList(line.split(" "));
                if (items.get(0).equals("knoten")){
                    graph.addVertex(items.get(1));
                    System.out.println("ein Knoten");
                }
                else if (items.get(0).equals("kante")){
                    DefaultWeightedEdge tempEdge = graph.getEdge(items.get(1), items.get(2));

                    if(items.get(3) != null){
                        graph.setEdgeWeight(tempEdge, Integer.parseInt(items.get(3)));
                    }
                }

            line = reader.readLine();
        }
    System.out.println("ende");
    }
}

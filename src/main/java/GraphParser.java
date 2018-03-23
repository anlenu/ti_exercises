import org.jgrapht.WeightedGraph;
import org.jgrapht.graph.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


@SuppressWarnings("Duplicates")

public class GraphParser {

    private Scanner scanner = new Scanner(System.in);

    public void parse() throws Exception{
        System.out.println("Graphart eingeben: %n 1 Ungerichteter und ungewerteter Graph %n 2 Gewichteter Graph %n 3 Gerichteter und gewichteter Graph %n");

        int userIn = scanner.nextInt();

        File fileDir = new File("C:/FH/ti_exercises/src/main/resources/graphen/Dijkstra.txt");

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(fileDir), "UTF8"));

        switch (userIn) {
            case 1:
                einfacherGraph(reader);
                break;
            case 2:
                gewichteterGraph(reader);
                break;
            case 3:
                gewichteterGerichteterGraph(reader);
                break;
        }
    }

    public SimpleGraph einfacherGraph(BufferedReader reader) throws Exception{
        /*SimpleDirectedWeightedGraph<String, DefaultWeightedEdge> graph =
                new SimpleDirectedWeightedGraph<String, DefaultWeightedEdge>
                        (DefaultWeightedEdge.class);*/
        SimpleGraph<String, DefaultEdge> graph =
                new SimpleGraph<String, DefaultEdge>
                        (DefaultEdge.class);

        String line = reader.readLine();

        while (line!=null){

            List<String> items = Arrays.asList(line.split(" "));

            if (items.get(0).equals("knoten")){
                graph.addVertex(items.get(1));
            }
            else if (items.get(0).equals("kante")){
                DefaultEdge tempEdge = graph.getEdge(items.get(1), items.get(2));
            }

            line = reader.readLine();
        }
        System.out.println("ende");

        return graph;
    }

    public WeightedGraph gewichteterGraph(BufferedReader reader) throws Exception {
         /*SimpleDirectedWeightedGraph<String, DefaultWeightedEdge> graph =
                new SimpleDirectedWeightedGraph<String, DefaultWeightedEdge>
                        (DefaultWeightedEdge.class);*/
        SimpleWeightedGraph<String, DefaultWeightedEdge> graph =
                new SimpleWeightedGraph<String, DefaultWeightedEdge>
                        (DefaultWeightedEdge.class);

        String line = reader.readLine();

        while (line != null) {

            List<String> items = Arrays.asList(line.split(" "));

            if (items.get(0).equals("knoten")) {
                graph.addVertex(items.get(1));
            } else if (items.get(0).equals("kante")) {
                DefaultWeightedEdge tempEdge = graph.getEdge(items.get(1), items.get(2));

                if(items.get(3) != null){
                    graph.setEdgeWeight(tempEdge, Integer.parseInt(items.get(3)));
                }
            }

            line = reader.readLine();
        }

        System.out.println("ende");
        return graph;
    }

    public SimpleDirectedWeightedGraph<String, DefaultWeightedEdge> gewichteterGerichteterGraph(BufferedReader reader) throws Exception{
        SimpleDirectedWeightedGraph<String, DefaultWeightedEdge> graph =
                new SimpleDirectedWeightedGraph<String, DefaultWeightedEdge>
                        (DefaultWeightedEdge.class);
        String line = reader.readLine();

        while (line != null) {

            List<String> items = Arrays.asList(line.split(" "));

            if (items.get(0).equals("knoten")) {
                graph.addVertex(items.get(1));
            } else if (items.get(0).equals("kante")) {
                DefaultWeightedEdge tempEdge = graph.getEdge(items.get(1), items.get(2));
                DefaultWeightedEdge tempEdge2 = graph.getEdge(items.get(2), items.get(1));

                if(items.get(3) != null){
                    graph.setEdgeWeight(tempEdge, Integer.parseInt(items.get(3)));
                    graph.setEdgeWeight(tempEdge2, Integer.parseInt(items.get(4)));
                }
            }

            line = reader.readLine();
        }
        return graph;
    }


}

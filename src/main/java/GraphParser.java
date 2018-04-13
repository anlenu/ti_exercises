import org.jgrapht.Graph;
import org.jgrapht.WeightedGraph;
import org.jgrapht.graph.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


//@SuppressWarnings("Duplicates")

public class GraphParser {

    private Scanner scanner = new Scanner(System.in);

    public Graph parse(String fileName) throws Exception{
        System.out.printf("Graphart eingeben: %n 1 Ungerichteter und ungewerteter Graph %n 2 Gewichteter Graph %n 3 Gerichteter und gewichteter Graph %n");

        int userIn = scanner.nextInt();

        File fileDir = new File("C:/FH/ti_exercises/src/main/resources/graphen/"+fileName);

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(fileDir), "UTF8"));

        switch (userIn) {
            case 1:
                return einfacherGraph(reader);
            case 2:
                return gewichteterGraph(reader);
            case 3:
                return gewichteterGerichteterGraph(reader);
        }

        return null;
    }

    public SimpleGraph einfacherGraph(BufferedReader reader) throws Exception{

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
                graph.addEdge(items.get(1), items.get(2));
            }

            line = reader.readLine();
        }
        return graph;
    }


    public WeightedGraph gewichteterGraph(BufferedReader reader) throws Exception {

        SimpleWeightedGraph<String, DisplayWeightEdges> graph =
                new SimpleWeightedGraph<String, DisplayWeightEdges>
                        (DisplayWeightEdges.class);

        String line = reader.readLine();

        while (line != null) {

            List<String> items = Arrays.asList(line.split(" "));

            if (items.get(0).equals("knoten")) {
                graph.addVertex(items.get(1));
            } else if (items.get(0).equals("kante")) {

                DisplayWeightEdges tempEdge = graph.addEdge(items.get(1), items.get(2));


                if(items.get(3) != null){
                    graph.setEdgeWeight(tempEdge, Double.parseDouble(items.get(3)));
                }
            }

            line = reader.readLine();
        }

        System.out.println("ende");
        return graph;
    }

    public SimpleDirectedWeightedGraph<String, DisplayWeightEdges> gewichteterGerichteterGraph(BufferedReader reader) throws Exception{
        SimpleDirectedWeightedGraph<String, DisplayWeightEdges> graph =
                new SimpleDirectedWeightedGraph<String, DisplayWeightEdges>
                        (DisplayWeightEdges.class);
        String line = reader.readLine();

        while (line != null) {

            List<String> items = Arrays.asList(line.split(" "));

            if (items.get(0).equals("knoten")) {
                graph.addVertex(items.get(1));
            } else if (items.get(0).equals("kante")) {
                DisplayWeightEdges tempEdge = graph.addEdge(items.get(1), items.get(2));
                DisplayWeightEdges tempEdge2 = graph.addEdge(items.get(2), items.get(1));

                if(items.get(3) != null && items.get(4) != null){
                    graph.setEdgeWeight(tempEdge, Double.parseDouble(items.get(3)));
                    graph.setEdgeWeight(tempEdge2, Double.parseDouble(items.get(4)));
                }
            }

            line = reader.readLine();
        }
        return graph;
    }


}

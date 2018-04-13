import com.jgraph.layout.JGraphFacade;
import com.jgraph.layout.JGraphLayout;
import com.jgraph.layout.graph.JGraphAnnealingLayout;
import com.jgraph.layout.hierarchical.JGraphHierarchicalLayout;
import com.jgraph.layout.organic.JGraphOrganicLayout;
import com.jgraph.layout.organic.JGraphSelfOrganizingOrganicLayout;
import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.model.MutableGraph;
import guru.nidi.graphviz.parse.Parser;
import org.jgraph.JGraph;
import org.jgrapht.Graph;
import org.jgrapht.ext.DOTExporter;
import org.jgrapht.ext.JGraphModelAdapter;
import guru.nidi.graphviz.*;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.util.Map;

public class jgTest {
    public static void main(String[] args){
        GraphParser graphParser = new GraphParser();

       try {
            Graph parsedGraph = graphParser.parse("Euler1.txt");

            JFrame frame = new JFrame();
            frame.setSize(900, 700);
            JGraph jgraph = new JGraph(new JGraphModelAdapter(parsedGraph));

//            JGraphLayout layout = new JGraphOrganicLayout();
//
//            JGraphFacade facade = new JGraphFacade(jgraph);
//            layout.run(facade);
//
//            Map nested = facade.createNestedMap(false, false);
//            jgraph.getGraphLayoutCache().edit(nested);
//
//            frame.getContentPane().add(jgraph);
//            frame.setVisible(true);

           DOTExporter exporter = new DOTExporter();
           String targetDirectory = "src/main/resources/output/graph/";
           new File(targetDirectory).mkdirs();
           exporter.export(new FileWriter(targetDirectory + "initial-graph.dot"), parsedGraph);

            while (true) { Thread.sleep(2000); }

       } catch (Exception e) {
           e.printStackTrace();
       }
    }


}

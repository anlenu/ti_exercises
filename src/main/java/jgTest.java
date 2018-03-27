import org.jgrapht.Graph;

public class jgTest {
    public static void main(String[] args){
        GraphParser graphParser = new GraphParser();

        try {
            Graph parsedGraph = graphParser.parse("CirculationDemandsLowerBounds.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

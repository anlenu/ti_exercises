import org.jgrapht.graph.DefaultWeightedEdge;

public class DisplayWeightEdges extends DefaultWeightedEdge{

    @Override
    public String toString() {
        return String.valueOf(super.getWeight());
    }
}

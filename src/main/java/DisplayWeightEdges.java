import org.jgrapht.graph.DefaultWeightedEdge;

public class DisplayWeightEdgle extends DefaultWeightedEdge{

    @Override
    public String toString() {
        return String.valueOf(super.getWeight());
    }
}

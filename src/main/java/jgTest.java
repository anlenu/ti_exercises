public class jgTest {
    public static void main(String[] args){
        GraphParser graphParser = new GraphParser();

        try {
            graphParser.parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

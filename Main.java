public class Main {
    public static void main(String[] args) {
        Graph<Character> characterGraph = new Graph<>();

        // Initial Setup
        characterGraph.addNode('A');
        characterGraph.addNode('B');
        characterGraph.addNode('C');
        characterGraph.addNode('D');
        characterGraph.addNode('E');
        characterGraph.addNode('F');
        characterGraph.addNode('G');

        // Node A Connection Setup
        characterGraph.addConnection('A', 'B', 4);
        characterGraph.addConnection('A','C', 2);

        // Node B Connection Setup
        characterGraph.addConnection('B', 'C', 3);
        characterGraph.addConnection('B','E',4);
        characterGraph.addConnection('B','D',7);

        //Node C Setup
        characterGraph.addConnection('C', 'D', 3);

        // Node D Setup
        characterGraph.addConnection('D', 'E', 1);
        characterGraph.addConnection('D', 'F',2);

        // Node E Setup
        characterGraph.addConnection('E', 'G', 7);
        characterGraph.addConnection('E', 'F', 5);

        // Node F Setup
        characterGraph.addConnection('F', 'G', 5);

        // Other Stuff
        System.out.println(characterGraph.Display());
        characterGraph.Dijkstra('A');

    }
}

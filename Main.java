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
        characterGraph.addNode('H');
        characterGraph.addNode('I');
        characterGraph.addNode('J');

        // Node A Connection Setup
        characterGraph.addConnection('A', 'B', 4);
        characterGraph.addConnection('A','C', 5);
        characterGraph.addConnection('A','D', 8);

        // Node B Connection Setup
        characterGraph.addConnection('B','E',12);
        characterGraph.addConnection('B','D',3);

        //Node C Setup
        characterGraph.addConnection('C', 'D', 1);
        characterGraph.addConnection('C', 'F', 11);

        // Node D Setup
        characterGraph.addConnection('D', 'E', 9);
        characterGraph.addConnection('D', 'F',4);
        characterGraph.addConnection('D', 'G', 10);

        // Node E Setup
        characterGraph.addConnection('E', 'G', 6);
        characterGraph.addConnection('E', 'H', 10);

        // Node F Setup
        characterGraph.addConnection('F', 'G', 5);
        characterGraph.addConnection('F', 'I', 11);

        // Node G Setup
        characterGraph.addConnection('G', 'J', 15);
        characterGraph.addConnection('G', 'H', 3);
        characterGraph.addConnection('G', 'I', 5);

        // Node J setup
        characterGraph.addConnection('J', 'H', 14);
        characterGraph.addConnection('J', 'I', 8);

        // Other Stuff
        System.out.println(characterGraph.Display());
        characterGraph.Dijkstra('A');

    }
}

import java.util.ArrayList;

public class QueueNode<T> {
    private Node<T> Node;
    private int Weight;
    private QueueNode<T> PreviousNode;
    private int MAX_SIZE = 7;

    public QueueNode(Node<T> node, int weight, QueueNode<T> previousNode){
        Node = node;
        Weight = weight;
        PreviousNode = previousNode;
    }

    public void setWeight(int weight){
        Weight = weight;
    }

    public int getWeight(){
        return Weight;
    }

    public Node<T> getNode(){
        return Node;
    }

    public void setNode(Node node){
        Node = node;
    }

    public QueueNode<T> getPreviousNode() {
        return PreviousNode;
    }

    public void setPreviousNode(QueueNode<T> previousNode) {
        PreviousNode = previousNode;
    }
    
    public String Path(){
        ArrayList<T> nodes = new ArrayList<>(MAX_SIZE);
        int i = 0;
        QueueNode<T> Tracer;
        Tracer = PreviousNode;
        String Sentance = "";
        StringBuilder IDK = new StringBuilder();
        
        while(Tracer != null){
            nodes.add(Tracer.getNode().getNode());
            Tracer = Tracer.PreviousNode;
        }
        for(T node: nodes){
            Sentance += (" " + node);
        }
        IDK.append(Sentance);
        IDK.reverse();
        Sentance = IDK.toString();
        return Sentance;
    }
}
